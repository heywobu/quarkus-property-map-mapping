# quarkus-property-map-mapping

Reproducer of reading a config map property in Quarkus

[application.properties](src/main/resources/application.properties)

This is the syntax we need:
```properties
mapping=[key1:value1,key2:value2]
```

## Running the failing test

```shell script
./gradlew quarkusTest
```

the conversion fails with the following error:
```shell script
org.junit.jupiter.api.extension.ParameterResolutionException: No ParameterResolver registered for parameter [java.util.Map<java.lang.String, java.lang.String> mapping] in constructor [public org.example.MapResourceTest(java.util.Map<java.lang.String,java.lang.String>)].
Suppressed: java.util.NoSuchElementException: SRCFG00042: Value does not match the expected map format "<key1>=<value1>;<key2>=<value2>..." (value was "[key1:value1,key2:value2]")

```


## Running the successfull test
Comment out the `mapping` property & asserts in [MapResourceTest](src/test/java/org/example/MapResourceTest.java) and run the tests again:

```shell script
./gradlew quarkusTest
```

the conversion with wrapper around Map<String, String> succeeds