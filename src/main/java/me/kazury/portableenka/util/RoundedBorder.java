package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorder extends JPanel {
    private final Dimension size;
    private final int arcWidth;
    private final int arcHeight;

    public RoundedBorder(final int arcWidth,
                         final int arcHeight,
                         @NotNull Dimension size,
                         @NotNull Color bg,
                         @NotNull LayoutManager layout) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.size = size;

        this.setLayout(layout);
        this.setBackground(bg);
        this.setPreferredSize(this.size);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2d = (Graphics2D) g.create();
        final int width = (int) this.size.getWidth();
        final int height = (int) this.size.getHeight();

        final RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
                0,
                0,
                width,
                height,
                this.arcWidth,
                this.arcHeight
        );

        g2d.setColor(this.getBackground());
        g2d.fill(roundedRectangle);
        g2d.dispose();
    }

    @NotNull
    public static JPanel adjustPanel(@NotNull Dimension size,
                               @NotNull Color bg,
                               @NotNull LayoutManager layout,
                               final int arcWidth,
                               final int arcHeight) {
        return new RoundedBorder(arcWidth, arcHeight, size, bg, layout);
    }

    @NotNull
    public static JPanel adjustPanel(@NotNull Dimension size,
                               @NotNull Color bg,
                               @NotNull LayoutManager layout) {
        return adjustPanel(size, bg, layout, 48, 48);
    }
}
