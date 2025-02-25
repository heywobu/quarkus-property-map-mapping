package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.config.WithConverter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.util.Map;

@QuarkusTest
class RecordMapResourceTest {
    @WithConverter(RecordMapConverter.class)
    @ConfigProperty(name = "mapping")
    CustomProp mapping;

    @Test
    void testMapping() {
        assert mapping.mapping() != null;
        assert mapping.mapping().get("key1").equals("value1");
        assert mapping.mapping().get("key2").equals("value2");
    }
}