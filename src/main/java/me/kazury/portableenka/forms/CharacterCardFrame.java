package me.kazury.portableenka.forms;

import me.kazury.enkanetworkapi.genshin.data.GenshinArtifactType;
import me.kazury.portableenka.util.GlobalConfig;
import me.kazury.portableenka.util.RoundedBorder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class CharacterCardFrame extends JFrame {
    public JPanel mainPanel;

    private JPanel weapon;

    public JPanel flower;
    public JPanel feather;
    public JPanel sands;
    public JPanel goblet;
    public JPanel circlet;

    public JLabel splashArt;
    public JLabel uidLabel;

    public JLabel talent1Image;
    public JLabel talent1Value;
    public JLabel talent2Image;
    public JLabel talent2Value;
    public JLabel talent3Image;
    public JLabel talent3Value;

    private JPanel talentBox;
    private JPanel statsFrame;

    public JLabel hp;
    public JLabel atk;
    public JLabel def;
    public JLabel er;
    public JLabel em;
    public JLabel cr;
    public JLabel cd;

    public JLabel featherImage;
    public JLabel flowerImage;
    public JLabel sandsImage;
    public JLabel gobletImage;
    public JLabel circletImage;

    private JPanel flowerLevel;
    private JPanel featherLevel;
    private JPanel sandsLevel;
    private JPanel gobletLevel;
    private JPanel circletLevel;

    public JLabel flowerPlusLabel;
    public JLabel featherPlusLabel;
    public JLabel sandsPlusLabel;
    public JLabel gobletPlusLabel;
    public JLabel circletPlusLabel;

    private JLabel flowerRating;
    private JLabel flowerMain;
    private JLabel featherRating;
    private JLabel featherMain;
    private JLabel flowerSub1;
    private JLabel featherSub1;
    private JLabel sandsRating;
    private JLabel sandsMain;
    private JLabel sandsSub1;
    private JLabel gobletRating;
    private JLabel gobletMain;
    private JLabel gobletSub1;
    private JLabel circletRating;
    private JLabel circletMain;
    private JLabel circletSub1;
    private JLabel flowerSub1Val;
    private JLabel flowerSub2;
    private JLabel flowerSub2Val;
    private JLabel flowerSub3;
    private JLabel flowerSub3Val;
    private JLabel flowerSub4;
    private JLabel flowerSub4Val;
    private JLabel featherSub1Val;
    private JLabel featherSub2;
    private JLabel featherSub3;
    private JLabel featherSub4;
    private JLabel featherSub2Val;
    private JLabel featherSub3Val;
    private JLabel featherSub4Val;
    private JLabel sandsSub2;
    private JLabel sandsSub3;
    private JLabel sandsSub4;
    private JLabel sandsSub4Val;
    private JLabel sandsSub3Val;
    private JLabel sandsSub2Val;
    private JLabel sandsSub1Val;
    private JLabel gobletSub2;
    private JLabel gobletSub3;
    private JLabel gobletSub4;
    private JLabel gobletSub1Val;
    private JLabel gobletSub2Val;
    private JLabel gobletSub3Val;
    private JLabel gobletSub4Val;
    private JLabel circletSub2;
    private JLabel circletSub3;
    private JLabel circletSub4;
    private JLabel circletSub1Val;
    private JLabel circletSub2Val;
    private JLabel circletSub3Val;
    private JLabel circletSub4Val;

    public JLabel weaponIcon;

    public JLabel weaponName;

    public JPanel weaponBaseAttack;
    public JLabel baseAttackLabel;

    public JPanel secondaryPanel;
    public JLabel secondaryLabel;

    public JPanel refinementPanel;
    public JLabel refinementLabel;

    public JPanel levelPanel;
    public JLabel levelLabel;

    public JLabel stars;

    public JLabel flowerPoints;
    public JLabel featherPoints;
    public JLabel sandsPoints;
    public JLabel gobletPoints;
    public JLabel circletPoints;
    public JLabel totalRanking;

    public JPanel characterRating;
    public JButton explanationButton;
    public JButton returnButton;
    public JPanel constellationFrame;
    public JLabel constellationLabel;
    public JLabel hpText;
    public JLabel atkText;
    public JLabel defText;
    public JLabel erText;
    public JLabel emText;
    public JLabel crText;
    public JLabel cdText;

    private void loadArtifactComponents() {
        this.flower = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout()
        );

        this.feather = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout()
        );

        this.sands = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                Color.decode("#111112"),
                new BorderLayout()
        );

        this.goblet = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout()
        );

        this.circlet = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout()
        );
    }

    private void loadWeaponComponents() {
        this.weapon = RoundedBorder.adjustPanel(
                new Dimension(320, 150),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout()
        );

        this.weaponBaseAttack = RoundedBorder.adjustPanel(
                new Dimension(90, 45),
                Color.decode("#505050"),
                new BorderLayout(),
                24, 24
        );

        this.secondaryPanel = RoundedBorder.adjustPanel(
                new Dimension(90, 45),
                Color.decode("#505050"),
                new BorderLayout(),
                24, 24
        );

        this.refinementPanel = RoundedBorder.adjustPanel(
                new Dimension(75, 25),
                Color.decode("#2B2B2B"),
                new BorderLayout(),
                16, 16
        );

        this.levelPanel = RoundedBorder.adjustPanel(
                new Dimension(75, 25),
                Color.decode("#2B2B2B"),
                new BorderLayout(),
                16, 16
        );
    }

    private void loadLevelComponents() {
        this.flowerLevel = RoundedBorder.adjustPanel(
                new Dimension(90, 40),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout(),
                24, 24
        );

        this.featherLevel = RoundedBorder.adjustPanel(
                new Dimension(90, 40),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout(),
                24, 24
        );

        this.sandsLevel = RoundedBorder.adjustPanel(
                new Dimension(90, 40),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout(),
                24, 24
        );

        this.gobletLevel = RoundedBorder.adjustPanel(
                new Dimension(90, 40),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout(),
                24, 24
        );

        this.circletLevel = RoundedBorder.adjustPanel(
                new Dimension(90, 40),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new BorderLayout(),
                24, 24
        );
    }

    private void loadTopBarComponents() {
        this.constellationFrame = RoundedBorder.adjustPanel(
                new Dimension(100, 200),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                16, 16
        );

        this.statsFrame = RoundedBorder.adjustPanel(
                new Dimension(200, 200),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                16, 16
        );

        this.talentBox = RoundedBorder.adjustPanel(
                new Dimension(55, 200),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                16, 16
        );

        this.characterRating = RoundedBorder.adjustPanel(
                new Dimension(214, 200),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                16, 16
        );
    }

    private void createUIComponents() {
        this.loadWeaponComponents();
        this.loadArtifactComponents();
        this.loadLevelComponents();
        this.loadTopBarComponents();
    }

    @NotNull
    public JLabel getRatingLabel(@NotNull GenshinArtifactType type) {
        return switch (type) {
            case FLOWER -> this.flowerRating;
            case FEATHER -> this.featherRating;
            case SANDS -> this.sandsRating;
            case GOBLET -> this.gobletRating;
            case CIRCLET -> this.circletRating;
        };
    }

    @NotNull
    public JLabel getMainLabel(@NotNull GenshinArtifactType type) {
        return switch (type) {
            case FLOWER -> this.flowerMain;
            case FEATHER -> this.featherMain;
            case SANDS -> this.sandsMain;
            case GOBLET -> this.gobletMain;
            case CIRCLET -> this.circletMain;
        };
    }

    @NotNull
    public JPanel getArtifactPanel(@NotNull GenshinArtifactType type) {
        return switch (type) {
            case FLOWER -> this.flower;
            case FEATHER -> this.feather;
            case SANDS -> this.sands;
            case GOBLET -> this.goblet;
            case CIRCLET -> this.circlet;
        };
    }

    @NotNull
    public JLabel getSubLabel(@NotNull GenshinArtifactType type, final int index) {
        return switch (type) {
            case FLOWER -> switch (index) {
                case 1 -> this.flowerSub1;
                case 2 -> this.flowerSub2;
                case 3 -> this.flowerSub3;
                case 4 -> this.flowerSub4;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case FEATHER -> switch (index) {
                case 1 -> this.featherSub1;
                case 2 -> this.featherSub2;
                case 3 -> this.featherSub3;
                case 4 -> this.featherSub4;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case SANDS -> switch (index) {
                case 1 -> this.sandsSub1;
                case 2 -> this.sandsSub2;
                case 3 -> this.sandsSub3;
                case 4 -> this.sandsSub4;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case GOBLET -> switch (index) {
                case 1 -> this.gobletSub1;
                case 2 -> this.gobletSub2;
                case 3 -> this.gobletSub3;
                case 4 -> this.gobletSub4;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case CIRCLET -> switch (index) {
                case 1 -> this.circletSub1;
                case 2 -> this.circletSub2;
                case 3 -> this.circletSub3;
                case 4 -> this.circletSub4;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        };
    }

    @NotNull
    public JLabel getSubValueLabel(@NotNull GenshinArtifactType type, final int index) {
        return switch (type) {
            case FLOWER -> switch (index) {
                case 1 -> this.flowerSub1Val;
                case 2 -> this.flowerSub2Val;
                case 3 -> this.flowerSub3Val;
                case 4 -> this.flowerSub4Val;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case FEATHER -> switch (index) {
                case 1 -> this.featherSub1Val;
                case 2 -> this.featherSub2Val;
                case 3 -> this.featherSub3Val;
                case 4 -> this.featherSub4Val;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case SANDS -> switch (index) {
                case 1 -> this.sandsSub1Val;
                case 2 -> this.sandsSub2Val;
                case 3 -> this.sandsSub3Val;
                case 4 -> this.sandsSub4Val;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case GOBLET -> switch (index) {
                case 1 -> this.gobletSub1Val;
                case 2 -> this.gobletSub2Val;
                case 3 -> this.gobletSub3Val;
                case 4 -> this.gobletSub4Val;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
            case CIRCLET -> switch (index) {
                case 1 -> this.circletSub1Val;
                case 2 -> this.circletSub2Val;
                case 3 -> this.circletSub3Val;
                case 4 -> this.circletSub4Val;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            };
        };
    }
}
