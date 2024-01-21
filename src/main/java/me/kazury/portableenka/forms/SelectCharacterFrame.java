package me.kazury.portableenka.forms;

import me.kazury.portableenka.util.CharacterSelectionPanel;
import me.kazury.portableenka.util.GlobalConfig;
import me.kazury.portableenka.util.RoundedBorder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
}
