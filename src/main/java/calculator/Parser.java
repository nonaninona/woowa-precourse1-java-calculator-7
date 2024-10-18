package calculator;

public class Parser {
    private Splitter splitter;
    private Converter converter = new Converter();

    public MyNumber[] getNumbers(String input) {
        splitter = SplitterFactory.getSplitter(input);
        String[] numbers = splitter.splitNumbers(input);
        return converter.convertNumbers(numbers);
    }
}
