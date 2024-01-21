package me.kazury.portableenka.util;

import me.kazury.enkanetworkapi.enka.EnkaNetworkAPI;
import me.kazury.enkanetworkapi.genshin.data.GenshinAffix;
import me.kazury.enkanetworkapi.genshin.data.GenshinArtifact;
import me.kazury.enkanetworkapi.genshin.data.GenshinRollData;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RatingUtil {
    private static final List<String> flatProps = List.of(
            "FIGHT_PROP_ATTACK",
            "FIGHT_PROP_DEFENSE",
            "FIGHT_PROP_HP"
    );

    @NotNull
    public static RawRating getRating(@NotNull EnkaNetworkAPI api,
                                      @NotNull List<Map.Entry<String, Double>> sortedWeights,
                                      @NotNull GenshinArtifact artifact) {
        final GenshinRollData rollData = artifact.getRollData(api);
        final double maxPoints = getMaxPoints(sortedWeights, artifact);

        double sum = 0;

        for (Map.Entry<Integer, Double> entry : rollData.getEfficiencyList().entrySet()) {
            final int key = entry.getKey();
            final double totalValue = roundDouble(entry.getValue(), 2);
            final int rvCount = getRollValueCount(totalValue);

            final double rVal = roundDouble(totalValue / rvCount, 1);

            final GenshinAffix affix = api.getGenshinAffix(key);
            if (affix == null) continue;
            double points = convertRVtoPoints(rVal, rvCount);

            if (flatProps.contains(affix.getPropType())) {
                points /= 2;
            }

            sum += points;
        }

        final int level = artifact.getLevel();
        final int maxLevel = artifact.getMaxLevel();
        final double remainder = (double) level / maxLevel;
        sum *= remainder;
        return new RawRating(sum, maxPoints, Math.round(sum / maxPoints * 100D));
    }

    @NotNull
    public static String getRatingTier(final double percentage) {
        if (percentage >= 0 && percentage <= 19) {
            return "F";
        } else if (percentage >= 20 && percentage <= 34) {
            return "D";
        } else if (percentage >= 35 && percentage <= 47) {
            return "C";
        } else if (percentage >= 48 && percentage <= 59) {
            return "B";
        } else if (percentage >= 60 && percentage <= 75) {
            return "A";
        } else if (percentage >= 76 && percentage <= 100) {
            return "S";
        }
        return "???";
    }

    @NotNull
    public static String getRatingTier(@NotNull RawRating rating) {
        final double percentage = rating.getPercentage();
        return getRatingTier(percentage);
    }

    private static int getRollValueCount(final double rv) {
        int out = 0;
        for (double i = 0.7d; i <= 1.0d; i += 0.1d) {
            if (rv % i < 0.001d) out = (int) (rv / i);
        }
        return out;
    }

    private static double convertRVtoPoints(final double rv, final int rvCount) {
        return (10 * rv - 6) * rvCount;
    }

    private static double roundDouble(double value, double places) {
        if (places < 0) places = 1;

        final long factor = (long) Math.pow(10, places);
        final long tmp = Math.round(value * factor);
        return (double) tmp / factor;
    }

    private static double getMaxPoints(@NotNull List<Map.Entry<String, Double>> sortedWeights,
                                       @NotNull GenshinArtifact artifact) {
        final String convertedStat = switch (artifact.getMainStats().getStat().replace("FIGHT_PROP_", "")) {
            case "ATTACK" -> "ATK";
            case "ATTACK_PERCENT" -> "ATK%";
            case "DEFENSE" -> "DEF";
            case "DEFENSE_PERCENT" -> "DEF%";
            case "HP" -> "HP";
            case "HP_PERCENT" -> "HP%";
            case "CRITICAL" -> "CR";
            case "CRITICAL_HURT" -> "CD";
            case "CHARGE_EFFICIENCY" -> "ER";
            case "ELEMENT_MASTERY" -> "EM";
            case "HEAL_ADD" -> "HB";
            default -> "ED";
        };
        final int subStatCount = artifact.getSubStats().size();

        double out = 0;
        for (int i = 0; i < subStatCount; i++) {
            final Map.Entry<String, Double> entry = sortedWeights.get(i);
            final String key = entry.getKey();
            final double value = entry.getValue();

            if (key.equals(convertedStat)) {
                out += (2.5 * subStatCount) * value;
                continue;
            }

            out += subStatCount * value;
        }
        return out + (5 * subStatCount);
    }
}
