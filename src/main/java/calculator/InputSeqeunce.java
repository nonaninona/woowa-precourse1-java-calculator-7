package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputSeqeunce {
    private String input;

    public InputSeqeunce(String input) {
        this.input = input;
    }

    public MyNumber[] getNumbers() {
        MyRegex myRegex = new MyRegex();
        return splitNumbers(input, myRegex);
    }

    //MyRegex가 굳이 class로 있어야 하나? 있다면 좀 더 우아한 방법 없나? => 메소드 삭제, 기본 덧셈 기능에서는 다양한 regex 고려할 필요 없음
    private MyNumber[] splitNumbers(String input, MyRegex regex) {
        String[] numbers = input.split(regex.getRegex());
        MyNumber[] myNumbers = new MyNumber[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            myNumbers[i] = new MyNumber(numbers[i]);
        }
        return myNumbers;
    }
}
