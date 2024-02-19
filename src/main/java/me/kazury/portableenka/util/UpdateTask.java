package me.kazury.portableenka.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class UpdateTask {
    public static final String CURRENT_VERSION = "V1.1";

    private static final String GITHUB_URL = "https://api.github.com/repos/kazuryyx/PortableEnka/releases/latest";

    @NotNull
    public UpdateObject getLatestVersion() {
        String newVersion = CURRENT_VERSION;

        try (final JsonReader reader = this.getJsonReader()) {
            final Gson gson = new Gson(); // only called once so doesn't matter
            final Map<?, ?> map = gson.fromJson(reader, Map.class);

            newVersion = (String) map.get("tag_name");
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            // Quietly fails, do not spam stack traces.
        }
        // No version found, return the current version (also latest)
        return new UpdateObject(!newVersion.equals(CURRENT_VERSION), newVersion);
    }


    @NotNull
    private JsonReader getJsonReader() throws IOException {
        final URL url = new URL(GITHUB_URL);

        URLConnection connection = url.openConnection();

        connection.setReadTimeout(5000);
        connection.addRequestProperty("User-Agent", "PortableEnka Update Checker");
        connection.setDoOutput(false);

        final String redirect = connection.getHeaderField("Location");
        if (redirect != null) {
            connection = new URL(redirect).openConnection();
        }

        final JsonReader reader = new JsonReader(new InputStreamReader(connection.getInputStream()));
        reader.setLenient(true);
        return reader;
    }
}
