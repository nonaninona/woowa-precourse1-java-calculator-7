package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

import calculator.parser.Converter;
import calculator.parser.splitter.CustomSplitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @Test
    void 숫자로변환하기() {
        //given
        String[] numbers1 = {"1", "3", "5"};
        String[] numbers2 = {"6", "1000"};

        //when
        MyNumber[] myNumbers1 = Converter.convertNumbers(numbers1);
        MyNumber[] myNumbers2 = Converter.convertNumbers(numbers2);

        //then
        for (MyNumber myNumber : myNumbers1) {
            System.out.println(myNumber.toInt());
        }
        for (MyNumber myNumber : myNumbers2) {
            System.out.println(myNumber.toInt());
        }
    }

    @Test
    void 문자가_섞여있을때_변환하기() {
        //given
        String[] numbers1 = {"1", "32ㅁ", "5"};
        String[] numbers2 = {"6", "1000k"};

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers2);
        });
    }

    @Test
    void 음수가_섞여있을때_변환하기() {
        //given
        String[] numbers1 = {"-1", "32", "5"};
        String[] numbers2 = {"6", "-1000"};

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers2);
        });
    }

    @Test
    void 너무_큰_수가_섞여있을때_변환하기() {
        //given
        String[] numbers1 = {"1000000000000", "32", "5"};
        String[] numbers2 = {"6", "-1000000000000"};

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertNumbers(numbers2);
        });
    }
}
