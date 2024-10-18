package calculator;

public class MyRegex {
    private String regex = ",|:";

    public MyRegex() {

    }

    public MyRegex(String customRegex) {
        this.regex += "|" + customRegex;
    }

    public String getRegex() {
        return regex;
    }
}
