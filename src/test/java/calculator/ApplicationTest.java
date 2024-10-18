package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용_숫자_1개() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용_구분자_섞어서_사용() {
        assertSimpleTest(() -> {
            run("1,3:4,6");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Test
    void 커스텀_구분자_사용_숫자_없음() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_긴커스텀구분자() {
        assertSimpleTest(() -> {
            run("//;;;\\n1;;;3");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 커스텀_구분자_사용_구분자_섞어서_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;3,5:5;3");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수1개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_음수1개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\n-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//p\nabcdef"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_너무큰숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9999999999999999999,9999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_너무큰숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\n9999999999999999999,9999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
