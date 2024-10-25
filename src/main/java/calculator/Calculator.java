package calculator;

import calculator.parser.Parser;

public class Calculator {
    public void add() {
        String input = UserInterface.getUserInput();
        MyNumber result = Adder.add(Parser.getNumbers(input));
        UserInterface.printResult(result);
    }
}
