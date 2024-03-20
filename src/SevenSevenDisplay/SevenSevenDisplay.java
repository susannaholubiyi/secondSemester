package SevenSevenDisplay;

import java.util.Scanner;

public class SevenSevenDisplay {

    public String display(String number){
        if (number.equals("11111101")) return displayZero();
        if (number.equals("01100001")) return displayOne();
        if (number.equals("11011011")) return displayTwo();
        if (number.equals("11110011")) return displayThree();
        if (number.equals("01100111")) return displayFour();
        if (number.equals("10110111")) return displayFive();
        if (number.equals("10111111")) return displaySix();
        if (number.equals("11100001")) return displaySeven();
        if (number.equals("11111111")) return displayEight();
        if (number.equals("11100111")) return displayNine();
        return "";

    }
    public String displayZero() {
        String zeroOutput = ("""
                    # # # #
                    #     #
                    #     #
                    #     #
                    # # # #
                    """);
        return zeroOutput;
    }
    public String displayOne() {
        String oneOutput = ("""
                          #
                          #
                          #
                          #
                          #
                    """);
        return oneOutput;
    }
    public String displayTwo() {
        String twoOutput =  ("""
                    # # # #
                          #
                    # # # #
                    #
                    # # # #
                    """);
        return twoOutput;
    }
    public String displayThree() {
        String threeOutput =  ("""
                    # # # #
                          #
                    # # # #
                          #
                    # # # #
                    """);
        return threeOutput;
    }
    public String displayFour() {
        String fourOutput =  ("""
                    #     #
                    #     #
                    # # # #
                          #
                          #
                    """);
        return fourOutput;
    }
    public String displayFive() {
        String fiveOutput =  ("""
                    # # # #
                    #         
                    # # # #
                          #
                    # # # #
                    """);
        return fiveOutput;
    }
    public String displaySix() {
        String sixOutput =  ("""
                    # # # #
                    #         
                    # # # #
                    #     #
                    # # # #
                    """);
        return sixOutput;
    }
    public String displaySeven() {
        String sevenOutput =  ("""
                    # # # #
                          #
                          #
                          #
                          #
                    """);
        return sevenOutput;
    }
    public String displayEight() {
        String eightOutput =  ("""
                    # # # #
                    #     #
                    # # # #
                    #     #
                    # # # #
                    """);
        return eightOutput;
    }
    public String displayNine() {
        String nineOutput =  ("""
                    # # # #
                    #     #
                    # # # #
                          #
                          #
                    """);
        return nineOutput;
    }
    private static String input(String prompt){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    private static void print(String message){
        System.out.println(message);
    }
}
