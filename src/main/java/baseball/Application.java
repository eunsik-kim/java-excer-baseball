package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        BaseballGameController controller = new BaseballGameController(new ConsoleView());
        controller.playBaseBall();
    }
}
