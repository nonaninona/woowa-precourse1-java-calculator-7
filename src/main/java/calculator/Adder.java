package calculator;

public class Adder {
    public static MyNumber add(MyNumber[] myNumbers) {
        MyNumber sum = new MyNumber(0);
        try {
            for (MyNumber myNumber : myNumbers) {
                sum.add(myNumber);
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("수의 합이 너무 큽니다.");
        }
        return sum;
    }
}
