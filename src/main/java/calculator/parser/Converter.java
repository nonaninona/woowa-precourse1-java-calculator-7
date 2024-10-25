package calculator.parser;

import calculator.ErrorMessage;
import calculator.MyNumber;

public class Converter {
    public static MyNumber[] convertNumbers(String[] numbers) {
        MyNumber[] myNumbers = new MyNumber[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].contains("-"))
                    throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT.getMessage());
                myNumbers[i] = new MyNumber(numbers[i]);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LARGE_OR_CHARACTER_INPUT.getMessage());
        }
        return myNumbers;
    }
}
