package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdderTest {

    @Test
    void 더하기() {
        //given
        MyNumber[] myNumbers = {new MyNumber(1), new MyNumber(5), new MyNumber(10)};

        //when
        MyNumber result = Adder.add(myNumbers);

        //then
        System.out.println(result.toInt());
    }

    @Test
    void 너무_큰_수_더하기() {
        //given
        MyNumber[] myNumbers = {new MyNumber(1000000000), new MyNumber(2000000000)};

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Adder.add(myNumbers));
    }
}
