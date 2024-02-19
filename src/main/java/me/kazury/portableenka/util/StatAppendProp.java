package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum StatAppendProp {
    HP,
    ATK,
    DEF,

    CRIT_RATE,
    CRIT_DMG,

    ELEMENTAL_MASTERY,
    ENERGY_RECHARGE,

    HEALING_BONUS,
    ELEMENTAL_BONUS;

    @Nullable
    public static StatAppendProp of(@NotNull String text) {
        if (text.split(" ").length > 1) {
            text = parse(text);
        }

        return switch (text) {
            case "HP" -> HP;
            case "ATK" -> ATK;
            case "DEF" -> DEF;
            case "CRIT Rate" -> CRIT_RATE;
            case "CRIT DMG" -> CRIT_DMG;
            case "Elemental Mastery" -> ELEMENTAL_MASTERY;
            case "Energy Recharge" -> ENERGY_RECHARGE;
            case "Healing Bonus" -> HEALING_BONUS;
            default -> {
                if (text.isBlank()) {
                    yield null;
                }
                System.out.println("Unknown stat: " + text);
                yield null;
            }
        };
    }

    /**
     * This shit messy, but I don't bother :skull:
     */
    @NotNull
    private static String parse(@NotNull String text) {
        final String[] split = text.split(" ");

        if (split.length == 2) {
            String string = split[0];
            if (string.equals("CRIT") || string.equals("Energy") || string.equals("Healing") || string.equals("Elemental")) {
                string += " " + split[1];
            }
            return string;
        }
        if (split.length == 3) {
            return split[0] + " " + split[1];
        }
        if (split.length == 4) {
            return split[0] + " " + split[1] + " " + split[2];
        }
        return text;
    }
}
