package me.kazury.portableenka.util.adapters;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Consumer;

public class FocusAdapter implements FocusListener {
    private final Consumer<FocusEvent> consumer1;
    private final Consumer<FocusEvent> consumer2;

    public FocusAdapter(Consumer<FocusEvent> consumer1, Consumer<FocusEvent> consumer2) {
        this.consumer1 = consumer1;
        this.consumer2 = consumer2;
    }

    @Override
    public void focusGained(FocusEvent event) {
        this.consumer1.accept(event);
    }

    @Override
    public void focusLost(FocusEvent event) {
        this.consumer2.accept(event);
    }
}
