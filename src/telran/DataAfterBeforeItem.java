package telran;

import view.InputOutput;
import view.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataAfterBeforeItem implements Item {
    InputOutput inOut;
    String format = "dd.MM.yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

    public DataAfterBeforeItem(InputOutput inOut) {
        this.inOut = inOut;

    }




    @Override
    public String displayName() {
        return "DataAfterBefore";
    }

    @Override
    public void perform() {
        LocalDate date  = inOut.inputDate("Enter date", format);
        Integer days = inOut.inputInteger("Enter amount of days", 0, Integer.MAX_VALUE);
        String beforeAfter = inOut.inputString("Enter BEFORE of AFTER", List.of("before", "after"));

        LocalDate result = daysBeforeAfter(date, days, beforeAfter);


        inOut.outputLine("\u001B[32mresulting date:\u001B[0m " + result.format(formatter));




    }

    private LocalDate daysBeforeAfter(LocalDate date, Integer days, String beforeAfter){
        if( "after".equalsIgnoreCase(beforeAfter))
            return date.plusDays(days);
        return date.minusDays(days);

    }
}
