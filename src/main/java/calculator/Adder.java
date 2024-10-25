package calculator;

public class Adder {
    private Adder() {
    }

    public static MyNumber add(MyNumber[] myNumbers) {
        MyNumber sum = new MyNumber(0);
        try {
            for (MyNumber myNumber : myNumbers) {
                sum.add(myNumber);
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LARGE_OUTPUT.getMessage());
        }
        return sum;
    }
}
