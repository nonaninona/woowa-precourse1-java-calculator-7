package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();
    private Adder adder = new Adder();
    private Parser parser = new Parser();

    public void add() throws IllegalArgumentException {
        String input = userInterface.getUserInput();
        MyNumber result = adder.add(parser.getNumbers(input));
        userInterface.printResult(result);
    }
}
