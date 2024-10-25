package calculator.parser.splitter;

import calculator.MyRegex;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {
    @Override
    public String[] splitNumbers(String input) {
        String[] inputTokens = input.split(Pattern.quote(CustomSplitRegex.END.getValue()));
        String customRegex = inputTokens[0].replace(CustomSplitRegex.START.getValue(), "");
        MyRegex regex = new MyRegex(customRegex);
        if (inputTokens.length == 1) {
            return new String[]{"0"};
        }
        return inputTokens[1].split(regex.getRegex());
    }
}
