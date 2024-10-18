package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();
    private Adder adder = new Adder();

    public void add() throws IllegalArgumentException {
        int ret = adder.add(userInterface.getNumbers());
        userInterface.print("결과 : " + ret);
    }
}
