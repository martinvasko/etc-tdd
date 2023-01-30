package at.etc;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MainTest {

    private static Logger log = Logger.getLogger(MainTest.class.getName());

    @BeforeAll
    public static void setUp() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - exectues before each test method in this class");
    }


    @Test
    public void simpleTest() {
        assertTrue(true);
    }

    @Test
    public void assumeSomething() {
        assumeTrue(10 > 1);
        assertEquals((9 + 1), 10);
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executes after each test method");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods");
    }
}
