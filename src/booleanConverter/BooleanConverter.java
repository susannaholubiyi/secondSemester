package booleanConverter;

public class BooleanConverter {


    public boolean[] getBooleanEquivalentOf(int[] sample) {
        boolean[] outputArray = new boolean[sample.length];
        for (int index = 0; index < sample.length; index++){ outputArray[index] = sample[index] % 2 ==1;
        }
        return outputArray;
    }


}
