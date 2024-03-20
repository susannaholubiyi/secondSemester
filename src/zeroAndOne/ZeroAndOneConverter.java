package zeroAndOne;

public class ZeroAndOneConverter {
    public int[] getBinaryEquivalentOf(int[] sampleInput) {
        int[] outputArray = new int[sampleInput.length];
        for(int index = 0; index < sampleInput.length; index++){
            if(sampleInput[index] % 2 == 0)
                outputArray[index] = 0;
            else
                outputArray[index] = 1;
        }
        return outputArray;
    }
}
