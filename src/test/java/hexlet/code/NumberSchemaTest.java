package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    public static final int NUM_TO_CHECK_11 = 11;
    public static final int NUM_TO_CHECK_10 = 10;
    public static final int NUM_TO_CHECK_4 = 4;
    public static final int NUM_TO_CHECK_5 = 5;
    public static final int NUM_TO_CHECK_NEGATIVE10 = -10;



    @Test
    void isValid() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null)); // true
        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(NUM_TO_CHECK_10)); // true
        assertFalse(schema.isValid("5")); // false

        assertTrue(schema.positive().isValid(NUM_TO_CHECK_10)); // true
        assertFalse(schema.isValid(NUM_TO_CHECK_NEGATIVE10)); // false

        schema.range(NUM_TO_CHECK_5, NUM_TO_CHECK_10);

        assertTrue(schema.isValid(NUM_TO_CHECK_5)); // true
        assertTrue(schema.isValid(NUM_TO_CHECK_10)); // true
        assertFalse(schema.isValid(NUM_TO_CHECK_4)); // false
        assertFalse(schema.isValid(NUM_TO_CHECK_11)); // false

    }

    @Test
    void isValid1() {
        Validator v = new Validator();
        NumberSchema schema = v.number().positive();

        assertTrue(schema.isValid(null)); // true
        schema.required();
    }
}
