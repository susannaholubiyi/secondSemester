package mode;public class Mode {

    public int[] getNumberOfOccurenceAndMostOccuringNumberFrom(int[] numbers) {
        int[] output = new int[2];
        for (int number: numbers){
            int numberOfOccurrence = 0;
            for (int index : numbers){
                if (number == index)
                    numberOfOccurrence++;
            }
            if (numberOfOccurrence > output[0]) {
                output[0] = numberOfOccurrence;
                output[1] = number;
            }
        }
        return output;
    }
}
