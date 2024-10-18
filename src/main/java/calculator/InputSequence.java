package calculator;

public class InputSequence {
    private String input;

    public InputSequence(String input) {
        this.input = input;
    }

    public MyNumber[] getNumbers() {
        MyRegex myRegex = decideRegex();
        if(hasCustomRegex())
            removeCustomRegexStatement();
        return splitNumbers(input, myRegex);
    }

    private boolean hasCustomRegex() {
        return input.contains("//") && input.contains("\\n");
    }

    private MyRegex decideRegex() {
        if(hasCustomRegex()) {
            String[] inputTokens = input.split("\\\\n");
            String customRegex = inputTokens[0].replace("//", "");
            return new MyRegex(customRegex);
        }
        return new MyRegex();
    }

    private void removeCustomRegexStatement() {
        String[] inputTokens = input.split("\\\\n");
        input = inputTokens[1];
    }

    private MyNumber[] splitNumbers(String input, MyRegex regex) {
        String[] numbers = input.split(regex.getRegex());
        MyNumber[] myNumbers = new MyNumber[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            myNumbers[i] = new MyNumber(numbers[i]);
        }
        return myNumbers;
    }
}
