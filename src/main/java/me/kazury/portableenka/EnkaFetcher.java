package me.kazury.portableenka;

import me.kazury.enkanetworkapi.enka.EnkaNetworkAPI;
import org.jetbrains.annotations.NotNull;

public class EnkaFetcher {
    private final EnkaNetworkAPI api;

    public EnkaFetcher() {
        this.api = new EnkaNetworkAPI();
    }

    @NotNull
    public EnkaNetworkAPI getApi() {
        return this.api;
    }
}
