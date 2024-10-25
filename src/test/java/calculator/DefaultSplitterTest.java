package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.parser.splitter.DefaultSplitter;
import org.junit.jupiter.api.Test;

public class DefaultSplitterTest {
    @Test
    void 숫자구분하기() {
        //given
        DefaultSplitter defaultSplitter = new DefaultSplitter();
        String input1 = "1,3:5";
        String input2 = "1:3,5";

        //when
        String[] result1 = defaultSplitter.splitNumbers(input1);
        String[] result2 = defaultSplitter.splitNumbers(input2);

        //then
        assertThat(result1[0]).isEqualTo("1");
        assertThat(result1[1]).isEqualTo("3");
        assertThat(result1[2]).isEqualTo("5");
        assertThat(result2[0]).isEqualTo("1");
        assertThat(result2[1]).isEqualTo("3");
        assertThat(result2[2]).isEqualTo("5");
    }

    @Test
    void 숫자가_없을때_숫자구분하기() {
        //given
        DefaultSplitter defaultSplitter = new DefaultSplitter();
        String input = "";

        //when
        String[] result = defaultSplitter.splitNumbers(input);

        //then
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("0");
    }
}
