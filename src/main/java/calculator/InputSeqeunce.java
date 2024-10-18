package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputSeqeunce {
    private String input;

    public InputSeqeunce(String input) {
        this.input = input;
    }

    public MyNumber[] getNumbers() {
        MyRegex myRegex = splitRegex(input);
        return splitNumbers(input, myRegex);
    }

    private MyRegex splitRegex(String input) {
        System.out.println(input);
        if(input.contains(":") && input.contains(","))
            return new MyRegex(":|,");
        else if(input.contains(":"))
            return new MyRegex(":");
        else if(input.contains(","))
            return new MyRegex(",");
        return null;
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
