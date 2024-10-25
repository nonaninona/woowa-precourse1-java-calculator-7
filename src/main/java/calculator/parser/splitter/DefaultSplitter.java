package calculator.parser.splitter;

import calculator.MyRegex;

public class DefaultSplitter implements Splitter {
    public String[] splitNumbers(String input) {
        MyRegex regex = new MyRegex();
        return input.split(regex.getRegex());
    }
}
