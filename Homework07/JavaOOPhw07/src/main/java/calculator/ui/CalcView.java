package calculator.ui;

import calculator.core.Controller;
import calculator.core.operations.Operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class CalcView {
    private final List<Operation> functions;
    private final List<String> numbers;
    private String operation;

    private final Controller controller;

    public CalcView(List<Operation> calcFunctions) {
        this.numbers = new ArrayList<>();
        this.operation = null;
        this.functions = calcFunctions;
        this.controller = new Controller(functions);
    }

    public void run(){
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(CalcView.class.getName());
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO,"Application launched");
        do {
            inputExpression();
            logger.info("User input: " + numbers + ", operation: " + operation);
            if (!numbers.isEmpty() && !operation.isEmpty()){
                System.out.println("------------------------------------------------------");
                String result = controller.calculate(numbers, operation);
                result = result.contains("NaN") ? "Error: division by zero" : result;
                System.out.println("Результат: " + result);
                logger.info("Calculation result: " + result);
                timeOut();
            }
        } while (!operation.isEmpty());
        logger.info("Application closed");
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
