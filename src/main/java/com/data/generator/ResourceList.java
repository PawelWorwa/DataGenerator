package com.data.generator;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceList {
    private final List<String> resources = new ArrayList<>();
    private String filePath;

    public ResourceList(String filePath) {
        this.filePath = absolutePathToResource(filePath);
        populateList();
    }

    private static String absolutePathToResource(String filePath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);

        return new File(url.getPath())
                .toPath()
                .toAbsolutePath()
                .toString();
    }

    private void populateList() {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.filter(line -> !line.isEmpty())
                    .collect(Collectors.toList())
                    .forEach(resources::add);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
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