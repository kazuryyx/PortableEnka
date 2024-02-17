package me.kazury.portableenka.forms;

import com.intellij.uiDesigner.core.GridLayoutManager;
import me.kazury.enkanetworkapi.genshin.data.GenshinArtifactType;
import me.kazury.portableenka.util.GlobalConfig;
import me.kazury.portableenka.util.RoundedBorder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        mainPanel.setMinimumSize(new Dimension(1050, 620));
        mainPanel.setPreferredSize(new Dimension(1050, 620));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
        panel1.setPreferredSize(new Dimension(1000, 230));
        mainPanel.add(panel1);
        uidLabel = new JLabel();
        uidLabel.setFocusCycleRoot(true);
        uidLabel.setFocusTraversalPolicyProvider(true);
        uidLabel.setFocusable(true);
        Font uidLabelFont = this.$$$getFont$$$("Bahnschrift", -1, -1, uidLabel.getFont());
        if (uidLabelFont != null) uidLabel.setFont(uidLabelFont);
        uidLabel.setForeground(new Color(-10197658));
        uidLabel.setHorizontalAlignment(4);
        uidLabel.setHorizontalTextPosition(11);
        uidLabel.setPreferredSize(new Dimension(100, 200));
        uidLabel.setRequestFocusEnabled(true);
        uidLabel.setText("UID: 722777337");
        uidLabel.setVerticalAlignment(1);
        uidLabel.setVerticalTextPosition(0);
        panel1.add(uidLabel);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.setPreferredSize(new Dimension(400, 210));
        panel1.add(panel2);
        splashArt = new JLabel();
        splashArt.setBackground(new Color(-16711820));
        splashArt.setEnabled(true);
        splashArt.setForeground(new Color(-16718492));
        splashArt.setHorizontalAlignment(0);
        splashArt.setHorizontalTextPosition(11);
        splashArt.setPreferredSize(new Dimension(280, 200));
        splashArt.setRequestFocusEnabled(true);
        splashArt.setText("");
        splashArt.setVerticalAlignment(0);
        splashArt.setVerticalTextPosition(0);
        panel2.add(splashArt);
        constellationFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 13, 2));
        constellationFrame.setBackground(new Color(-15658734));
        constellationFrame.setPreferredSize(new Dimension(100, 200));
        panel2.add(constellationFrame);
        constellationLabel = new JLabel();
        Font constellationLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 24, constellationLabel.getFont());
        if (constellationLabelFont != null) constellationLabel.setFont(constellationLabelFont);
        constellationLabel.setHorizontalAlignment(0);
        constellationLabel.setPreferredSize(new Dimension(100, 35));
        constellationLabel.setText("C6");
        constellationLabel.setVerticalTextPosition(0);
        constellationFrame.add(constellationLabel);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Segoe UI Black", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setPreferredSize(new Dimension(100, 8));
        label1.setRequestFocusEnabled(true);
        label1.setText("⎯⎯⎯⎯⎯⎯");
        label1.setVerticalTextPosition(0);
        constellationFrame.add(label1);
        talentBox.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        talentBox.setBackground(new Color(-15658734));
        talentBox.setPreferredSize(new Dimension(55, 200));
        panel1.add(talentBox);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel3.setOpaque(false);
        panel3.setPreferredSize(new Dimension(40, 39));
        talentBox.add(panel3);
        talent1Image = new JLabel();
        talent1Image.setHorizontalAlignment(0);
        talent1Image.setHorizontalTextPosition(0);
        talent1Image.setPreferredSize(new Dimension(39, 39));
        talent1Image.setText("");
        panel3.add(talent1Image);
        talent1Value = new JLabel();
        talent1Value.setFocusable(true);
        Font talent1ValueFont = this.$$$getFont$$$("Segoe UI Black", -1, 10, talent1Value.getFont());
        if (talent1ValueFont != null) talent1Value.setFont(talent1ValueFont);
        talent1Value.setHorizontalAlignment(0);
        talent1Value.setHorizontalTextPosition(0);
        talent1Value.setPreferredSize(new Dimension(40, 15));
        talent1Value.setText("1");
        talent1Value.setVerticalAlignment(1);
        talent1Value.setVerticalTextPosition(1);
        talentBox.add(talent1Value);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel4.setOpaque(false);
        panel4.setPreferredSize(new Dimension(40, 39));
        talentBox.add(panel4);
        talent2Image = new JLabel();
        talent2Image.setHorizontalAlignment(0);
        talent2Image.setHorizontalTextPosition(0);
        talent2Image.setPreferredSize(new Dimension(39, 39));
        talent2Image.setText("");
        panel4.add(talent2Image);
        talent2Value = new JLabel();
        talent2Value.setFocusable(true);
        Font talent2ValueFont = this.$$$getFont$$$("Segoe UI Black", -1, 10, talent2Value.getFont());
        if (talent2ValueFont != null) talent2Value.setFont(talent2ValueFont);
        talent2Value.setHorizontalAlignment(0);
        talent2Value.setHorizontalTextPosition(0);
        talent2Value.setPreferredSize(new Dimension(40, 15));
        talent2Value.setText("1");
        talent2Value.setVerticalAlignment(1);
        talent2Value.setVerticalTextPosition(1);
        talentBox.add(talent2Value);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel5.setAlignmentX(0.0f);
        panel5.setAlignmentY(0.0f);
        panel5.setOpaque(false);
        panel5.setPreferredSize(new Dimension(40, 39));
        talentBox.add(panel5);
        talent3Image = new JLabel();
        talent3Image.setAlignmentY(0.0f);
        talent3Image.setHorizontalAlignment(0);
        talent3Image.setHorizontalTextPosition(0);
        talent3Image.setPreferredSize(new Dimension(38, 38));
        talent3Image.setText("");
        panel5.add(talent3Image);
        talent3Value = new JLabel();
        talent3Value.setFocusable(true);
        Font talent3ValueFont = this.$$$getFont$$$("Segoe UI Black", -1, 10, talent3Value.getFont());
        if (talent3ValueFont != null) talent3Value.setFont(talent3ValueFont);
        talent3Value.setHorizontalAlignment(0);
        talent3Value.setHorizontalTextPosition(0);
        talent3Value.setPreferredSize(new Dimension(40, 15));
        talent3Value.setText("1");
        talent3Value.setVerticalAlignment(1);
        talent3Value.setVerticalTextPosition(1);
        talentBox.add(talent3Value);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setBackground(new Color(-63213));
        panel6.setOpaque(false);
        panel6.setPreferredSize(new Dimension(8, 200));
        panel1.add(panel6);
        statsFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        statsFrame.setBackground(new Color(-15658734));
        statsFrame.setPreferredSize(new Dimension(200, 200));
        panel1.add(statsFrame);
        hpText = new JLabel();
        Font hpTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, hpText.getFont());
        if (hpTextFont != null) hpText.setFont(hpTextFont);
        hpText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/HP.png")));
        hpText.setPreferredSize(new Dimension(91, 22));
        hpText.setText("HP");
        statsFrame.add(hpText);
        hp = new JLabel();
        Font hpFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, hp.getFont());
        if (hpFont != null) hp.setFont(hpFont);
        hp.setHorizontalAlignment(4);
        hp.setPreferredSize(new Dimension(100, 22));
        hp.setText("0");
        hp.setVerticalAlignment(0);
        statsFrame.add(hp);
        atkText = new JLabel();
        Font atkTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, atkText.getFont());
        if (atkTextFont != null) atkText.setFont(atkTextFont);
        atkText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/ATK.png")));
        atkText.setOpaque(false);
        atkText.setPreferredSize(new Dimension(91, 22));
        atkText.setText("ATK");
        statsFrame.add(atkText);
        atk = new JLabel();
        Font atkFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, atk.getFont());
        if (atkFont != null) atk.setFont(atkFont);
        atk.setHorizontalAlignment(4);
        atk.setOpaque(false);
        atk.setPreferredSize(new Dimension(100, 22));
        atk.setText("0");
        statsFrame.add(atk);
        defText = new JLabel();
        Font defTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, defText.getFont());
        if (defTextFont != null) defText.setFont(defTextFont);
        defText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/DEF.png")));
        defText.setPreferredSize(new Dimension(91, 22));
        defText.setText("DEF");
        statsFrame.add(defText);
        def = new JLabel();
        Font defFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, def.getFont());
        if (defFont != null) def.setFont(defFont);
        def.setHorizontalAlignment(4);
        def.setPreferredSize(new Dimension(100, 22));
        def.setText("0");
        statsFrame.add(def);
        erText = new JLabel();
        Font erTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, erText.getFont());
        if (erTextFont != null) erText.setFont(erTextFont);
        erText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/Energy Recharge.png")));
        erText.setPreferredSize(new Dimension(140, 22));
        erText.setText("Energy Recharge");
        statsFrame.add(erText);
        er = new JLabel();
        Font erFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, er.getFont());
        if (erFont != null) er.setFont(erFont);
        er.setHorizontalAlignment(4);
        er.setPreferredSize(new Dimension(51, 22));
        er.setText("100%");
        statsFrame.add(er);
        emText = new JLabel();
        Font emTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, emText.getFont());
        if (emTextFont != null) emText.setFont(emTextFont);
        emText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/Elemental Mastery.png")));
        emText.setPreferredSize(new Dimension(156, 22));
        emText.setText("Elemental Mastery");
        statsFrame.add(emText);
        em = new JLabel();
        Font emFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, em.getFont());
        if (emFont != null) em.setFont(emFont);
        em.setHorizontalAlignment(4);
        em.setPreferredSize(new Dimension(35, 22));
        em.setText("1.000");
        statsFrame.add(em);
        crText = new JLabel();
        Font crTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, crText.getFont());
        if (crTextFont != null) crText.setFont(crTextFont);
        crText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/CRIT Rate.png")));
        crText.setPreferredSize(new Dimension(116, 22));
        crText.setText("CRIT Rate");
        statsFrame.add(crText);
        cr = new JLabel();
        Font crFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, cr.getFont());
        if (crFont != null) cr.setFont(crFont);
        cr.setHorizontalAlignment(4);
        cr.setPreferredSize(new Dimension(75, 22));
        cr.setText("10%");
        statsFrame.add(cr);
        cdText = new JLabel();
        Font cdTextFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, cdText.getFont());
        if (cdTextFont != null) cdText.setFont(cdTextFont);
        cdText.setIcon(new ImageIcon(getClass().getResource("/weapon_icons/CRIT DMG.png")));
        cdText.setOpaque(false);
        cdText.setPreferredSize(new Dimension(116, 22));
        cdText.setText("CRIT DMG");
        statsFrame.add(cdText);
        cd = new JLabel();
        Font cdFont = this.$$$getFont$$$("Segoe UI Black", -1, -1, cd.getFont());
        if (cdFont != null) cd.setFont(cdFont);
        cd.setHorizontalAlignment(4);
        cd.setOpaque(false);
        cd.setPreferredSize(new Dimension(75, 22));
        cd.setText("100%");
        statsFrame.add(cd);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel7.setBackground(new Color(-63213));
        panel7.setOpaque(false);
        panel7.setPreferredSize(new Dimension(8, 200));
        panel1.add(panel7);
        characterRating.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 6));
        characterRating.setBackground(new Color(-15658734));
        characterRating.setPreferredSize(new Dimension(214, 200));
        panel1.add(characterRating);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Segoe UI Black", -1, 18, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setPreferredSize(new Dimension(200, 24));
        label2.setText("Character Rating");
        characterRating.add(label2);
        flowerPoints = new JLabel();
        Font flowerPointsFont = this.$$$getFont$$$("Segoe UI Black", -1, 12, flowerPoints.getFont());
        if (flowerPointsFont != null) flowerPoints.setFont(flowerPointsFont);
        flowerPoints.setForeground(new Color(-1722054));
        flowerPoints.setPreferredSize(new Dimension(200, 18));
        flowerPoints.setText("   Flower: 10 pt. / 22 pt.");
        characterRating.add(flowerPoints);
        featherPoints = new JLabel();
        Font featherPointsFont = this.$$$getFont$$$("Segoe UI Black", -1, 12, featherPoints.getFont());
        if (featherPointsFont != null) featherPoints.setFont(featherPointsFont);
        featherPoints.setForeground(new Color(-1722054));
        featherPoints.setPreferredSize(new Dimension(200, 18));
        featherPoints.setText("   Feather: 10 pt. / 22 pt.");
        characterRating.add(featherPoints);
        sandsPoints = new JLabel();
        Font sandsPointsFont = this.$$$getFont$$$("Segoe UI Black", -1, 12, sandsPoints.getFont());
        if (sandsPointsFont != null) sandsPoints.setFont(sandsPointsFont);
        sandsPoints.setForeground(new Color(-1722054));
        sandsPoints.setPreferredSize(new Dimension(200, 18));
        sandsPoints.setText("   Sands: 10 pt. / 22 pt.");
        characterRating.add(sandsPoints);
        gobletPoints = new JLabel();
        Font gobletPointsFont = this.$$$getFont$$$("Segoe UI Black", -1, 12, gobletPoints.getFont());
        if (gobletPointsFont != null) gobletPoints.setFont(gobletPointsFont);
        gobletPoints.setForeground(new Color(-1722054));
        gobletPoints.setPreferredSize(new Dimension(200, 18));
        gobletPoints.setText("   Goblet: 10 pt. / 22 pt.");
        characterRating.add(gobletPoints);
        circletPoints = new JLabel();
        Font circletPointsFont = this.$$$getFont$$$("Segoe UI Black", -1, 12, circletPoints.getFont());
        if (circletPointsFont != null) circletPoints.setFont(circletPointsFont);
        circletPoints.setForeground(new Color(-1722054));
        circletPoints.setPreferredSize(new Dimension(200, 18));
        circletPoints.setText("   Circlet: 10 pt. / 22 pt.");
        characterRating.add(circletPoints);
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Segoe UI Black", -1, 20, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setPreferredSize(new Dimension(110, 35));
        label3.setText("Total Rank");
        characterRating.add(label3);
        totalRanking = new JLabel();
        Font totalRankingFont = this.$$$getFont$$$("Ink Free", -1, 24, totalRanking.getFont());
        if (totalRankingFont != null) totalRanking.setFont(totalRankingFont);
        totalRanking.setForeground(new Color(-657947));
        totalRanking.setHorizontalAlignment(0);
        totalRanking.setPreferredSize(new Dimension(90, 30));
        totalRanking.setText("F");
        characterRating.add(totalRanking);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel8.setPreferredSize(new Dimension(1000, 375));
        panel8.setRequestFocusEnabled(true);
        mainPanel.add(panel8);
        weapon.setLayout(new BorderLayout(0, 0));
        weapon.setBackground(new Color(-15658734));
        weapon.setEnabled(true);
        weapon.setPreferredSize(new Dimension(320, 150));
        panel8.add(weapon);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel9.setOpaque(false);
        panel9.setPreferredSize(new Dimension(125, 24));
        weapon.add(panel9, BorderLayout.WEST);
        weaponIcon = new JLabel();
        weaponIcon.setHorizontalAlignment(0);
        weaponIcon.setHorizontalTextPosition(0);
        weaponIcon.setOpaque(false);
        weaponIcon.setPreferredSize(new Dimension(125, 158));
        weaponIcon.setText("");
        panel9.add(weaponIcon);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel10.setOpaque(false);
        panel10.setPreferredSize(new Dimension(195, 24));
        weapon.add(panel10, BorderLayout.EAST);
        weaponName = new JLabel();
        Font weaponNameFont = this.$$$getFont$$$("Segoe UI Black", -1, 16, weaponName.getFont());
        if (weaponNameFont != null) weaponName.setFont(weaponNameFont);
        weaponName.setHorizontalAlignment(0);
        weaponName.setPreferredSize(new Dimension(190, 27));
        weaponName.setText("Tome of the Eternal Flow");
        panel10.add(weaponName);
        weaponBaseAttack.setLayout(new BorderLayout(0, 0));
        weaponBaseAttack.setBackground(new Color(-11513776));
        weaponBaseAttack.setOpaque(true);
        weaponBaseAttack.setPreferredSize(new Dimension(88, 45));
        panel10.add(weaponBaseAttack);
        baseAttackLabel = new JLabel();
        Font baseAttackLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 17, baseAttackLabel.getFont());
        if (baseAttackLabelFont != null) baseAttackLabel.setFont(baseAttackLabelFont);
        baseAttackLabel.setHorizontalAlignment(0);
        baseAttackLabel.setIconTextGap(2);
        baseAttackLabel.setPreferredSize(new Dimension(0, 40));
        baseAttackLabel.setRequestFocusEnabled(true);
        baseAttackLabel.setText("+20");
        weaponBaseAttack.add(baseAttackLabel, BorderLayout.CENTER);
        secondaryPanel.setLayout(new BorderLayout(0, 0));
        secondaryPanel.setBackground(new Color(-11513776));
        secondaryPanel.setEnabled(true);
        secondaryPanel.setOpaque(true);
        secondaryPanel.setPreferredSize(new Dimension(88, 45));
        panel10.add(secondaryPanel);
        secondaryLabel = new JLabel();
        secondaryLabel.setBackground(new Color(-8386816));
        Font secondaryLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 17, secondaryLabel.getFont());
        if (secondaryLabelFont != null) secondaryLabel.setFont(secondaryLabelFont);
        secondaryLabel.setHorizontalAlignment(0);
        secondaryLabel.setIconTextGap(2);
        secondaryLabel.setPreferredSize(new Dimension(0, 40));
        secondaryLabel.setRequestFocusEnabled(true);
        secondaryLabel.setText("+20");
        secondaryPanel.add(secondaryLabel, BorderLayout.CENTER);
        refinementPanel.setLayout(new BorderLayout(0, 0));
        refinementPanel.setBackground(new Color(-13948117));
        refinementPanel.setEnabled(true);
        refinementPanel.setOpaque(true);
        refinementPanel.setPreferredSize(new Dimension(75, 25));
        panel10.add(refinementPanel);
        refinementLabel = new JLabel();
        refinementLabel.setBackground(new Color(-8386816));
        Font refinementLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 16, refinementLabel.getFont());
        if (refinementLabelFont != null) refinementLabel.setFont(refinementLabelFont);
        refinementLabel.setHorizontalAlignment(0);
        refinementLabel.setPreferredSize(new Dimension(0, 40));
        refinementLabel.setRequestFocusEnabled(true);
        refinementLabel.setText("R1");
        refinementPanel.add(refinementLabel, BorderLayout.CENTER);
        levelPanel.setLayout(new BorderLayout(0, 0));
        levelPanel.setBackground(new Color(-13948117));
        levelPanel.setEnabled(true);
        levelPanel.setOpaque(true);
        levelPanel.setPreferredSize(new Dimension(75, 25));
        panel10.add(levelPanel);
        levelLabel = new JLabel();
        levelLabel.setBackground(new Color(-8386816));
        Font levelLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 16, levelLabel.getFont());
        if (levelLabelFont != null) levelLabel.setFont(levelLabelFont);
        levelLabel.setHorizontalAlignment(0);
        levelLabel.setPreferredSize(new Dimension(0, 40));
        levelLabel.setRequestFocusEnabled(true);
        levelLabel.setText("Lv. 90");
        levelPanel.add(levelLabel, BorderLayout.CENTER);
        stars = new JLabel();
        Font starsFont = this.$$$getFont$$$("Segoe UI Black", -1, 44, stars.getFont());
        if (starsFont != null) stars.setFont(starsFont);
        stars.setForeground(new Color(-1730560));
        stars.setHorizontalAlignment(0);
        stars.setPreferredSize(new Dimension(190, 25));
        stars.setText("⭐⭐⭐⭐⭐");
        panel10.add(stars);
        flower.setLayout(new BorderLayout(0, 0));
        flower.setBackground(new Color(-15658734));
        flower.setPreferredSize(new Dimension(320, 150));
        flower.setVisible(true);
        panel8.add(flower);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel11.setOpaque(false);
        panel11.setPreferredSize(new Dimension(105, 24));
        flower.add(panel11, BorderLayout.WEST);
        flowerImage = new JLabel();
        flowerImage.setHorizontalAlignment(0);
        flowerImage.setOpaque(false);
        flowerImage.setPreferredSize(new Dimension(90, 95));
        flowerImage.setText("");
        panel11.add(flowerImage);
        flowerLevel.setLayout(new BorderLayout(0, 0));
        flowerLevel.setBackground(new Color(-14474460));
        flowerLevel.setOpaque(true);
        flowerLevel.setPreferredSize(new Dimension(90, 40));
        panel11.add(flowerLevel);
        flowerPlusLabel = new JLabel();
        Font flowerPlusLabelFont = this.$$$getFont$$$("Rockwell Extra Bold", -1, 26, flowerPlusLabel.getFont());
        if (flowerPlusLabelFont != null) flowerPlusLabel.setFont(flowerPlusLabelFont);
        flowerPlusLabel.setHorizontalAlignment(0);
        flowerPlusLabel.setPreferredSize(new Dimension(0, 40));
        flowerPlusLabel.setRequestFocusEnabled(true);
        flowerPlusLabel.setText("+20");
        flowerLevel.add(flowerPlusLabel, BorderLayout.CENTER);
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel12.setEnabled(true);
        panel12.setOpaque(false);
        panel12.setPreferredSize(new Dimension(50, 50));
        panel12.setVisible(true);
        flower.add(panel12, BorderLayout.CENTER);
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Segoe UI Black", -1, 16, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setPreferredSize(new Dimension(100, 17));
        label4.setText("Rank");
        panel12.add(label4);
        flowerRating = new JLabel();
        Font flowerRatingFont = this.$$$getFont$$$("Ink Free", -1, 24, flowerRating.getFont());
        if (flowerRatingFont != null) flowerRating.setFont(flowerRatingFont);
        flowerRating.setForeground(new Color(-657956));
        flowerRating.setPreferredSize(new Dimension(50, 30));
        flowerRating.setText("F");
        panel12.add(flowerRating);
        flowerMain = new JLabel();
        Font flowerMainFont = this.$$$getFont$$$("Segoe UI", -1, 17, flowerMain.getFont());
        if (flowerMainFont != null) flowerMain.setFont(flowerMainFont);
        flowerMain.setForeground(new Color(-29105));
        flowerMain.setHorizontalAlignment(2);
        flowerMain.setPreferredSize(new Dimension(200, 20));
        flowerMain.setText("HP 4,780");
        panel12.add(flowerMain);
        flowerSub1 = new JLabel();
        Font flowerSub1Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, flowerSub1.getFont());
        if (flowerSub1Font != null) flowerSub1.setFont(flowerSub1Font);
        flowerSub1.setForeground(new Color(-1));
        flowerSub1.setHorizontalAlignment(2);
        flowerSub1.setHorizontalTextPosition(2);
        flowerSub1.setIconTextGap(0);
        flowerSub1.setPreferredSize(new Dimension(125, 16));
        flowerSub1.setText(" ");
        panel12.add(flowerSub1);
        flowerSub1Val = new JLabel();
        Font flowerSub1ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, flowerSub1Val.getFont());
        if (flowerSub1ValFont != null) flowerSub1Val.setFont(flowerSub1ValFont);
        flowerSub1Val.setForeground(new Color(-1));
        flowerSub1Val.setHorizontalAlignment(2);
        flowerSub1Val.setHorizontalTextPosition(2);
        flowerSub1Val.setIconTextGap(0);
        flowerSub1Val.setPreferredSize(new Dimension(70, 16));
        flowerSub1Val.setText(" ");
        panel12.add(flowerSub1Val);
        flowerSub2 = new JLabel();
        Font flowerSub2Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, flowerSub2.getFont());
        if (flowerSub2Font != null) flowerSub2.setFont(flowerSub2Font);
        flowerSub2.setForeground(new Color(-1));
        flowerSub2.setHorizontalAlignment(2);
        flowerSub2.setHorizontalTextPosition(2);
        flowerSub2.setIconTextGap(0);
        flowerSub2.setPreferredSize(new Dimension(125, 16));
        flowerSub2.setText(" ");
        panel12.add(flowerSub2);
        flowerSub2Val = new JLabel();
        Font flowerSub2ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, flowerSub2Val.getFont());
        if (flowerSub2ValFont != null) flowerSub2Val.setFont(flowerSub2ValFont);
        flowerSub2Val.setForeground(new Color(-1));
        flowerSub2Val.setHorizontalAlignment(2);
        flowerSub2Val.setHorizontalTextPosition(2);
        flowerSub2Val.setIconTextGap(0);
        flowerSub2Val.setPreferredSize(new Dimension(70, 16));
        flowerSub2Val.setText(" ");
        panel12.add(flowerSub2Val);
        flowerSub3 = new JLabel();
        Font flowerSub3Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, flowerSub3.getFont());
        if (flowerSub3Font != null) flowerSub3.setFont(flowerSub3Font);
        flowerSub3.setForeground(new Color(-1));
        flowerSub3.setHorizontalAlignment(2);
        flowerSub3.setHorizontalTextPosition(2);
        flowerSub3.setIconTextGap(0);
        flowerSub3.setPreferredSize(new Dimension(125, 16));
        flowerSub3.setText(" ");
        panel12.add(flowerSub3);
        flowerSub3Val = new JLabel();
        Font flowerSub3ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, flowerSub3Val.getFont());
        if (flowerSub3ValFont != null) flowerSub3Val.setFont(flowerSub3ValFont);
        flowerSub3Val.setForeground(new Color(-1));
        flowerSub3Val.setHorizontalAlignment(2);
        flowerSub3Val.setHorizontalTextPosition(2);
        flowerSub3Val.setIconTextGap(0);
        flowerSub3Val.setPreferredSize(new Dimension(70, 16));
        flowerSub3Val.setText(" ");
        panel12.add(flowerSub3Val);
        flowerSub4 = new JLabel();
        Font flowerSub4Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, flowerSub4.getFont());
        if (flowerSub4Font != null) flowerSub4.setFont(flowerSub4Font);
        flowerSub4.setForeground(new Color(-1));
        flowerSub4.setHorizontalAlignment(2);
        flowerSub4.setHorizontalTextPosition(2);
        flowerSub4.setIconTextGap(0);
        flowerSub4.setPreferredSize(new Dimension(125, 16));
        flowerSub4.setText(" ");
        panel12.add(flowerSub4);
        flowerSub4Val = new JLabel();
        Font flowerSub4ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, flowerSub4Val.getFont());
        if (flowerSub4ValFont != null) flowerSub4Val.setFont(flowerSub4ValFont);
        flowerSub4Val.setForeground(new Color(-1));
        flowerSub4Val.setHorizontalAlignment(2);
        flowerSub4Val.setHorizontalTextPosition(2);
        flowerSub4Val.setIconTextGap(0);
        flowerSub4Val.setPreferredSize(new Dimension(70, 16));
        flowerSub4Val.setText(" ");
        panel12.add(flowerSub4Val);
        feather.setLayout(new BorderLayout(0, 0));
        feather.setBackground(new Color(-15658734));
        feather.setPreferredSize(new Dimension(320, 150));
        feather.setVisible(true);
        panel8.add(feather);
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel13.setOpaque(false);
        panel13.setPreferredSize(new Dimension(105, 24));
        feather.add(panel13, BorderLayout.WEST);
        featherImage = new JLabel();
        featherImage.setHorizontalAlignment(0);
        featherImage.setOpaque(false);
        featherImage.setPreferredSize(new Dimension(90, 95));
        featherImage.setText("");
        panel13.add(featherImage);
        featherLevel.setLayout(new BorderLayout(0, 0));
        featherLevel.setBackground(new Color(-14474460));
        featherLevel.setOpaque(true);
        featherLevel.setPreferredSize(new Dimension(90, 40));
        panel13.add(featherLevel);
        featherPlusLabel = new JLabel();
        Font featherPlusLabelFont = this.$$$getFont$$$("Rockwell Extra Bold", -1, 26, featherPlusLabel.getFont());
        if (featherPlusLabelFont != null) featherPlusLabel.setFont(featherPlusLabelFont);
        featherPlusLabel.setHorizontalAlignment(0);
        featherPlusLabel.setPreferredSize(new Dimension(0, 40));
        featherPlusLabel.setRequestFocusEnabled(true);
        featherPlusLabel.setText("+20");
        featherLevel.add(featherPlusLabel, BorderLayout.CENTER);
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel14.setOpaque(false);
        panel14.setPreferredSize(new Dimension(50, 50));
        panel14.setRequestFocusEnabled(true);
        panel14.setVisible(true);
        feather.add(panel14, BorderLayout.CENTER);
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Segoe UI Black", -1, 16, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setPreferredSize(new Dimension(100, 17));
        label5.setText("Rank");
        panel14.add(label5);
        featherRating = new JLabel();
        Font featherRatingFont = this.$$$getFont$$$("Ink Free", -1, 24, featherRating.getFont());
        if (featherRatingFont != null) featherRating.setFont(featherRatingFont);
        featherRating.setForeground(new Color(-657956));
        featherRating.setPreferredSize(new Dimension(50, 30));
        featherRating.setText("F");
        panel14.add(featherRating);
        featherMain = new JLabel();
        Font featherMainFont = this.$$$getFont$$$("Segoe UI", -1, 17, featherMain.getFont());
        if (featherMainFont != null) featherMain.setFont(featherMainFont);
        featherMain.setForeground(new Color(-29105));
        featherMain.setHorizontalAlignment(2);
        featherMain.setPreferredSize(new Dimension(200, 20));
        featherMain.setText("HP 4,780");
        panel14.add(featherMain);
        featherSub1 = new JLabel();
        Font featherSub1Font = this.$$$getFont$$$("Segoe UI Semibold", -1, -1, featherSub1.getFont());
        if (featherSub1Font != null) featherSub1.setFont(featherSub1Font);
        featherSub1.setForeground(new Color(-1));
        featherSub1.setHorizontalAlignment(10);
        featherSub1.setHorizontalTextPosition(11);
        featherSub1.setIconTextGap(4);
        featherSub1.setOpaque(false);
        featherSub1.setPreferredSize(new Dimension(125, 16));
        featherSub1.setText(" ");
        panel14.add(featherSub1);
        featherSub1Val = new JLabel();
        featherSub1Val.setAlignmentY(0.0f);
        Font featherSub1ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, featherSub1Val.getFont());
        if (featherSub1ValFont != null) featherSub1Val.setFont(featherSub1ValFont);
        featherSub1Val.setForeground(new Color(-1));
        featherSub1Val.setHorizontalAlignment(2);
        featherSub1Val.setHorizontalTextPosition(4);
        featherSub1Val.setIconTextGap(0);
        featherSub1Val.setMaximumSize(new Dimension(4, 20));
        featherSub1Val.setMinimumSize(new Dimension(4, 20));
        featherSub1Val.setOpaque(false);
        featherSub1Val.setPreferredSize(new Dimension(70, 16));
        featherSub1Val.setText(" ");
        panel14.add(featherSub1Val);
        featherSub2 = new JLabel();
        Font featherSub2Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, featherSub2.getFont());
        if (featherSub2Font != null) featherSub2.setFont(featherSub2Font);
        featherSub2.setForeground(new Color(-1));
        featherSub2.setHorizontalAlignment(2);
        featherSub2.setHorizontalTextPosition(2);
        featherSub2.setIconTextGap(0);
        featherSub2.setPreferredSize(new Dimension(125, 16));
        featherSub2.setText(" ");
        panel14.add(featherSub2);
        featherSub2Val = new JLabel();
        Font featherSub2ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, featherSub2Val.getFont());
        if (featherSub2ValFont != null) featherSub2Val.setFont(featherSub2ValFont);
        featherSub2Val.setForeground(new Color(-1));
        featherSub2Val.setHorizontalAlignment(2);
        featherSub2Val.setHorizontalTextPosition(2);
        featherSub2Val.setIconTextGap(0);
        featherSub2Val.setPreferredSize(new Dimension(70, 16));
        featherSub2Val.setText(" ");
        panel14.add(featherSub2Val);
        featherSub3 = new JLabel();
        Font featherSub3Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, featherSub3.getFont());
        if (featherSub3Font != null) featherSub3.setFont(featherSub3Font);
        featherSub3.setForeground(new Color(-1));
        featherSub3.setHorizontalAlignment(2);
        featherSub3.setHorizontalTextPosition(2);
        featherSub3.setIconTextGap(0);
        featherSub3.setPreferredSize(new Dimension(125, 16));
        featherSub3.setText(" ");
        panel14.add(featherSub3);
        featherSub3Val = new JLabel();
        Font featherSub3ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, featherSub3Val.getFont());
        if (featherSub3ValFont != null) featherSub3Val.setFont(featherSub3ValFont);
        featherSub3Val.setForeground(new Color(-1));
        featherSub3Val.setHorizontalAlignment(2);
        featherSub3Val.setHorizontalTextPosition(2);
        featherSub3Val.setIconTextGap(0);
        featherSub3Val.setPreferredSize(new Dimension(70, 16));
        featherSub3Val.setText(" ");
        panel14.add(featherSub3Val);
        featherSub4 = new JLabel();
        Font featherSub4Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, featherSub4.getFont());
        if (featherSub4Font != null) featherSub4.setFont(featherSub4Font);
        featherSub4.setForeground(new Color(-1));
        featherSub4.setHorizontalAlignment(2);
        featherSub4.setHorizontalTextPosition(2);
        featherSub4.setIconTextGap(0);
        featherSub4.setPreferredSize(new Dimension(125, 16));
        featherSub4.setText(" ");
        panel14.add(featherSub4);
        featherSub4Val = new JLabel();
        Font featherSub4ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, featherSub4Val.getFont());
        if (featherSub4ValFont != null) featherSub4Val.setFont(featherSub4ValFont);
        featherSub4Val.setForeground(new Color(-1));
        featherSub4Val.setHorizontalAlignment(2);
        featherSub4Val.setHorizontalTextPosition(2);
        featherSub4Val.setIconTextGap(0);
        featherSub4Val.setPreferredSize(new Dimension(70, 16));
        featherSub4Val.setText(" ");
        panel14.add(featherSub4Val);
        sands.setLayout(new BorderLayout(0, 0));
        sands.setBackground(new Color(-15658734));
        sands.setPreferredSize(new Dimension(320, 150));
        panel8.add(sands);
        final JPanel panel15 = new JPanel();
        panel15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel15.setOpaque(false);
        panel15.setPreferredSize(new Dimension(105, 24));
        sands.add(panel15, BorderLayout.WEST);
        sandsImage = new JLabel();
        sandsImage.setHorizontalAlignment(0);
        sandsImage.setOpaque(false);
        sandsImage.setPreferredSize(new Dimension(90, 95));
        sandsImage.setText("");
        panel15.add(sandsImage);
        sandsLevel.setLayout(new BorderLayout(0, 0));
        sandsLevel.setBackground(new Color(-14474460));
        sandsLevel.setOpaque(true);
        sandsLevel.setPreferredSize(new Dimension(90, 40));
        panel15.add(sandsLevel);
        sandsPlusLabel = new JLabel();
        Font sandsPlusLabelFont = this.$$$getFont$$$("Rockwell Extra Bold", -1, 26, sandsPlusLabel.getFont());
        if (sandsPlusLabelFont != null) sandsPlusLabel.setFont(sandsPlusLabelFont);
        sandsPlusLabel.setHorizontalAlignment(0);
        sandsPlusLabel.setPreferredSize(new Dimension(0, 40));
        sandsPlusLabel.setRequestFocusEnabled(true);
        sandsPlusLabel.setText("+20");
        sandsLevel.add(sandsPlusLabel, BorderLayout.CENTER);
        final JPanel panel16 = new JPanel();
        panel16.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel16.setOpaque(false);
        panel16.setPreferredSize(new Dimension(50, 50));
        sands.add(panel16, BorderLayout.CENTER);
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Segoe UI Black", -1, 16, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setPreferredSize(new Dimension(100, 17));
        label6.setText("Rank");
        panel16.add(label6);
        sandsRating = new JLabel();
        Font sandsRatingFont = this.$$$getFont$$$("Ink Free", -1, 24, sandsRating.getFont());
        if (sandsRatingFont != null) sandsRating.setFont(sandsRatingFont);
        sandsRating.setForeground(new Color(-657956));
        sandsRating.setPreferredSize(new Dimension(50, 30));
        sandsRating.setText("F");
        panel16.add(sandsRating);
        sandsMain = new JLabel();
        Font sandsMainFont = this.$$$getFont$$$("Segoe UI", -1, 17, sandsMain.getFont());
        if (sandsMainFont != null) sandsMain.setFont(sandsMainFont);
        sandsMain.setForeground(new Color(-29105));
        sandsMain.setHorizontalAlignment(2);
        sandsMain.setOpaque(false);
        sandsMain.setPreferredSize(new Dimension(200, 20));
        sandsMain.setText("HP 4,780");
        panel16.add(sandsMain);
        sandsSub1 = new JLabel();
        Font sandsSub1Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, sandsSub1.getFont());
        if (sandsSub1Font != null) sandsSub1.setFont(sandsSub1Font);
        sandsSub1.setForeground(new Color(-1));
        sandsSub1.setHorizontalAlignment(2);
        sandsSub1.setHorizontalTextPosition(2);
        sandsSub1.setIconTextGap(0);
        sandsSub1.setPreferredSize(new Dimension(125, 16));
        sandsSub1.setText(" ");
        panel16.add(sandsSub1);
        sandsSub1Val = new JLabel();
        Font sandsSub1ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, sandsSub1Val.getFont());
        if (sandsSub1ValFont != null) sandsSub1Val.setFont(sandsSub1ValFont);
        sandsSub1Val.setForeground(new Color(-1));
        sandsSub1Val.setHorizontalAlignment(2);
        sandsSub1Val.setHorizontalTextPosition(2);
        sandsSub1Val.setIconTextGap(0);
        sandsSub1Val.setOpaque(false);
        sandsSub1Val.setPreferredSize(new Dimension(70, 16));
        sandsSub1Val.setText(" ");
        panel16.add(sandsSub1Val);
        sandsSub2 = new JLabel();
        Font sandsSub2Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, sandsSub2.getFont());
        if (sandsSub2Font != null) sandsSub2.setFont(sandsSub2Font);
        sandsSub2.setForeground(new Color(-1));
        sandsSub2.setHorizontalAlignment(2);
        sandsSub2.setHorizontalTextPosition(2);
        sandsSub2.setIconTextGap(0);
        sandsSub2.setPreferredSize(new Dimension(125, 16));
        sandsSub2.setText(" ");
        panel16.add(sandsSub2);
        sandsSub2Val = new JLabel();
        Font sandsSub2ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, sandsSub2Val.getFont());
        if (sandsSub2ValFont != null) sandsSub2Val.setFont(sandsSub2ValFont);
        sandsSub2Val.setForeground(new Color(-1));
        sandsSub2Val.setHorizontalAlignment(2);
        sandsSub2Val.setHorizontalTextPosition(2);
        sandsSub2Val.setIconTextGap(0);
        sandsSub2Val.setPreferredSize(new Dimension(70, 16));
        sandsSub2Val.setText(" ");
        panel16.add(sandsSub2Val);
        sandsSub3 = new JLabel();
        Font sandsSub3Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, sandsSub3.getFont());
        if (sandsSub3Font != null) sandsSub3.setFont(sandsSub3Font);
        sandsSub3.setForeground(new Color(-1));
        sandsSub3.setHorizontalAlignment(2);
        sandsSub3.setHorizontalTextPosition(2);
        sandsSub3.setIconTextGap(0);
        sandsSub3.setPreferredSize(new Dimension(125, 16));
        sandsSub3.setText(" ");
        panel16.add(sandsSub3);
        sandsSub3Val = new JLabel();
        Font sandsSub3ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, sandsSub3Val.getFont());
        if (sandsSub3ValFont != null) sandsSub3Val.setFont(sandsSub3ValFont);
        sandsSub3Val.setForeground(new Color(-1));
        sandsSub3Val.setHorizontalAlignment(2);
        sandsSub3Val.setHorizontalTextPosition(2);
        sandsSub3Val.setIconTextGap(0);
        sandsSub3Val.setPreferredSize(new Dimension(70, 16));
        sandsSub3Val.setText(" ");
        panel16.add(sandsSub3Val);
        sandsSub4 = new JLabel();
        Font sandsSub4Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, sandsSub4.getFont());
        if (sandsSub4Font != null) sandsSub4.setFont(sandsSub4Font);
        sandsSub4.setForeground(new Color(-1));
        sandsSub4.setHorizontalAlignment(2);
        sandsSub4.setHorizontalTextPosition(2);
        sandsSub4.setIconTextGap(0);
        sandsSub4.setPreferredSize(new Dimension(125, 16));
        sandsSub4.setText(" ");
        panel16.add(sandsSub4);
        sandsSub4Val = new JLabel();
        Font sandsSub4ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, sandsSub4Val.getFont());
        if (sandsSub4ValFont != null) sandsSub4Val.setFont(sandsSub4ValFont);
        sandsSub4Val.setForeground(new Color(-1));
        sandsSub4Val.setHorizontalAlignment(2);
        sandsSub4Val.setHorizontalTextPosition(2);
        sandsSub4Val.setIconTextGap(0);
        sandsSub4Val.setPreferredSize(new Dimension(70, 16));
        sandsSub4Val.setText(" ");
        panel16.add(sandsSub4Val);
        goblet.setLayout(new BorderLayout(0, 0));
        goblet.setBackground(new Color(-15658734));
        goblet.setPreferredSize(new Dimension(320, 150));
        panel8.add(goblet);
        final JPanel panel17 = new JPanel();
        panel17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel17.setOpaque(false);
        panel17.setPreferredSize(new Dimension(105, 24));
        goblet.add(panel17, BorderLayout.WEST);
        gobletImage = new JLabel();
        gobletImage.setHorizontalAlignment(0);
        gobletImage.setOpaque(false);
        gobletImage.setPreferredSize(new Dimension(90, 95));
        gobletImage.setText("");
        panel17.add(gobletImage);
        gobletLevel.setLayout(new BorderLayout(0, 0));
        gobletLevel.setBackground(new Color(-14474460));
        gobletLevel.setOpaque(true);
        gobletLevel.setPreferredSize(new Dimension(90, 40));
        panel17.add(gobletLevel);
        gobletPlusLabel = new JLabel();
        Font gobletPlusLabelFont = this.$$$getFont$$$("Rockwell Extra Bold", -1, 26, gobletPlusLabel.getFont());
        if (gobletPlusLabelFont != null) gobletPlusLabel.setFont(gobletPlusLabelFont);
        gobletPlusLabel.setHorizontalAlignment(0);
        gobletPlusLabel.setPreferredSize(new Dimension(0, 40));
        gobletPlusLabel.setRequestFocusEnabled(true);
        gobletPlusLabel.setText("+20");
        gobletLevel.add(gobletPlusLabel, BorderLayout.CENTER);
        final JPanel panel18 = new JPanel();
        panel18.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel18.setOpaque(false);
        panel18.setPreferredSize(new Dimension(50, 50));
        goblet.add(panel18, BorderLayout.CENTER);
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$("Segoe UI Black", -1, 16, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setPreferredSize(new Dimension(100, 17));
        label7.setText("Rank");
        panel18.add(label7);
        gobletRating = new JLabel();
        Font gobletRatingFont = this.$$$getFont$$$("Ink Free", -1, 24, gobletRating.getFont());
        if (gobletRatingFont != null) gobletRating.setFont(gobletRatingFont);
        gobletRating.setForeground(new Color(-657956));
        gobletRating.setPreferredSize(new Dimension(50, 30));
        gobletRating.setText("F");
        panel18.add(gobletRating);
        gobletMain = new JLabel();
        Font gobletMainFont = this.$$$getFont$$$("Segoe UI", -1, 17, gobletMain.getFont());
        if (gobletMainFont != null) gobletMain.setFont(gobletMainFont);
        gobletMain.setForeground(new Color(-29105));
        gobletMain.setHorizontalAlignment(2);
        gobletMain.setPreferredSize(new Dimension(200, 20));
        gobletMain.setText("HP 4,780");
        panel18.add(gobletMain);
        gobletSub1 = new JLabel();
        Font gobletSub1Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, gobletSub1.getFont());
        if (gobletSub1Font != null) gobletSub1.setFont(gobletSub1Font);
        gobletSub1.setForeground(new Color(-1));
        gobletSub1.setHorizontalAlignment(2);
        gobletSub1.setHorizontalTextPosition(2);
        gobletSub1.setIconTextGap(0);
        gobletSub1.setPreferredSize(new Dimension(125, 16));
        gobletSub1.setText(" ");
        panel18.add(gobletSub1);
        gobletSub1Val = new JLabel();
        Font gobletSub1ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, gobletSub1Val.getFont());
        if (gobletSub1ValFont != null) gobletSub1Val.setFont(gobletSub1ValFont);
        gobletSub1Val.setForeground(new Color(-1));
        gobletSub1Val.setHorizontalAlignment(2);
        gobletSub1Val.setHorizontalTextPosition(2);
        gobletSub1Val.setIconTextGap(0);
        gobletSub1Val.setPreferredSize(new Dimension(70, 16));
        gobletSub1Val.setText(" ");
        panel18.add(gobletSub1Val);
        gobletSub2 = new JLabel();
        Font gobletSub2Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, gobletSub2.getFont());
        if (gobletSub2Font != null) gobletSub2.setFont(gobletSub2Font);
        gobletSub2.setForeground(new Color(-1));
        gobletSub2.setHorizontalAlignment(2);
        gobletSub2.setHorizontalTextPosition(2);
        gobletSub2.setIconTextGap(0);
        gobletSub2.setPreferredSize(new Dimension(125, 16));
        gobletSub2.setText(" ");
        panel18.add(gobletSub2);
        gobletSub2Val = new JLabel();
        Font gobletSub2ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, gobletSub2Val.getFont());
        if (gobletSub2ValFont != null) gobletSub2Val.setFont(gobletSub2ValFont);
        gobletSub2Val.setForeground(new Color(-1));
        gobletSub2Val.setHorizontalAlignment(2);
        gobletSub2Val.setHorizontalTextPosition(2);
        gobletSub2Val.setIconTextGap(0);
        gobletSub2Val.setPreferredSize(new Dimension(70, 16));
        gobletSub2Val.setText(" ");
        panel18.add(gobletSub2Val);
        gobletSub3 = new JLabel();
        Font gobletSub3Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, gobletSub3.getFont());
        if (gobletSub3Font != null) gobletSub3.setFont(gobletSub3Font);
        gobletSub3.setForeground(new Color(-1));
        gobletSub3.setHorizontalAlignment(2);
        gobletSub3.setHorizontalTextPosition(2);
        gobletSub3.setIconTextGap(0);
        gobletSub3.setPreferredSize(new Dimension(125, 16));
        gobletSub3.setText(" ");
        panel18.add(gobletSub3);
        gobletSub3Val = new JLabel();
        Font gobletSub3ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, gobletSub3Val.getFont());
        if (gobletSub3ValFont != null) gobletSub3Val.setFont(gobletSub3ValFont);
        gobletSub3Val.setForeground(new Color(-1));
        gobletSub3Val.setHorizontalAlignment(2);
        gobletSub3Val.setHorizontalTextPosition(2);
        gobletSub3Val.setIconTextGap(0);
        gobletSub3Val.setPreferredSize(new Dimension(70, 16));
        gobletSub3Val.setText(" ");
        panel18.add(gobletSub3Val);
        gobletSub4 = new JLabel();
        Font gobletSub4Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, gobletSub4.getFont());
        if (gobletSub4Font != null) gobletSub4.setFont(gobletSub4Font);
        gobletSub4.setForeground(new Color(-1));
        gobletSub4.setHorizontalAlignment(2);
        gobletSub4.setHorizontalTextPosition(2);
        gobletSub4.setIconTextGap(0);
        gobletSub4.setPreferredSize(new Dimension(125, 16));
        gobletSub4.setText(" ");
        panel18.add(gobletSub4);
        gobletSub4Val = new JLabel();
        Font gobletSub4ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, gobletSub4Val.getFont());
        if (gobletSub4ValFont != null) gobletSub4Val.setFont(gobletSub4ValFont);
        gobletSub4Val.setForeground(new Color(-1));
        gobletSub4Val.setHorizontalAlignment(2);
        gobletSub4Val.setHorizontalTextPosition(2);
        gobletSub4Val.setIconTextGap(0);
        gobletSub4Val.setPreferredSize(new Dimension(70, 16));
        gobletSub4Val.setText(" ");
        panel18.add(gobletSub4Val);
        circlet.setLayout(new BorderLayout(0, 0));
        circlet.setBackground(new Color(-15658734));
        circlet.setPreferredSize(new Dimension(320, 150));
        panel8.add(circlet);
        final JPanel panel19 = new JPanel();
        panel19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel19.setOpaque(false);
        panel19.setPreferredSize(new Dimension(105, 24));
        circlet.add(panel19, BorderLayout.WEST);
        circletImage = new JLabel();
        circletImage.setHorizontalAlignment(0);
        circletImage.setOpaque(false);
        circletImage.setPreferredSize(new Dimension(90, 95));
        circletImage.setText("");
        panel19.add(circletImage);
        circletLevel.setLayout(new BorderLayout(0, 0));
        circletLevel.setBackground(new Color(-14474460));
        circletLevel.setOpaque(true);
        circletLevel.setPreferredSize(new Dimension(90, 40));
        panel19.add(circletLevel);
        circletPlusLabel = new JLabel();
        Font circletPlusLabelFont = this.$$$getFont$$$("Rockwell Extra Bold", -1, 26, circletPlusLabel.getFont());
        if (circletPlusLabelFont != null) circletPlusLabel.setFont(circletPlusLabelFont);
        circletPlusLabel.setHorizontalAlignment(0);
        circletPlusLabel.setPreferredSize(new Dimension(0, 40));
        circletPlusLabel.setRequestFocusEnabled(true);
        circletPlusLabel.setText("+20");
        circletLevel.add(circletPlusLabel, BorderLayout.CENTER);
        final JPanel panel20 = new JPanel();
        panel20.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel20.setOpaque(false);
        panel20.setPreferredSize(new Dimension(50, 50));
        circlet.add(panel20, BorderLayout.CENTER);
        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$("Segoe UI Black", -1, 16, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setPreferredSize(new Dimension(100, 17));
        label8.setText("Rank");
        panel20.add(label8);
        circletRating = new JLabel();
        Font circletRatingFont = this.$$$getFont$$$("Ink Free", -1, 24, circletRating.getFont());
        if (circletRatingFont != null) circletRating.setFont(circletRatingFont);
        circletRating.setForeground(new Color(-657956));
        circletRating.setPreferredSize(new Dimension(50, 30));
        circletRating.setText("F");
        panel20.add(circletRating);
        circletMain = new JLabel();
        Font circletMainFont = this.$$$getFont$$$("Segoe UI", -1, 17, circletMain.getFont());
        if (circletMainFont != null) circletMain.setFont(circletMainFont);
        circletMain.setForeground(new Color(-29105));
        circletMain.setHorizontalAlignment(2);
        circletMain.setPreferredSize(new Dimension(200, 20));
        circletMain.setText("HP 4,780");
        panel20.add(circletMain);
        circletSub1 = new JLabel();
        Font circletSub1Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, circletSub1.getFont());
        if (circletSub1Font != null) circletSub1.setFont(circletSub1Font);
        circletSub1.setForeground(new Color(-1));
        circletSub1.setHorizontalAlignment(2);
        circletSub1.setHorizontalTextPosition(2);
        circletSub1.setIconTextGap(0);
        circletSub1.setPreferredSize(new Dimension(125, 16));
        circletSub1.setText(" ");
        panel20.add(circletSub1);
        circletSub1Val = new JLabel();
        Font circletSub1ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, circletSub1Val.getFont());
        if (circletSub1ValFont != null) circletSub1Val.setFont(circletSub1ValFont);
        circletSub1Val.setForeground(new Color(-1));
        circletSub1Val.setHorizontalAlignment(2);
        circletSub1Val.setHorizontalTextPosition(2);
        circletSub1Val.setIconTextGap(0);
        circletSub1Val.setPreferredSize(new Dimension(70, 16));
        circletSub1Val.setText(" ");
        panel20.add(circletSub1Val);
        circletSub2 = new JLabel();
        Font circletSub2Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, circletSub2.getFont());
        if (circletSub2Font != null) circletSub2.setFont(circletSub2Font);
        circletSub2.setForeground(new Color(-1));
        circletSub2.setHorizontalAlignment(2);
        circletSub2.setHorizontalTextPosition(2);
        circletSub2.setIconTextGap(0);
        circletSub2.setPreferredSize(new Dimension(125, 16));
        circletSub2.setText(" ");
        panel20.add(circletSub2);
        circletSub2Val = new JLabel();
        Font circletSub2ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, circletSub2Val.getFont());
        if (circletSub2ValFont != null) circletSub2Val.setFont(circletSub2ValFont);
        circletSub2Val.setForeground(new Color(-1));
        circletSub2Val.setHorizontalAlignment(2);
        circletSub2Val.setHorizontalTextPosition(2);
        circletSub2Val.setIconTextGap(0);
        circletSub2Val.setPreferredSize(new Dimension(70, 16));
        circletSub2Val.setText(" ");
        panel20.add(circletSub2Val);
        circletSub3 = new JLabel();
        Font circletSub3Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, circletSub3.getFont());
        if (circletSub3Font != null) circletSub3.setFont(circletSub3Font);
        circletSub3.setForeground(new Color(-1));
        circletSub3.setHorizontalAlignment(2);
        circletSub3.setHorizontalTextPosition(2);
        circletSub3.setIconTextGap(0);
        circletSub3.setPreferredSize(new Dimension(125, 16));
        circletSub3.setText(" ");
        panel20.add(circletSub3);
        circletSub3Val = new JLabel();
        Font circletSub3ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, circletSub3Val.getFont());
        if (circletSub3ValFont != null) circletSub3Val.setFont(circletSub3ValFont);
        circletSub3Val.setForeground(new Color(-1));
        circletSub3Val.setHorizontalAlignment(2);
        circletSub3Val.setHorizontalTextPosition(2);
        circletSub3Val.setIconTextGap(0);
        circletSub3Val.setPreferredSize(new Dimension(70, 16));
        circletSub3Val.setText(" ");
        panel20.add(circletSub3Val);
        circletSub4 = new JLabel();
        Font circletSub4Font = this.$$$getFont$$$("Segoe UI Semibold", -1, 12, circletSub4.getFont());
        if (circletSub4Font != null) circletSub4.setFont(circletSub4Font);
        circletSub4.setForeground(new Color(-1));
        circletSub4.setHorizontalAlignment(2);
        circletSub4.setHorizontalTextPosition(2);
        circletSub4.setIconTextGap(0);
        circletSub4.setPreferredSize(new Dimension(125, 16));
        circletSub4.setText(" ");
        panel20.add(circletSub4);
        circletSub4Val = new JLabel();
        Font circletSub4ValFont = this.$$$getFont$$$("Segoe UI Semibold", -1, 14, circletSub4Val.getFont());
        if (circletSub4ValFont != null) circletSub4Val.setFont(circletSub4ValFont);
        circletSub4Val.setForeground(new Color(-1));
        circletSub4Val.setHorizontalAlignment(2);
        circletSub4Val.setHorizontalTextPosition(2);
        circletSub4Val.setIconTextGap(0);
        circletSub4Val.setPreferredSize(new Dimension(70, 16));
        circletSub4Val.setText(" ");
        panel20.add(circletSub4Val);
        explanationButton = new JButton();
        explanationButton.setBackground(new Color(-13947600));
        Font explanationButtonFont = this.$$$getFont$$$("Franklin Gothic Heavy", -1, 15, explanationButton.getFont());
        if (explanationButtonFont != null) explanationButton.setFont(explanationButtonFont);
        explanationButton.setForeground(new Color(-599034));
        explanationButton.setOpaque(false);
        explanationButton.setPreferredSize(new Dimension(200, 50));
        explanationButton.setText("Rating Explanation");
        panel8.add(explanationButton);
        returnButton = new JButton();
        returnButton.setBackground(new Color(-13947600));
        Font returnButtonFont = this.$$$getFont$$$("Franklin Gothic Heavy", -1, 15, returnButton.getFont());
        if (returnButtonFont != null) returnButton.setFont(returnButtonFont);
        returnButton.setForeground(new Color(-2537728));
        returnButton.setOpaque(false);
        returnButton.setPreferredSize(new Dimension(200, 50));
        returnButton.setText("Return to Selection");
        panel8.add(returnButton);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
