package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.config.WithConverter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class MapResourceTest {
    @WithConverter(MapConverter.class)
    @ConfigProperty(name = "mapping")
    Map<String, String> mapping;

    @Test
    void testMapping() {
        assert mapping != null;
    }
}