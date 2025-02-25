package org.example;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Map;

public class MapResource {

    @ConfigProperty(name = "mapping")
    Map<String, String> mapping;

    private Map<String, String> getMapping() {
        return mapping;
    }
}
