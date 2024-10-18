package calculator;

public class Adder {
    public static MyNumber add(MyNumber[] myNumbers) {
        MyNumber sum = new MyNumber(0);
        for (MyNumber myNumber : myNumbers) {
            sum.add(myNumber);
        }
        return sum;
    }
}
