package calculator;

public class Calculator {
    public void add() throws IllegalArgumentException {
        String input = UserInterface.getUserInput();
        MyNumber result = Adder.add(Parser.getNumbers(input));
        UserInterface.printResult(result);
    }
}
