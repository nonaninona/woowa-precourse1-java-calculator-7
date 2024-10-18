package calculator;

public class Calculator {
    private UserInterface userInterface = new UserInterface();

    public int add() {
        InputSeqeunce inputSeqeunce = userInterface.getUserInput();
        MyNumber[] myNumbers = inputSeqeunce.getNumbers();
        MyNumber sum = new MyNumber(0);
        for (MyNumber myNumber : myNumbers) {
            sum.add(myNumber);
        }
        return sum.toInt();
    }
}
