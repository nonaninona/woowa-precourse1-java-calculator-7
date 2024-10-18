package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();
    private Adder adder = new Adder();

    public void add() throws IllegalArgumentException {
        userInterface.printResult(adder.add(userInterface.getNumbers()));
    }
}
