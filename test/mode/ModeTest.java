package mode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ModeTest {
    @Test
    public void getNumberOfOccurenceAndMostOccuringNumberTest(){
        Mode mode = new Mode();
        int[] numbers = {1, 2,2, 3, 4, 2};
        int[] actual = mode.getNumberOfOccurenceAndMostOccuringNumberFrom(numbers);
        int[] expected = {3,2};
        assertArrayEquals(expected, actual);
    }
}
