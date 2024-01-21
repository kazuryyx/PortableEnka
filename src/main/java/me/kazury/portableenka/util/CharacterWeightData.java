package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CharacterWeightData {
    @NotNull
    private final Map<String, Double> weightMap;

    public CharacterWeightData(@NotNull Map<String, Double> weightMap) {
        this.weightMap = weightMap;
    }

    @NotNull
    public Map<String, Double> getWeightMap() {
        return this.weightMap;
    }
}
