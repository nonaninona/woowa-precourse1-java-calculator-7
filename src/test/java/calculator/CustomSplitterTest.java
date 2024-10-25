package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.parser.splitter.CustomSplitter;
import calculator.parser.splitter.DefaultSplitter;
import calculator.parser.splitter.Splitter;
import calculator.parser.splitter.SplitterFactory;
import org.junit.jupiter.api.Test;

public class CustomSplitterTest {
    @Test
    void 커스텀_구분자_존재_시_스플릿() {
        //given
        CustomSplitter customSplitter = new CustomSplitter();
        String input1 = "//;;;\\n1;;;3";
        String input2 = "//;;;\\n1;;;3";

        //when
        String[] result1 = customSplitter.splitNumbers(input1);
        String[] result2 = customSplitter.splitNumbers(input2);

        //then
        for (String s : result1) {
            System.out.println(s);
        }
        for (String s : result2) {
            System.out.println(s);
        }
//        assertThat(result1).isInstanceOf(CustomSplitter.class);
//        assertThat(result2).isInstanceOf(CustomSplitter.class);
    }

    @Test
    void 커스텀_구분자_미존재_시_DefaultSplitter_생성() {
        //given
        String input1 = "//;;;1;;;3";
        String input2 = "1,3";

        //when
        Splitter splitter1 = SplitterFactory.getSplitter(input1);
        Splitter splitter2 = SplitterFactory.getSplitter(input2);

        //then
        assertThat(splitter1).isInstanceOf(DefaultSplitter.class);
        assertThat(splitter2).isInstanceOf(DefaultSplitter.class);
    }
}
