package me.kazury.portableenka.util.adapters;

import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class MouseClickAdapter extends MouseAdapter {
    private final Consumer<MouseEvent> consumer;

    public MouseClickAdapter(@NotNull Consumer<MouseEvent> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void mouseClicked(@NotNull MouseEvent event) {
        this.consumer.accept(event);
    }
}
