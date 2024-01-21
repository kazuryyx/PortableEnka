package me.kazury.portableenka.util;

import org.jetbrains.annotations.NotNull;

public class UpdateObject {
    private final boolean canUpdate;

    @NotNull
    private final String newVersion;

    public UpdateObject(final boolean canUpdate, @NotNull String newVersion) {
        this.canUpdate = canUpdate;
        this.newVersion = newVersion;
    }

    public boolean isUpdateAvailable() {
        return this.canUpdate;
    }

    @NotNull
    public String getNewVersion() {
        return this.newVersion;
    }
}
