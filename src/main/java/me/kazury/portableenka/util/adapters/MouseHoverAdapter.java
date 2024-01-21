package me.kazury.portableenka.util.adapters;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class MouseHoverAdapter extends MouseAdapter {
    private final Consumer<MouseEvent> enter;
    private final Consumer<MouseEvent> exit;

    public MouseHoverAdapter(Consumer<MouseEvent> enter, Consumer<MouseEvent> exit) {
        this.enter = enter;
        this.exit = exit;
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        this.enter.accept(event);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        this.exit.accept(event);
    }
}
