package calculator;

public class CustomSplitter implements Splitter {
    @Override
    public String[] splitNumbers(String input) {
        String[] inputTokens = input.split("\\\\n");
        String customRegex = inputTokens[0].replace("//", "");
        MyRegex regex = new MyRegex(customRegex);
        if (inputTokens.length == 1) {
            return "0".split(regex.getRegex());
        }
        return inputTokens[1].split(regex.getRegex());
    }
}
