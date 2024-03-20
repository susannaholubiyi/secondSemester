package SevenSevenDisplay;

import java.util.ArrayList;

public class SevenSegmentDisplay {
    private ArrayList<String> listOfInput = new ArrayList<>();

    public void validateInputIsEightDigitsTest(String userInput) {
        if( userInput.length() != 8){
            throw new InvalidInputException("Input is invalid");
        }
    }
}
