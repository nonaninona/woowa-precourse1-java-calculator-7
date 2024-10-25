package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.parser.splitter.CustomSplitter;
import calculator.parser.splitter.DefaultSplitter;
import calculator.parser.splitter.Splitter;
import calculator.parser.splitter.SplitterFactory;
import org.junit.jupiter.api.Test;

public class CustomSplitterTest {
    @Test
    void 숫자구분하기() {
        //given
        CustomSplitter customSplitter = new CustomSplitter();
        String input1 = "//;;;\\n1;;;3";
        String input2 = "//as\\n1as3";

        //when
        String[] result1 = customSplitter.splitNumbers(input1);
        String[] result2 = customSplitter.splitNumbers(input2);

        //then
        assertThat(result1[0]).isEqualTo("1");
        assertThat(result1[1]).isEqualTo("3");
        assertThat(result2[0]).isEqualTo("1");
        assertThat(result2[1]).isEqualTo("3");
    }

    @Test
    void 숫자가_없을때_숫자구분하기() {
        //given
        CustomSplitter customSplitter = new CustomSplitter();
        String input = "//;;;\n";

        //when
        String[] result = customSplitter.splitNumbers(input);

        //then
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("0");
    }
}
