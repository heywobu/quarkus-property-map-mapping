package org.example;

import jakarta.annotation.Priority;
import org.eclipse.microprofile.config.spi.Converter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MapConverter implements Converter<CustomProp> {

    @Override
    public CustomProp convert(String stringMap) {
        if (stringMap.startsWith("[") && stringMap.endsWith("]")) {
            stringMap = stringMap.substring(1, stringMap.length() - 1);
        }
        return new CustomProp(Arrays.stream(stringMap.split(","))
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(entry -> entry[0].trim(), entry -> entry[1].trim())));
    }
}
