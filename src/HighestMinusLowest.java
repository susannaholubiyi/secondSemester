

public class HighestMinusLowest {
    public int[] getMaxMinusMin(int[] input) {
        int min = input[0];
        int max = input[0];
        int[] outputArray = new int[1];
        for (int number : input){
            if( number < min){ min = number;}
            if( number > max) {max = number;}
        }

        int output = max - min;
        outputArray[0] = output;
        return outputArray;
    }
}
