package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private UserInterface() {
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    public static void printResult(MyNumber result) {
        System.out.println("결과 : " + result.toInt());
    }
}
