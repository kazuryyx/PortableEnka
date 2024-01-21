package me.kazury.portableenka;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import me.kazury.portableenka.util.UpdateTask;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static MenuManager menuManager;
    private static EnkaFetcher fetcher;
    private static EnkaCache enkaCache;

    public static void main(String[] args) {
        final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        System.out.println("Starting application on screen size: " + screenWidth + "x" + screenHeight);

        if (screenWidth < 1920 || screenHeight < 1080) {
            System.out.println("Screen size is too small, exiting...");
            System.exit(0);
        }

        FlatLightLaf.setup();

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
