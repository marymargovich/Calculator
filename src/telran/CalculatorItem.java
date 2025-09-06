package telran;

import view.InputOutput;
import view.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class CalculatorItem implements Item {

    InputOutput inOut;

    static Map<String, BinaryOperator<Integer>> mapOperation;
    {
        mapOperation = new HashMap<>();
        mapOperation.put("+", (x, y)->x+y);
        mapOperation.put("*", (x, y)->x*y);
        mapOperation.put("-", (x, y)->x-y);
        mapOperation.put("/", (x, y)->{
            if(y==0) throw new ArithmeticException("Devision by zero");
            return x/y;
        });
    }

    public CalculatorItem(InputOutput inOut) {
        this.inOut = inOut;
    }



    @Override
    public String displayName() {
        return "Integer calculator";
    }

    @Override
    public void perform() {
        Integer operand1 = inOut.inputInteger("Enter first number");
        if( operand1 == null)
            return;;
        Integer operand2 = inOut.inputInteger("Enter first number");
        if(operand2 == null)
            return;
        String operator = inOut.inputString("Enter operator from ",
                new ArrayList<>(mapOperation.keySet()));
        inOut.outputLine(mapOperation.get(operator).apply(operand1,operand2));





    }

}
