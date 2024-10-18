package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();
    private Adder adder = new Adder();

    public int add() {
        return adder.add(userInterface.getNumbers());
    }
}
