package at.etc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CaluclatorTest {

    private Calculator cut;

    @BeforeEach
    void setUp() {
        cut = new Calculator();
    }

    @Test
    void testMultiply() {
        assertEquals(10, cut.multiply(2, 5));
    }

    @Test
    void testThrowsNull() {
        String value = null;
        int input = Integer.valueOf(value);
        assertThrows(NumberFormatException.class,() -> cut.multiply(input, 10));
    }
}
