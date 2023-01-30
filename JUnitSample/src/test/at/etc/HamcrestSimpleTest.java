package at.etc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;

public class HamcrestSimpleTest {

    private static List<Integer> list = Arrays.asList(7, 5, 12, 16);

    @Test
    void listContainsFourElements() {
        assertThat(list, hasSize(4));
    }

    @Test
    void listContainsElementsInOrder() {
        assertThat(list, contains(7,5,12,16));
    }
}
