package hexlet.code;


import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    public static final int NUM_TO_CHECK_100 = 100;
    public static final int NUM_TO_CHECK_NEGATIVE5 = -5;
    @Test
    void isValid() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true
        schema.required();

        assertFalse(schema.isValid(null)); // false

        assertTrue(schema.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");


        assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);

        assertFalse(schema.isValid(data)); // false

        data.put("key2", "value2");

        assertTrue(schema.isValid(data)); // true*/
    }
    @Test
    void isTheShapeValid() {

        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", NUM_TO_CHECK_100);
        assertTrue(schema.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", NUM_TO_CHECK_NEGATIVE5);
        assertFalse(schema.isValid(human4)); // false
    }
}
