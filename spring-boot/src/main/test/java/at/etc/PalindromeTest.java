package at.etc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    private Palindrome cut;

    @BeforeEach
    public void setUp() {
        cut = new Palindrome();
    }

    @Test
    public void whenEmptyString_thenAccept() {
        assertTrue(cut.isPalindrome(""));
    }
}