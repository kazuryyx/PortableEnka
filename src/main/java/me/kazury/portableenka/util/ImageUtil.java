package me.kazury.portableenka.util;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ImageUtil {
    private static final Map<String, ImageIcon> iconCache = new ConcurrentHashMap<>();

    @NotNull
    public static ImageIcon scale(@NotNull String url, final double hScale, final double wScale) {
        if (iconCache.containsKey(url)) {
            return iconCache.get(url);
        }

        try {
            final ImageIcon icon = new ImageIcon(new URL(url));
            final int newHeight = (int) (icon.getIconHeight() * hScale);
            final int newWidth = (int) (icon.getIconWidth() * wScale);

            final Image image = icon.getImage();
            final Image scaled = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            final ImageIcon imageIcon = new ImageIcon(scaled);
            return iconCache.computeIfAbsent(url, ($) -> imageIcon);
        } catch (Exception exception) {
            return new ImageIcon();
        }
    }
}
