package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public MyNumber[] getNumbers() {
        InputSeqeunce inputSeqeunce = new InputSeqeunce(Console.readLine());
        return inputSeqeunce.getNumbers();
    }
}
