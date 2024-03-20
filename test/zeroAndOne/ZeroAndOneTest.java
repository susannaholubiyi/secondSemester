package zeroAndOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZeroAndOneTest {

    @Test
    public void collectSampleArray_ArrayReturnsZerosAndOneTest(){
        ZeroAndOneConverter converter = new ZeroAndOneConverter();
        int[] sampleInput = {4, 5, 8, 8, 8, 2, 9};
        int[] outputArray = {0, 1, 0, 0, 0, 0, 1};
        assertArrayEquals(outputArray, converter.getBinaryEquivalentOf(sampleInput));

    }
}
