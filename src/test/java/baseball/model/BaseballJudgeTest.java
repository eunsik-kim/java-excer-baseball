package baseball.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class BaseballJudgeTest {
    private BaseballJudge baseballJudge;

    @Test
    void 스트라이크_테스트() {
        // Randoms.pickNumberInRange() 결과를 1,2,3으로 설정
        assertRandomNumberInRangeTest(() -> {
            baseballJudge = new BaseballJudge();
            baseballJudge.setupAnser();
            BaseballJudge.judgeNumberResult result =
                    baseballJudge.judgeNumber(Arrays.asList(1, 2, 3));

            assertThat(result.strike()).isEqualTo(3);
            assertThat(result.ball()).isEqualTo(0);
        }, 1, 2, 3);
    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(() -> {
            baseballJudge = new BaseballJudge();
            baseballJudge.setupAnser();
            BaseballJudge.judgeNumberResult result =
                    baseballJudge.judgeNumber(Arrays.asList(3, 1, 2));

            assertThat(result.strike()).isEqualTo(0);
            assertThat(result.ball()).isEqualTo(3);
        }, 1, 2, 3);
    }

    @Test
    void 볼_스트라이크_혼합_테스트() {
        assertRandomNumberInRangeTest(() -> {
            baseballJudge = new BaseballJudge();
            baseballJudge.setupAnser();
            BaseballJudge.judgeNumberResult result =
                    baseballJudge.judgeNumber(Arrays.asList(1, 3, 2));

            assertThat(result.strike()).isEqualTo(1);
            assertThat(result.ball()).isEqualTo(2);
        }, 1, 2, 3);
    }
}