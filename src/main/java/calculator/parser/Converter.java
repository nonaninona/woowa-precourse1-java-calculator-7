package calculator.parser;

import calculator.MyNumber;

public class Converter {
    public static MyNumber[] convertNumbers(String[] numbers) {
        MyNumber[] myNumbers = new MyNumber[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].contains("-"))
                    throw new IllegalArgumentException("잘못된 입력 : 음수");
                myNumbers[i] = new MyNumber(numbers[i]);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 : 너무 큰 수 또는 문자가 포함된 수");
        }
        return myNumbers;
    }
}
