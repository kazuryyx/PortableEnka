package me.kazury.portableenka.forms;

import me.kazury.portableenka.util.CharacterSelectionPanel;
import me.kazury.portableenka.util.GlobalConfig;
import me.kazury.portableenka.util.RoundedBorder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.List;
import java.util.Locale;

public class SelectCharacterFrame extends JFrame {
    public JPanel mainPanel;

    private JPanel viewUser;
    private JPanel character8;
    private JPanel character7;
    private JPanel character6;
    private JPanel character5;
    private JPanel character4;
    private JPanel character3;
    private JPanel character2;
    private JPanel character1;

    private JLabel character8Name;
    private JLabel character8Image;
    private JLabel character7Name;
    private JLabel character7Image;
    private JLabel character6Name;
    private JLabel character6Image;
    private JLabel character5Name;
    private JLabel character5Image;
    private JLabel character4Name;
    private JLabel character4Image;
    private JLabel character3Name;
    private JLabel character3Image;
    private JLabel character2Name;
    private JLabel character2Image;
    private JLabel character1Name;
    private JLabel character1Image;

    public JLabel viewUserLabel;
    public JLabel viewUserImage;

    public JButton returnButton;

    private void createUIComponents() {
        this.character1 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character2 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character3 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character4 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character5 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character6 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character7 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.character8 = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );

        this.viewUser = RoundedBorder.adjustPanel(
                new Dimension(200, 140),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                24, 24
        );
    }

    @NotNull
    public List<CharacterSelectionPanel> getCharacterComponents() {
        return List.of(
                new CharacterSelectionPanel(character1, character1Name, character1Image),
                new CharacterSelectionPanel(character2, character2Name, character2Image),
                new CharacterSelectionPanel(character3, character3Name, character3Image),
                new CharacterSelectionPanel(character4, character4Name, character4Image),
                new CharacterSelectionPanel(character5, character5Name, character5Image),
                new CharacterSelectionPanel(character6, character6Name, character6Image),
                new CharacterSelectionPanel(character7, character7Name, character7Image),
                new CharacterSelectionPanel(character8, character8Name, character8Image)
        );
    }

    @NotNull
    public CharacterSelectionPanel fromIndex(final int index) {
        return switch (index) {
            case 0 -> new CharacterSelectionPanel(character1, character1Name, character1Image);
            case 1 -> new CharacterSelectionPanel(character2, character2Name, character2Image);
            case 2 -> new CharacterSelectionPanel(character3, character3Name, character3Image);
            case 3 -> new CharacterSelectionPanel(character4, character4Name, character4Image);
            case 4 -> new CharacterSelectionPanel(character5, character5Name, character5Image);
            case 5 -> new CharacterSelectionPanel(character6, character6Name, character6Image);
            case 6 -> new CharacterSelectionPanel(character7, character7Name, character7Image);
            case 7 -> new CharacterSelectionPanel(character8, character8Name, character8Image);
            default -> throw new IllegalStateException("Unexpected value: " + index);
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
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPanel.setAlignmentY(0.5f);
        mainPanel.setFocusCycleRoot(false);
        character1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character1.setBackground(new Color(-15658734));
        character1.setForeground(new Color(-1));
        character1.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character1);
        character1Name = new JLabel();
        Font character1NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character1Name.getFont());
        if (character1NameFont != null) character1Name.setFont(character1NameFont);
        character1Name.setHorizontalAlignment(0);
        character1Name.setHorizontalTextPosition(0);
        character1Name.setPreferredSize(new Dimension(150, 17));
        character1Name.setText("Furina");
        character1Name.setVerticalAlignment(0);
        character1Name.setVerticalTextPosition(0);
        character1.add(character1Name);
        character1Image = new JLabel();
        character1Image.setPreferredSize(new Dimension(100, 100));
        character1Image.setText("");
        character1.add(character1Image);
        character2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character2.setBackground(new Color(-15658734));
        character2.setForeground(new Color(-1));
        character2.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character2);
        character2Name = new JLabel();
        Font character2NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character2Name.getFont());
        if (character2NameFont != null) character2Name.setFont(character2NameFont);
        character2Name.setHorizontalAlignment(0);
        character2Name.setHorizontalTextPosition(0);
        character2Name.setPreferredSize(new Dimension(150, 17));
        character2Name.setText("Furina");
        character2Name.setVerticalAlignment(0);
        character2Name.setVerticalTextPosition(0);
        character2.add(character2Name);
        character2Image = new JLabel();
        character2Image.setPreferredSize(new Dimension(100, 100));
        character2Image.setText("");
        character2.add(character2Image);
        character3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character3.setBackground(new Color(-15658734));
        character3.setForeground(new Color(-1));
        character3.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character3);
        character3Name = new JLabel();
        Font character3NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character3Name.getFont());
        if (character3NameFont != null) character3Name.setFont(character3NameFont);
        character3Name.setHorizontalAlignment(0);
        character3Name.setHorizontalTextPosition(0);
        character3Name.setPreferredSize(new Dimension(150, 17));
        character3Name.setText("Furina");
        character3Name.setVerticalAlignment(0);
        character3Name.setVerticalTextPosition(0);
        character3.add(character3Name);
        character3Image = new JLabel();
        character3Image.setPreferredSize(new Dimension(100, 100));
        character3Image.setText("");
        character3.add(character3Image);
        character4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character4.setBackground(new Color(-15658734));
        character4.setForeground(new Color(-1));
        character4.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character4);
        character4Name = new JLabel();
        Font character4NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character4Name.getFont());
        if (character4NameFont != null) character4Name.setFont(character4NameFont);
        character4Name.setHorizontalAlignment(0);
        character4Name.setHorizontalTextPosition(0);
        character4Name.setPreferredSize(new Dimension(150, 17));
        character4Name.setText("Furina");
        character4Name.setVerticalAlignment(0);
        character4Name.setVerticalTextPosition(0);
        character4.add(character4Name);
        character4Image = new JLabel();
        character4Image.setPreferredSize(new Dimension(100, 100));
        character4Image.setText("");
        character4.add(character4Image);
        character5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character5.setBackground(new Color(-15658734));
        character5.setForeground(new Color(-1));
        character5.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character5);
        character5Name = new JLabel();
        Font character5NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character5Name.getFont());
        if (character5NameFont != null) character5Name.setFont(character5NameFont);
        character5Name.setHorizontalAlignment(0);
        character5Name.setHorizontalTextPosition(0);
        character5Name.setPreferredSize(new Dimension(150, 17));
        character5Name.setText("Furina");
        character5Name.setVerticalAlignment(0);
        character5Name.setVerticalTextPosition(0);
        character5.add(character5Name);
        character5Image = new JLabel();
        character5Image.setPreferredSize(new Dimension(100, 100));
        character5Image.setText("");
        character5.add(character5Image);
        character6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character6.setBackground(new Color(-15658734));
        character6.setForeground(new Color(-1));
        character6.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character6);
        character6Name = new JLabel();
        Font character6NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character6Name.getFont());
        if (character6NameFont != null) character6Name.setFont(character6NameFont);
        character6Name.setHorizontalAlignment(0);
        character6Name.setHorizontalTextPosition(0);
        character6Name.setPreferredSize(new Dimension(150, 17));
        character6Name.setText("Furina");
        character6Name.setVerticalAlignment(0);
        character6Name.setVerticalTextPosition(0);
        character6.add(character6Name);
        character6Image = new JLabel();
        character6Image.setPreferredSize(new Dimension(100, 100));
        character6Image.setText("");
        character6.add(character6Image);
        character7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character7.setBackground(new Color(-15658734));
        character7.setForeground(new Color(-1));
        character7.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character7);
        character7Name = new JLabel();
        Font character7NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character7Name.getFont());
        if (character7NameFont != null) character7Name.setFont(character7NameFont);
        character7Name.setHorizontalAlignment(0);
        character7Name.setHorizontalTextPosition(0);
        character7Name.setPreferredSize(new Dimension(150, 17));
        character7Name.setText("Furina");
        character7Name.setVerticalAlignment(0);
        character7Name.setVerticalTextPosition(0);
        character7.add(character7Name);
        character7Image = new JLabel();
        character7Image.setPreferredSize(new Dimension(100, 100));
        character7Image.setText("");
        character7.add(character7Image);
        character8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        character8.setBackground(new Color(-15658734));
        character8.setForeground(new Color(-1));
        character8.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(character8);
        character8Name = new JLabel();
        Font character8NameFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, character8Name.getFont());
        if (character8NameFont != null) character8Name.setFont(character8NameFont);
        character8Name.setHorizontalAlignment(0);
        character8Name.setHorizontalTextPosition(0);
        character8Name.setPreferredSize(new Dimension(150, 17));
        character8Name.setText("Furina");
        character8Name.setVerticalAlignment(0);
        character8Name.setVerticalTextPosition(0);
        character8.add(character8Name);
        character8Image = new JLabel();
        character8Image.setPreferredSize(new Dimension(100, 100));
        character8Image.setText("");
        character8.add(character8Image);
        viewUser.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        viewUser.setBackground(new Color(-15658734));
        viewUser.setForeground(new Color(-1));
        viewUser.setPreferredSize(new Dimension(200, 140));
        mainPanel.add(viewUser);
        viewUserLabel = new JLabel();
        Font viewUserLabelFont = this.$$$getFont$$$("Segoe UI Black", -1, 14, viewUserLabel.getFont());
        if (viewUserLabelFont != null) viewUserLabel.setFont(viewUserLabelFont);
        viewUserLabel.setHorizontalAlignment(0);
        viewUserLabel.setHorizontalTextPosition(0);
        viewUserLabel.setPreferredSize(new Dimension(140, 17));
        viewUserLabel.setRequestFocusEnabled(false);
        viewUserLabel.setText("View Public Details");
        viewUserLabel.setVerticalAlignment(0);
        viewUserLabel.setVerticalTextPosition(0);
        viewUser.add(viewUserLabel);
        viewUserImage = new JLabel();
        viewUserImage.setPreferredSize(new Dimension(100, 100));
        viewUserImage.setText("");
        viewUser.add(viewUserImage);
        returnButton = new JButton();
        returnButton.setForeground(new Color(-1755087));
        returnButton.setText("Quit");
        viewUser.add(returnButton);
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
