package com.data.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ResourceList {
    private List<String> resources = new ArrayList<>();
    private String filePath;

    public ResourceList(String filePath) {
        this.filePath = filePath;
        populateList();
    }

    private void populateList() {
        try (InputStream stream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filePath)) {

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(stream, StandardCharsets.UTF_8))) {

                resources = reader.lines()
                        .collect(Collectors.toList());
            }

        } catch (IOException e) {
            throw new UncheckedIOException("Something went wrong during accessing resource file!", e);
        }
    }

    public String randomResource() {
        return resources.get(
                ThreadLocalRandom.current()
                        .nextInt(0, resources.size() - 1));
    }

    public List<String> getResources() {
        return resources;
    }
}