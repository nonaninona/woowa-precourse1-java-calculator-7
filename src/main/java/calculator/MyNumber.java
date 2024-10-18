package calculator;

public class MyNumber {
    private int value;

    public MyNumber(int value) {
        this.value = value;
    }

    public MyNumber(String value) {
        this.value = Integer.parseInt(value);
    }

    public void add(MyNumber target) {
        this.value += target.toInt();
    }

    public int toInt() {
        return value;
    }
}
