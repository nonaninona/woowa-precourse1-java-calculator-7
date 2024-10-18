package calculator;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public InputSeqeunce getUserInput() {
        return new InputSeqeunce(Console.readLine());
    }
}
