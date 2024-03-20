package booleanConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BooleanConverterTest {
    @Test
    public void collectListOfNumbers_returnBooleanEquivalentTest(){
        BooleanConverter converter = new BooleanConverter();
        int[] sample = {4, 5, 8, 8, 8, 2, 9};
        boolean[] outPutArray = {false, true, false, false, false, false, true};

        assertArrayEquals(outPutArray, converter.getBooleanEquivalentOf(sample));
    }

    @Test
    public void collectAnotherListOfNumbers_returnBooleanEquivalentTest(){
        BooleanConverter converter = new BooleanConverter();
        int[] sample = {7, 5, 8, 8, 10, 2, 9};
        boolean[] outPutArray = {true, true, false, false, false, false, true};

        assertArrayEquals(outPutArray, converter.getBooleanEquivalentOf(sample));
    }
}
