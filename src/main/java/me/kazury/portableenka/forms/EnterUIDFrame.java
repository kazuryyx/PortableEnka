package me.kazury.portableenka.forms;

import me.kazury.portableenka.Main;
import me.kazury.portableenka.MenuManager;
import me.kazury.portableenka.util.GlobalConfig;
import me.kazury.portableenka.util.RoundedBorder;
import me.kazury.portableenka.util.adapters.DocumentRemoveEvent;
import me.kazury.portableenka.util.adapters.FocusAdapter;
import me.kazury.portableenka.util.adapters.MouseClickAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class EnterUIDFrame extends JFrame {
    private final Pattern pattern = Pattern.compile("^(18|[1-35-9])\\d{8}$");

    public JPanel mainPanel;
    public JTextArea textBox;
    public JPanel enterLabel;
    public JLabel proceed;

    public JButton ratingExplanationButton;

    public void afterInit() {
        final MenuManager menuManager = Main.getMenuManager();

        this.proceed.addMouseListener(new MouseClickAdapter((event) -> {
            final String text = textBox.getText();

            if (text.equals("Enter UID...")) return;
            if (text.isBlank()) return;

            if (!this.pattern.matcher(text).matches()) {
                final ErrorFrame errorFrame = menuManager.openErrorFrame(
                        "Invalid UID",
                        "UID must be 9 (or 10) digits long and number.",
                        this);

                errorFrame.quitButton.addMouseListener(new MouseClickAdapter((ev) -> menuManager.openUIDFrame(errorFrame)));
                return;
            }

            final long uid = Long.parseLong(text);
            final JFrame loadingFrame = Main.getMenuManager().openLoadingFrame(this);

            menuManager.openSelectionFrame(uid, loadingFrame);
        }));

        this.textBox.setText("Enter UID...");
        this.textBox.setForeground(Color.decode("#c2c6cc"));

        this.textBox.addFocusListener(new FocusAdapter((event) -> {
            final String text = this.textBox.getText();
            if (!text.equals("Enter UID...")) return;

            this.textBox.setText("");
            this.textBox.setForeground(Color.WHITE);
        }, (event) -> {
            final String text = this.textBox.getText();
            if (!text.isEmpty()) return;

            this.textBox.setForeground(Color.decode("#c2c6cc"));
            this.textBox.setText("Enter UID...");
        }));
    }

    private void createUIComponents() {
        this.enterLabel = RoundedBorder.adjustPanel(
                new Dimension(400, 75),
                GlobalConfig.ROUNDED_BORDER_COLOR,
                new FlowLayout(),
                32, 32
        );
    }
}
