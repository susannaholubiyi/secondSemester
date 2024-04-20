import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HighestMinusLowestTest {
    @Test
    public void functionTakesInNumbers_returnsMaxMinusMinTest(){
        HighestMinusLowest highestMinusLowest = new HighestMinusLowest();
        int[] input = {2,1, 3, 4, 9};
        highestMinusLowest.getMaxMinusMin(input);
        int[] expected = {8};
        assertArrayEquals(expected, highestMinusLowest.getMaxMinusMin(input));
    }
}
