package org.esgi.cleanarchi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ResourceUtils {
    public static String getContentStringFromResource(String filePath) {
        return new BufferedReader(
            new InputStreamReader(ResourceUtils.class.getResourceAsStream(filePath), StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n"));
    }
}
