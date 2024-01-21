package me.kazury.portableenka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.kazury.enkanetworkapi.genshin.data.GenshinCharacterData;
import me.kazury.enkanetworkapi.genshin.data.GenshinUserInformation;
import me.kazury.portableenka.util.CharacterWeightData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnkaCache {
    @NotNull
    private final Map<String, CharacterWeightData> weightData = new HashMap<>();
    private final Map<String, ImageIcon> weaponIcons = new HashMap<>();

    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @Nullable
    private GenshinUserInformation currentInformation;

    public EnkaCache() {
        this.loadWeights();
        this.loadWeaponIcons();
    }

    private void loadWeights() {
        final ObjectMapper mapper = new ObjectMapper();

        try (InputStream stream = classLoader.getResourceAsStream("characterweights.json")) {
            if (stream == null) throw new IOException("Could not find characterweights.json");

            final JsonNode node = mapper.convertValue(mapper.readTree(stream), JsonNode.class);

            node.fields().forEachRemaining(entry -> {
                final String characterId = entry.getKey();
                final JsonNode weightMap = entry.getValue();
                final Map<String, Double> convertedWeightMap = new HashMap<>();

                weightMap.fields().forEachRemaining((weightEntry) -> {
                    final String convertedWeight = weightEntry.getKey();
                    final double weight = weightEntry.getValue().asDouble();

                    convertedWeightMap.put(convertedWeight, weight);
                });
                weightData.put(characterId, new CharacterWeightData(convertedWeightMap));
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void loadWeaponIcons() {
        final List<String> names = List.of("ATK",
                "CRIT DMG",
                "CRIT Rate",
                "DEF",
                "Elemental Mastery",
                "Energy Recharge",
                "HP",
                "Physical DMG Bonus"
        );

        for (String s : names) {
            final String path = "weapon_icons/" + s + ".png";
            final URL resource = classLoader.getResource(path);
            if (resource == null) continue;
            final ImageIcon icon = new ImageIcon(resource);

            weaponIcons.put(s, icon);
        }
    }

    @Nullable
    public ImageIcon getWeaponIcon(@NotNull String name) {
        return this.weaponIcons.get(name);
    }

    @NotNull
    public CharacterWeightData getData(@NotNull GenshinCharacterData character) {
        return this.weightData.get(character.getCharacterId());
    }

    public void setCurrentInformation(@Nullable GenshinUserInformation currentInformation) {
        this.currentInformation = currentInformation;
    }

    @Nullable
    public GenshinUserInformation getCurrentInformation() {
        return this.currentInformation;
    }
}
