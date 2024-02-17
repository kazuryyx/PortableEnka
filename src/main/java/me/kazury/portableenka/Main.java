package me.kazury.portableenka;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import me.kazury.portableenka.util.GlobalConfig;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Main {
    private static MenuManager menuManager;
    private static EnkaFetcher fetcher;
    private static EnkaCache enkaCache;

    private static URI uri;

    public static void main(String[] args) {
        final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        System.out.println("Starting application on screen size: " + screenWidth + "x" + screenHeight);

        if (screenWidth < GlobalConfig.CARD_FRAME_SIZE.width || screenHeight < GlobalConfig.CARD_FRAME_SIZE.height) {
            System.out.println("Screen size is too small, exiting...");
            System.exit(0);
        }

        FlatLightLaf.setup();

        uri = URI.create("https://github.com/kazuryyx/PortableEnka/blob/main/README.md#rating-explanation");

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

        menuManager = new MenuManager();
        fetcher = new EnkaFetcher();
        enkaCache = new EnkaCache();

        /**
        if (new UpdateTask().getLatestVersion().isUpdateAvailable()) {
            menuManager.openOutdatedFrame();
            return;
        }
        */

        menuManager.openUIDFrame();
    }

    public static void redirectToReadMe() {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @NotNull
    public static MenuManager getMenuManager() {
        return menuManager;
    }

    @NotNull
    public static EnkaFetcher getFetcher() {
        return fetcher;
    }

    @NotNull
    public static EnkaCache getCache() {
        return enkaCache;
    }
}
