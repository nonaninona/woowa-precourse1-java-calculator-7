package calculator.parser;

import calculator.MyNumber;
import calculator.parser.splitter.Splitter;
import calculator.parser.splitter.SplitterFactory;

public class Parser {

    public static MyNumber[] getNumbers(String input) {
        Splitter splitter = SplitterFactory.getSplitter(input);
        String[] numbers = splitter.splitNumbers(input);
        return Converter.convertNumbers(numbers);
    }
}
