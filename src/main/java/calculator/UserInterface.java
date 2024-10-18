package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public String getUserInput() {
        return Console.readLine();
    }

    public void printResult(MyNumber result) {
        System.out.println("결과 : " + result.toInt());
    }
}
