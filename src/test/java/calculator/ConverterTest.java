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
        assertThat(myNumbers1[0].toInt()).isEqualTo(1);
        assertThat(myNumbers1[1].toInt()).isEqualTo(3);
        assertThat(myNumbers1[2].toInt()).isEqualTo(5);
        assertThat(myNumbers2[0].toInt()).isEqualTo(6);
        assertThat(myNumbers2[1].toInt()).isEqualTo(1000);
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
