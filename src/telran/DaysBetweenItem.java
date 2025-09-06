package telran;

import view.InputOutput;
import view.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaysBetweenItem implements Item {

    InputOutput inOut;
    String format = "dd.MM.yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);


    public DaysBetweenItem(InputOutput inOut) {
        this.inOut = inOut;
    }

    @Override
    public String displayName() {
        return "DaysBetweenItem";
    }

    @Override
    public void perform() {
        LocalDate date1 = inOut.inputDate("Enter first date",format);
        LocalDate date2 = inOut.inputDate("Enter second date", format);

        long result = daysBetween(date1, date2);

        inOut.outputLine("\u001B[32mdays between dates:\u001B[0m " + result);






    }
    private long daysBetween(LocalDate date1, LocalDate date2){
        return ChronoUnit.DAYS.between(date1,date2);
    }
}
