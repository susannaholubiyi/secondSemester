package ageGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeGeneratorTest {
    @Test
    public void functionCollectsDOB_returnsAgeTest(){
        AgeGenerator ageGenerator = new AgeGenerator();
        Assertions.assertEquals(1,ageGenerator.dateOfBirthConverter("22/12/2022"));
    }

}
