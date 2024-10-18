package calculator;

public class SplitterFactory {
    public static Splitter getSplitter(String input) {
        if (input.contains("//") && input.contains("\\n")) {
            return new CustomSplitter();
        }
        return new DefaultSplitter();
    }
}
