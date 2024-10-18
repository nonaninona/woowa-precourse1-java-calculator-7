package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public MyNumber[] getNumbers() {
        InputSequence inputSequence = new InputSequence(Console.readLine());
        return inputSequence.getNumbers();
    }

    public void printResult(MyNumber result) {
        System.out.println("결과 : " + result.toInt());
    }
}
