package ageGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeGenerator {

    public int dateOfBirthConverter(String dateOfBirth) {
        LocalDate birthday = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday,currentDate);

        return period.getYears();
    }
}
