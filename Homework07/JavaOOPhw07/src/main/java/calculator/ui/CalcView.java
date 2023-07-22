package calculator.ui;

import calculator.core.Controller;
import calculator.core.operations.Operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class CalcView {
    private List<Operation> functions;
    private List<String> numbers;
    private String operation;

    private Controller controller;

    public CalcView(List<Operation> calcFunctions) {
        this.numbers = new ArrayList<>();
        this.operation = null;
        this.controller = new Controller(calcFunctions);
    }

    public void run(){
//        Logger logger = new Logger();
//        logger.addHandler(new FileHandler("log.txt"));
        do {
            inputExpression();
            if (!numbers.isEmpty() && !operation.isEmpty()){
                System.out.println("------------------------------------------------------");
                String result = controller.calculate(numbers, operation);
                result = result.contains("NaN") ? "Error: division by zero" : result;
                System.out.println("Результат: " + result);
                timeOut();
            }
        } while (!operation.isEmpty());
    }

    private void inputExpression() {
        numbers.clear();
        System.out.print("\033[H\033[J");
        System.out.println("----- Калькулятор комплексных чисел v.2023.07.20 -----");
        System.out.println("            (press ENTER thrice to exit)");
        numbers.add(prompt("Введите 1-е комплексное число формата a + b*i: ").toLowerCase());
        operation = prompt("Введите операцию: ");
        numbers.add(prompt("Введите 2-е комплексное число формата a + b*i: ").toLowerCase());
    }
    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void timeOut() {
        System.out.println("Press ENTER to continue");
        Scanner stopScn = new Scanner(System.in);
        stopScn.nextLine();
    }
}
