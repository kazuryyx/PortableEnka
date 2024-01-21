package me.kazury.portableenka.util.adapters;

import org.jetbrains.annotations.NotNull;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.function.Consumer;

public class DocumentRemoveEvent implements DocumentListener {
    private final Consumer<DocumentEvent> consumer;

    public DocumentRemoveEvent(@NotNull Consumer<DocumentEvent> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void removeUpdate(DocumentEvent event) {
        this.consumer.accept(event);
    }

    @Override
    public void insertUpdate(DocumentEvent event) {}

    @Override
    public void changedUpdate(DocumentEvent event) {}
}
