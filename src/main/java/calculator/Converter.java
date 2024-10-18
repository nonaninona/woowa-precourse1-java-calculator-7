package calculator;

public class Converter {
    public MyNumber[] convertNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.contains("-"))
                throw new IllegalArgumentException("잘못된 입력 : 음수");
        }

        MyNumber[] myNumbers = new MyNumber[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            myNumbers[i] = new MyNumber(numbers[i]);
        }
        return myNumbers;
    }
}
