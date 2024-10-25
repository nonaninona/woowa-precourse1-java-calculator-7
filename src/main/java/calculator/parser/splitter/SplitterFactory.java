package calculator.parser.splitter;

import java.util.regex.Pattern;

public class SplitterFactory {

    private SplitterFactory() {}

    public static Splitter getSplitter(String input) {
        if (checkCustomPattern(input)) {
            return new CustomSplitter();
        }
        return new DefaultSplitter();
    }

    private static boolean checkCustomPattern(String input) {
        String regex = Pattern.quote(CustomSplitRegex.START.getValue())
                + ".*"
                + Pattern.quote(CustomSplitRegex.END.getValue())
                + ".*";
        return Pattern.matches(regex, input);
    }
}
