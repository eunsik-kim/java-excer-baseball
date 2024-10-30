package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.text.Format;

public class ConsoleView {
    private static final String START_INPUT_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String BALL_STRING = "볼";
    private static final String END_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public ConsoleView() {
        System.out.println(START_INPUT_STRING);
    }
    public String getInput() {
        System.out.print(INPUT_STRING);
        return Console.readLine();
    }
    public void printResult(int ball, int strike) {
        String strikeString = String.format("%s%d", STRIKE_STRING, strike);
        String ballString = String.format("%s%d", BALL_STRING, ball);

        if (ball > 0 && strike > 0) {
            System.out.printf("%s %s\n", ballString, strikeString);
        } else if (ball > 0) {
            System.out.println(ballString);
        } else if (strike > 0) {
            System.out.println(strikeString);
        } else {
            System.out.println("낫싱");
        }
    }
    public String endAskRestart() {
        System.out.println(END_STRING);
        System.out.println(RESTART_STRING);
        return Console.readLine();
    }
}
