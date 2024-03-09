package me.kazury.portableenka;

import me.kazury.enkanetworkapi.enka.EnkaNetworkAPI;
import me.kazury.enkanetworkapi.genshin.data.*;
import me.kazury.enkanetworkapi.util.exceptions.NiceJobException;
import me.kazury.enkanetworkapi.util.exceptions.PlayerDoesNotExistException;
import me.kazury.enkanetworkapi.util.exceptions.RateLimitedException;
import me.kazury.portableenka.forms.*;
import me.kazury.portableenka.util.*;
import me.kazury.portableenka.util.adapters.MouseClickAdapter;
import me.kazury.portableenka.util.adapters.MouseHoverAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class MenuManager {
    private final DecimalFormat format = new DecimalFormat("#,###");
    private final ClassLoader classLoader;

    private ImageIcon blockIcon;
    private ImageIcon userIcon;

    private RawRating flowerRating;
    private RawRating featherRating;
    private RawRating sandsRating;
    private RawRating gobletRating;
    private RawRating circletRating;

    public MenuManager() {
        this.classLoader = Thread.currentThread().getContextClassLoader();
        this.loadBlockIcon();
        this.loadUserIcon();
    }

    private void loadBlockIcon() {
        final URL blockPng = this.classLoader.getResource("block.png");
        if (blockPng == null) throw new NullPointerException("block.png not found!");

        final ImageIcon icon = new ImageIcon(blockPng);
        final int newWidth = (int) (icon.getIconWidth() * 0.19);
        final int newHeight = (int) (icon.getIconHeight() * 0.19);

        final Image image = icon.getImage();
        final Image scaled = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        this.blockIcon = new ImageIcon(scaled);
    }

    private void loadUserIcon() {
        final URL userPng = this.classLoader.getResource("user.png");
        if (userPng == null) throw new NullPointerException("user.png not found!");

        final ImageIcon icon = new ImageIcon(userPng);
        final int newWidth = (int) (icon.getIconWidth() * 0.24);
        final int newHeight = (int) (icon.getIconHeight() * 0.24);

        final Image image = icon.getImage();
        final Image scaled = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        this.userIcon = new ImageIcon(scaled);
    }

    private void dispose(@NotNull JFrame... disposable) {
        for (JFrame frame : disposable) {
            frame.dispose();
        }
    }

    public void openUIDFrame(@NotNull JFrame... disposable) {
        // this is not needed because when fetching the user, it will be re-set to that information
        Main.getCache().setCurrentInformation(null);

        final EnterUIDFrame frame = new EnterUIDFrame();
        frame.setContentPane(frame.mainPanel);
        frame.setTitle("PortableEnka - Enter UID");
        frame.setSize(GlobalConfig.UID_FRAME_SIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.afterInit();
        frame.setVisible(true);

        frame.ratingExplanationButton.addMouseListener(new MouseClickAdapter((event) -> Main.redirectToReadMe()));

        this.dispose(disposable);
    }

    @NotNull
    public ErrorFrame openErrorFrame(@NotNull String title,
                                     @NotNull String message,
                                     @NotNull JFrame... disposable) {
        final ErrorFrame frame = new ErrorFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(GlobalConfig.ERROR_FRAME_SIZE);
        frame.setTitle("PortableEnka - Error");
        frame.titleText.setText(title);
        frame.infoText.setText(message);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.dispose(disposable);
        return frame;
    }

    @NotNull
    public LoadingUIDFrame openLoadingFrame(@NotNull JFrame... disposable) {
        final LoadingUIDFrame frame = new LoadingUIDFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(GlobalConfig.LOADING_FRAME_SIZE);
        frame.setTitle("PortableEnka - Loading...");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.dispose(disposable);
        return frame;
    }

    public void openOutdatedFrame() {
        final OutdatedFrame frame = new OutdatedFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(GlobalConfig.OUTDATED_FRAME_SIZE);
        frame.setTitle("PortableEnka - Outdated version");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void openErrorExceptionFrame(@NotNull JFrame disposed, @NotNull String message) {
        final MenuManager menuManager = Main.getMenuManager();
        final ErrorFrame errorFrame = menuManager.openErrorFrame("Error", message, disposed);

        errorFrame.quitButton.addMouseListener(new MouseClickAdapter((ev) -> menuManager.openUIDFrame(errorFrame)));
    }

    public void openSelectionFrame(final long inputUID, @NotNull JFrame... disposable) {
        final SelectCharacterFrame frame = new SelectCharacterFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(GlobalConfig.SELECTION_FRAME_SIZE);
        frame.setResizable(false);
        frame.setTitle("PortableEnka - Select Character: " + inputUID);
        frame.setLocationRelativeTo(null);

        final EnkaFetcher fetcher = Main.getFetcher();
        final EnkaNetworkAPI api = fetcher.getApi();

        frame.returnButton.addMouseListener(new MouseClickAdapter((event) -> this.openUIDFrame(frame)));

        frame.viewUserLabel.setText("View Public Details");
        frame.viewUserImage.setIcon(this.userIcon);

        int componentIndex = 0;
        for (CharacterSelectionPanel component : frame.getCharacterComponents()) {
            final MouseAdapter adapter = this.getMouseAdapter(componentIndex, component, frame);

            component.getNameLabel().addMouseListener(adapter);
            component.getImageLabel().addMouseListener(adapter);
            component.getParent().addMouseListener(adapter);
            componentIndex++;
        }

        final GenshinUserInformation currentInformation = Main.getCache().getCurrentInformation();

        if (currentInformation != null && currentInformation.getUid() == inputUID) {
            // There is no need to fetch again if the UID is the same
            // If the player needs a refresh they can just query another UID and then query the same UID again
            // Therefore, this is not a bad option since there is no refresh button as well
            this.openWithInformation(frame, currentInformation, disposable);
            return;
        }

        api.fetchGenshinUser(inputUID, (user) -> {
            final GenshinUserInformation information = user.toGenshinUser();

            Main.getCache().setCurrentInformation(information);

            this.openWithInformation(frame, information, disposable);
        }, (error) -> {
            final Throwable cause = error.getCause();

            if (cause instanceof PlayerDoesNotExistException) {
                this.openErrorExceptionFrame(frame, "This player does not exist.");
            } else if (cause instanceof RateLimitedException) {
                this.openErrorExceptionFrame(frame, "Rate limited. Please try again later.");
            } else if (cause instanceof NiceJobException) {
                this.openErrorExceptionFrame(frame, "Nice job. Algoinde broke the API.");
            }
        });
    }

    public void openCardFrame(final int charIndex, @NotNull JFrame... disposable) {
        final GenshinUserInformation information = Main.getCache().getCurrentInformation();
        if (information == null) {
            throw new NullPointerException("Current information is null");
        }

        final List<GenshinUserCharacter> characters = information.getCharacters();
        if (characters.isEmpty() || characters.size() < charIndex) {
            throw new NullPointerException("Character index is out of bounds");
        }

        final JFrame loadingFrame = this.openLoadingFrame(disposable);

        final EnkaFetcher fetcher = Main.getFetcher();
        final EnkaCache cache = Main.getCache();
        final EnkaNetworkAPI api = fetcher.getApi();

        final GenshinUserCharacter character = characters.get(charIndex);
        final GenshinCharacterData data = character.getGameData();

        final String characterName = data.getName();
        final GenshinUserWeapon weapon = character.getEquippedWeapon();
        final GenshinCharacterTalents talents = character.getTalentLevels();

        final CharacterWeightData weight = Main.getCache().getData(data);
        final List<GenshinArtifact> artifacts = character.getArtifacts();
        final List<Map.Entry<String, Double>> sortedWeights = weight.getWeightMap().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

        final CharacterCardFrame frame = new CharacterCardFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(frame.mainPanel);
        frame.setSize(GlobalConfig.CARD_FRAME_SIZE);
        frame.setResizable(false);
        frame.setTitle("PortableEnka - Character Card: " + characterName + " (" + information.getUid() + ")");
        frame.setLocationRelativeTo(null);

        frame.returnButton.addMouseListener(new MouseClickAdapter((event) -> {
            final JFrame loadingFrame2 = MenuManager.this.openLoadingFrame(frame);
            MenuManager.this.openSelectionFrame(information.getUid(), frame, loadingFrame2);
        }));

        frame.nextCharacterButton.addMouseListener(new MouseClickAdapter((event) -> {
            final int nextIndex = charIndex + 1;
            if (nextIndex >= characters.size()) return;

            final JFrame loadingFrame2 = MenuManager.this.openLoadingFrame(frame);
            MenuManager.this.openCardFrame(nextIndex, frame, loadingFrame2);
        }));

        frame.explanationButton.addMouseListener(new MouseClickAdapter((event) -> Main.redirectToReadMe()));

        this.loadTopBar(api, frame, information, character);
        this.loadCharacterStats(character, frame);
        this.loadTalents(talents, api, data, frame);

        this.loadArtifactIcons(character, frame);
        this.loadArtifactLevels(frame, character);

        for (GenshinArtifactType value : GenshinArtifactType.values()) {
            this.loadDefaultArtifact(artifacts, value, frame, sortedWeights);
        }

        this.loadPoints(frame.flowerPoints, this.flowerRating, "Flower");
        this.loadPoints(frame.featherPoints, this.featherRating, "Feather");
        this.loadPoints(frame.sandsPoints, this.sandsRating, "Sands");
        this.loadPoints(frame.gobletPoints, this.gobletRating, "Goblet");
        this.loadPoints(frame.circletPoints, this.circletRating, "Circlet");

        this.loadTotalRanking(frame);
        this.loadWeapon(api, weapon, frame, cache);

        this.registerHoverListeners(frame);

        this.dispose(loadingFrame);
        frame.setVisible(true);
    }

    private void registerHoverListeners(@NotNull CharacterCardFrame frame) {
        final Map<StatAppendProp, List<JComponent>> propComponents = new HashMap<>();

        // collecting components and add to list
        propComponents.put(StatAppendProp.HP, new ArrayList<>(Arrays.asList(frame.hp, frame.hpText)));
        propComponents.put(StatAppendProp.ATK, new ArrayList<>(Arrays.asList(frame.atk, frame.atkText)));
        propComponents.put(StatAppendProp.DEF, new ArrayList<>(Arrays.asList(frame.def, frame.defText)));
        propComponents.put(StatAppendProp.CRIT_RATE, new ArrayList<>(Arrays.asList(frame.cr, frame.crText)));
        propComponents.put(StatAppendProp.CRIT_DMG, new ArrayList<>(Arrays.asList(frame.cd, frame.cdText)));
        propComponents.put(StatAppendProp.ELEMENTAL_MASTERY, new ArrayList<>(Arrays.asList(frame.em, frame.emText)));
        propComponents.put(StatAppendProp.ENERGY_RECHARGE, new ArrayList<>(Arrays.asList(frame.er, frame.erText)));
        propComponents.put(StatAppendProp.ELEMENTAL_BONUS, new ArrayList<>());

        // add all props to list
        for (GenshinArtifactType value : GenshinArtifactType.values()) {
            final JLabel mainLabel = frame.getMainLabel(value);

            for (int i = 0; i < 4; i++) {
                final JLabel subLabel = frame.getSubLabel(value, i + 1);

                final StatAppendProp prop = StatAppendProp.of(subLabel.getText());
                if (prop == null) continue;
                final List<JComponent> list = propComponents.get(prop);

                final JLabel subValueLabel = frame.getSubValueLabel(value, i + 1);

                list.add(subLabel);
                list.add(subValueLabel);
            }

            final StatAppendProp prop = StatAppendProp.of(mainLabel.getText());
            if (prop == null) continue;
            final List<JComponent> jComponents = propComponents.get(prop);
            if (jComponents == null) continue;
            jComponents.add(mainLabel);
        }

        propComponents.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> {
                    final List<JComponent> components = entry.getValue();

                    for (JComponent jComponent : components) {
                        jComponent.addMouseListener(new MouseHoverAdapter((event) -> {
                            for (JComponent component : components) {
                                component.setOpaque(true);
                                component.setBackground(Color.GRAY);
                            }
                        }, (event) -> {
                            for (JComponent component : components) {
                                component.setOpaque(false);
                                component.setBackground(null);
                            }
                        }));
                    }
                });
    }

    private void loadTotalRanking(@NotNull CharacterCardFrame frame) {
        final double totalPoints = Stream.of(this.flowerRating, this.featherRating, this.sandsRating, this.gobletRating, this.circletRating)
                .filter(Objects::nonNull)
                .map(RawRating::getSum)
                .reduce(Double::sum)
                .or(() -> Optional.of(0D))
                .get();

        final double totalMaxPoints = Stream.of(this.flowerRating, this.featherRating, this.sandsRating, this.gobletRating, this.circletRating)
                .filter(Objects::nonNull)
                .map(RawRating::getMaxPoints)
                .reduce(Double::sum)
                .or(() -> Optional.of(0D))
                .get();

        final double percentage = Math.round(totalPoints / totalMaxPoints * 100d);
        final String totalRanking = RatingUtil.getRatingTier(percentage);

        frame.totalRanking.setText(totalRanking);
    }

    private void loadWeapon(@NotNull EnkaNetworkAPI api,
                            @NotNull GenshinUserWeapon weapon,
                            @NotNull CharacterCardFrame frame,
                            @NotNull EnkaCache cache) {
        final ImageIcon weaponIcon = ImageUtil.scale(api.getGenshinIcon(weapon.getWeaponIcon()), 0.4, 0.4);
        final int stars = weapon.getStar();
        final int level = weapon.getWeaponLevel();
        final int refinement = weapon.getWeaponRefinement();
        final List<GenshinUserWeapon.WeaponStat> stats = weapon.getStats();

        final GenshinUserWeapon.WeaponStat base = stats.get(0);

        frame.weaponIcon.setIcon(weaponIcon);
        frame.weaponName.setText(weapon.getName());

        frame.refinementLabel.setText("R" + refinement);
        frame.refinementLabel.setForeground(refinement == 5 ? GlobalConfig.GOLD : Color.WHITE);

        frame.levelLabel.setText("Lv. " + weapon.getWeaponLevel());
        frame.levelLabel.setForeground(level == 90 ? GlobalConfig.GOLD : Color.WHITE);

        frame.stars.setForeground(stars == 5 ? GlobalConfig.GOLD : stars == 4 ? GlobalConfig.FOUR_STAR_COLOR : Color.GRAY);
        frame.stars.setText("⭐".repeat(weapon.getStar()));

        frame.baseAttackLabel.setText(base.getFormattedValue());
        frame.baseAttackLabel.setIcon(cache.getWeaponIcon(base.getStat()));

        if (stats.size() == 1) {
            frame.secondaryLabel.setText("");
            frame.secondaryLabel.setIcon(null);
            return;
        }

        final GenshinUserWeapon.WeaponStat secondary = stats.get(1);

        frame.secondaryLabel.setText(secondary.getFormattedValue());
        frame.secondaryLabel.setIcon(cache.getWeaponIcon(secondary.getStat()));
    }

    private void loadArtifactLevels(@NotNull CharacterCardFrame frame,
                                    @NotNull GenshinUserCharacter character) {
        final GenshinArtifact flower = this.getArtifact(character.getArtifacts(), GenshinArtifactType.FLOWER);
        final GenshinArtifact feather = this.getArtifact(character.getArtifacts(), GenshinArtifactType.FEATHER);
        final GenshinArtifact sands = this.getArtifact(character.getArtifacts(), GenshinArtifactType.SANDS);
        final GenshinArtifact goblet = this.getArtifact(character.getArtifacts(), GenshinArtifactType.GOBLET);
        final GenshinArtifact circlet = this.getArtifact(character.getArtifacts(), GenshinArtifactType.CIRCLET);

        this.loadArtifactIfPresent(flower, frame.flowerPlusLabel);
        this.loadArtifactIfPresent(feather, frame.featherPlusLabel);
        this.loadArtifactIfPresent(sands, frame.sandsPlusLabel);
        this.loadArtifactIfPresent(goblet, frame.gobletPlusLabel);
        this.loadArtifactIfPresent(circlet, frame.circletPlusLabel);
    }

    private void loadArtifactIcons(@NotNull GenshinUserCharacter character,
                                   @NotNull CharacterCardFrame frame) {
        final GenshinArtifact flower = this.getArtifact(character.getArtifacts(), GenshinArtifactType.FLOWER);
        final GenshinArtifact feather = this.getArtifact(character.getArtifacts(), GenshinArtifactType.FEATHER);
        final GenshinArtifact sands = this.getArtifact(character.getArtifacts(), GenshinArtifactType.SANDS);
        final GenshinArtifact goblet = this.getArtifact(character.getArtifacts(), GenshinArtifactType.GOBLET);
        final GenshinArtifact circlet = this.getArtifact(character.getArtifacts(), GenshinArtifactType.CIRCLET);

        this.loadImageIfPresent(flower, frame.flowerImage);
        this.loadImageIfPresent(feather, frame.featherImage);
        this.loadImageIfPresent(sands, frame.sandsImage);
        this.loadImageIfPresent(goblet, frame.gobletImage);
        this.loadImageIfPresent(circlet, frame.circletImage);
    }

    private void loadTopBar(@NotNull EnkaNetworkAPI api,
                            @NotNull CharacterCardFrame frame,
                            @NotNull GenshinUserInformation information,
                            @NotNull GenshinUserCharacter character) {
        final GenshinCharacterData data = character.getGameData();
        final ImageIcon splashArt = ImageUtil.scale(api.getGenshinIcon(data.getSplashArt()), 0.175, 0.175);

        frame.constellationLabel.setText("C" + character.getConstellation());
        frame.splashArt.setIcon(splashArt);
        frame.uidLabel.setText("UID: " + information.getUid());
    }

    private void loadTalents(@NotNull GenshinCharacterTalents talents,
                             @NotNull EnkaNetworkAPI api,
                             @NotNull GenshinCharacterData data,
                             @NotNull CharacterCardFrame frame) {
        final int naLevel = talents.getNormalAttackLevel();
        final int esLevel = talents.getElementalSkillLevel();
        final int ebLevel = talents.getElementalBurstLevel();

        final ImageIcon talent1Icon = ImageUtil.scale(api.getGenshinIcon(this.getTalentIcon(0, data)), 0.36, 0.36);
        final ImageIcon talent2Icon = ImageUtil.scale(api.getGenshinIcon(this.getTalentIcon(1, data)), 0.48, 0.48);
        final ImageIcon talent3Icon = ImageUtil.scale(api.getGenshinIcon(this.getTalentIcon(2, data)), 0.57, 0.57);

        final Color gold = GlobalConfig.GOLD;

        frame.talent1Value.setForeground(naLevel == 10 ? gold : Color.white);
        frame.talent2Value.setForeground(esLevel == 10 ? gold : Color.white);
        frame.talent3Value.setForeground(ebLevel == 10 ? gold : Color.white);

        frame.talent1Value.setText("" + naLevel);
        frame.talent2Value.setText("" + esLevel);
        frame.talent3Value.setText("" + ebLevel);

        frame.talent1Image.setIcon(talent1Icon);
        frame.talent2Image.setIcon(talent2Icon);
        frame.talent3Image.setIcon(talent3Icon);
    }

    private void loadCharacterStats(@NotNull GenshinUserCharacter character,
                                    @NotNull CharacterCardFrame frame) {
        final Map<GenshinFightProp, Double> fightProps = character.getFightProperties();

        final double maxHP = fightProps.get(GenshinFightProp.MAX_HP);
        final double currentATK = fightProps.get(GenshinFightProp.CURRENT_ATK);
        final double currentDEF = fightProps.get(GenshinFightProp.CURRENT_DEF);
        final double currentEM = fightProps.get(GenshinFightProp.ELEMENTAL_MASTERY);

        final String formattedHP = this.format.format(maxHP);
        final String formattedATK = this.format.format(currentATK);
        final String formattedDEF = this.format.format(currentDEF);
        final String formattedEM = this.format.format(currentEM);

        final double rawER = fightProps.get(GenshinFightProp.ENERGY_RECHARGE) * 100;
        final double rawCRITRate = fightProps.get(GenshinFightProp.CRITICAL_RATE) * 100;
        final double rawCRITDamage = fightProps.get(GenshinFightProp.CRITICAL_DAMAGE) * 100;

        final double formattedER = Math.floor(rawER * 10) / 10;
        final double formattedCRITRate = Math.floor(rawCRITRate * 10) / 10;
        final double formattedCRITDamage = Math.floor(rawCRITDamage * 10) / 10;

        frame.hp.setText(formattedHP);
        frame.atk.setText(formattedATK);
        frame.def.setText(formattedDEF);
        frame.em.setText(formattedEM);

        frame.er.setText(formattedER + "%");
        frame.cr.setText(formattedCRITRate + "%");
        frame.cd.setText(formattedCRITDamage + "%");
    }

    @NotNull
    private Color getColor(final double percentage) {
        final String rating = RatingUtil.getRatingTier(percentage);
        if (rating.equals("F") || rating.equals("D")) {
            return Color.red;
        }
        if (rating.equals("C") || rating.equals("B")) {
            return Color.orange;
        }
        return Color.green;
    }

    private void loadPoints(@NotNull JLabel label, @Nullable RawRating rating, @NotNull String suffix) {
        if (rating == null) {
            label.setText("   " + suffix + ": None");
            label.setForeground(Color.decode("#E5B93A"));
            return;
        }

        final double curPoints = (rating.getSum() * 100) / 100;
        final double maxPoints = (rating.getMaxPoints() * 100) / 100;
        final double percentage = rating.getPercentage();

        label.setText("   " + suffix + ": " + this.format.format(curPoints) + " pt. / " + this.format.format(maxPoints) + " pt.");
        label.setForeground(this.getColor(percentage));
    }

    @NotNull
    private String getTalentIcon(final int stop, @NotNull GenshinCharacterData gameData) {
        final Map<Integer, String> keys = gameData.getSkills();
        final List<Integer> skillOrder = gameData.getSkillOrder();
        return keys.get(skillOrder.get(stop));
    }

    @NotNull
    private MouseClickAdapter getMouseAdapter(final int i,
                                              @NotNull CharacterSelectionPanel panel,
                                              @NotNull SelectCharacterFrame frame) {
        return new MouseClickAdapter((event) -> {
            if (panel.getNameLabel().getText().equals("No Character")) {
                System.out.println("Panel has no character");
                return;
            }

            System.out.println("Attempting to open card frame");
            this.openCardFrame(i, frame);
        });
    }

    private void loadArtifactIfPresent(@Nullable GenshinArtifact artifact, @NotNull JLabel label) {
        if (artifact == null) return;

        label.setText("+" + artifact.getLevel());
    }

    private void loadImageIfPresent(@Nullable GenshinArtifact artifact, @NotNull JLabel label) {
        if (artifact == null) return;

        final EnkaNetworkAPI api = Main.getFetcher().getApi();
        final ImageIcon icon = ImageUtil.scale(api.getGenshinIcon(artifact.getIcon()), 0.4, 0.4);
        label.setIcon(icon);
    }

    private void loadDefaultArtifact(@NotNull List<GenshinArtifact> artifacts,
                                     @NotNull GenshinArtifactType type,
                                     @NotNull CharacterCardFrame frame,
                                     @NotNull List<Map.Entry<String, Double>> sortedWeights) {
        final GenshinArtifact artifact = this.getArtifact(artifacts, type);
        final JPanel artifactPanel = frame.getArtifactPanel(type);

        if (artifact == null) {
            this.setRating(type, null);
            artifactPanel.setVisible(false);
            return;
        }

        final EnkaNetworkAPI api = Main.getFetcher().getApi();

        final GenshinArtifact.ArtifactStat mainStats = artifact.getMainStats();
        final List<GenshinArtifact.ArtifactStat> subStats = artifact.getSubStats();

        final RawRating raw = RatingUtil.getRating(api, sortedWeights, artifact);
        final String rating = RatingUtil.getRatingTier(raw);

        final JLabel mainLabel = frame.getMainLabel(type);
        final JLabel ratingLabel = frame.getRatingLabel(type);

        mainLabel.setText(mainStats.getStat() + " " + mainStats.getFormattedValue());
        ratingLabel.setText(rating);

        this.setRating(type, raw);

        for (int i = 0; i < subStats.size(); i++) {
            final JLabel subLabel = frame.getSubLabel(type, i + 1);
            final JLabel subLabelValue = frame.getSubValueLabel(type, i + 1);

            final GenshinArtifact.ArtifactStat sub = subStats.get(i);

            final String stat = sub.getStat();
            final String formatted = sub.getFormattedValue();

            subLabel.setText(stat);
            subLabelValue.setText(formatted);
        }

        artifactPanel.setVisible(true);
    }

    private void openWithInformation(@NotNull SelectCharacterFrame frame,
                                     @NotNull GenshinUserInformation information, @NotNull JFrame... disposable) {
        final EnkaNetworkAPI api = Main.getFetcher().getApi();
        final List<GenshinUserCharacter> characters = information.getCharacters();
        final int missingCharacters = 8 - characters.size();

        for (int i = 0; i < characters.size(); i++) {
            final GenshinUserCharacter character = characters.get(i);
            final GenshinCharacterData data = character.getGameData();
            final ImageIcon scaled = ImageUtil.scale(api.getGenshinIcon(data.getIconName()), 0.35, 0.35);

            final CharacterSelectionPanel pair = frame.fromIndex(i);

            pair.getNameLabel().setText(data.getName());
            pair.getImageLabel().setIcon(scaled);
        }

        // every missing character will be set to "block.png" and "No Character"

        for (int i = 0; i < missingCharacters; i++) {
            // We want to do + size here because we want to start from the end of the list
            // To ensure that we are not overriding any of the existing characters
            final CharacterSelectionPanel pair = frame.fromIndex(i + characters.size());

            pair.getNameLabel().setText("No Character");
            pair.getImageLabel().setIcon(this.blockIcon);
            pair.getImageLabel().setHorizontalAlignment(SwingConstants.CENTER);
        }

        frame.setVisible(true);
        this.dispose(disposable);
    }

    private void setRating(@NotNull GenshinArtifactType type, @Nullable RawRating rating) {
        switch (type) {
            case FLOWER -> this.flowerRating = rating;
            case FEATHER -> this.featherRating = rating;
            case SANDS -> this.sandsRating = rating;
            case GOBLET -> this.gobletRating = rating;
            case CIRCLET -> this.circletRating = rating;
        }
    }

    @Nullable
    private GenshinArtifact getArtifact(@NotNull List<GenshinArtifact> artifacts,
                                        @NotNull GenshinArtifactType type) {
        for (GenshinArtifact artifact : artifacts) {
            if (artifact.getType() != type) continue;
            return artifact;
        }
        return null;
    }
}
