package baseball.controller;

import baseball.model.BaseballJudge;
import baseball.model.BaseballService;
import baseball.view.ConsoleView;

import java.util.Objects;

public class BaseballGameController {
        private final ConsoleView consoleView;
        private final BaseballService baseballService;
        public BaseballGameController (ConsoleView consoleView) {
            this.consoleView = consoleView;
            this.baseballService = BaseballService.createService();
        }
        public void playBaseBall () {
            boolean restartFlg = true;
            while (restartFlg) {
                baseballService.resetAnswer();
                boolean endFlg = false;
                while (!endFlg) {
                    String inputStr = this.consoleView.getInput();
                    BaseballJudge.judgeNumberResult result = this.baseballService.jundgeNumber(inputStr);
                    consoleView.printResult(result.ball(), result.strike());
                    if (result.strike() == 3) endFlg = true;
                }
                restartFlg = Objects.equals(this.consoleView.endAskRestart(), "1");
            }

        }
}
