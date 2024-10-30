package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    @DisplayName("서로 다른 3가지 양의 숫자만 포함되어야 한다")
    class ExceptionTest {
        @ParameterizedTest
        @ValueSource(strings = {
                "1234",
                "12",
        })
        void 입력길이_테스트(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> run(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
        @ParameterizedTest
        @ValueSource(strings = {
                "111",
        })
        void 중복_숫자_테스트(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> run(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
        @ParameterizedTest
        @ValueSource(strings = {
                "12.",
                "1 3"
        })
        void 기호입력_테스트(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> run(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }


    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
