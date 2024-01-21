package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;

public class ConversionUtil {
    @NotNull
    public static String converted(@NotNull String id) {
        return switch (id.replace("FIGHT_PROP_", "")) {
            case "ATTACK"            -> "ATK";
            case "ATTACK_PERCENT"    -> "ATK%";
            case "DEFENSE"           -> "DEF";
            case "DEFENSE_PERCENT"   -> "DEF%";
            case "HP"                -> "HP";
            case "HP_PERCENT"        -> "HP%";
            case "CRITICAL"          -> "CR";
            case "CRITICAL_HURT"     -> "CD";
            case "CHARGE_EFFICIENCY" -> "ER";
            case "ELEMENT_MASTERY"   -> "EM";
            case "HEAL_ADD"          -> "HB";
            default -> "ED";
        };
    }
}
