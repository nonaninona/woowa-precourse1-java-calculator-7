package calculator.parser.splitter;

public enum CustomSplitRegex {
    START("//"),
    END("\\n");

    private final String value;

    CustomSplitRegex(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
