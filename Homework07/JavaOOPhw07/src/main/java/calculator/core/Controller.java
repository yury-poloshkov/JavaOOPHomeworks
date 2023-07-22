package calculator.core;

import calculator.core.operations.Operation;
import java.util.List;

public class Controller {
    private final List<Operation> functions;

    public Controller(List<Operation> calcFunctions) {
        this.functions = calcFunctions;
    }

    public String calculate(List<String> numbers, String operation) {
        String result = "Error: Invalid operation";
        try {
            for (Operation op: functions) {
                if (operation.equals(op.getOperation())) {
                    result = op.calculate(numbers);
                }
            }
        } catch (NumberFormatException e) {
            result = "Invalid data";
        }
        return result;
    }
}
