package calculator;

public class CustomSplitter implements Splitter{
    @Override
    public String[] splitNumbers(String input) {
        String[] inputTokens = input.split("\\\\n");
        String customRegex = inputTokens[0].replace("//", "");
        MyRegex regex = new MyRegex(customRegex);
        return inputTokens[1].split(regex.getRegex());
    }
}
