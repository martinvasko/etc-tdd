package at.etc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
