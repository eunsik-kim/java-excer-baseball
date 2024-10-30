package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleViewTest {
    private ByteArrayOutputStream outputStream;
    private ConsoleView consoleView;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        consoleView = new ConsoleView();
    }

    private void setInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void 게임_시작_메시지_출력() {
        assertThat(outputStream.toString().trim())
                .isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 입력_메시지_출력() {
        setInput("123");
        assertThat(consoleView.getInput()).isEqualTo("123");
        assertThat(outputStream.toString())
                .contains("숫자를 입력해주세요 : ");
    }

    @Test
    void 게임_종료_메시지_출력() {
        setInput("1");
        assertThat(consoleView.endAskRestart()).isEqualTo("1");
        assertThat(outputStream.toString())
                .contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}