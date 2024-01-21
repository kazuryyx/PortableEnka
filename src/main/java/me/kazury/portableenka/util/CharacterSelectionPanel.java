package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CharacterSelectionPanel {
    @NotNull
    private final JPanel parent;

    @NotNull
    private final JLabel nameLabel;

    @NotNull
    private final JLabel imageLabel;

    public CharacterSelectionPanel(@NotNull JPanel parent,
                                   @NotNull JLabel nameLabel,
                                   @NotNull JLabel imageLabel) {
        this.parent = parent;
        this.nameLabel = nameLabel;
        this.imageLabel = imageLabel;
    }

    @NotNull
    public JPanel getParent() {
        return this.parent;
    }

    @NotNull
    public JLabel getNameLabel() {
        return this.nameLabel;
    }

    @NotNull
    public JLabel getImageLabel() {
        return this.imageLabel;
    }
}
