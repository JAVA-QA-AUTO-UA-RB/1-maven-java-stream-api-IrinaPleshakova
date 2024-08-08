package org.example.helpers;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourceLoader {

    public static String getResourcePath(String filename) {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        URL resourceUrl = Objects.requireNonNull(classLoader.getResource(filename), "File not found: " + filename);

        // The URI is needed to deal with spaces and other special chars in paths
        URI resourceUri;
        try {
            resourceUri = resourceUrl.toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Could not convert URL to URI: " + resourceUrl, e);
        }

        Path path = Paths.get(resourceUri);
        return path.toString();
    }
}