package calculator.parser.splitter;

import calculator.MyRegex;

public class DefaultSplitter implements Splitter {
    @Override
    public String[] splitNumbers(String input) {
        MyRegex regex = new MyRegex();
        String[] inputTokens = input.split(regex.getRegex());
        if (inputTokens.length == 1) {
            return new String[]{"0"};
        }
        return inputTokens;
    }
}
