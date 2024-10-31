package baseball.model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballJudge {
    private List<Integer> answer;
    public void setupAnwser () {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.answer = computer;
    }

    public judgeNumberResult judgeNumber(List<Integer> Numbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < Numbers.size(); i++) {
            int position = checkBallPosition(Numbers.get(i));
            if (i == position) {
                strike++;
            } else if (position != -1) {
                ball++;
            }
        }
        return new judgeNumberResult(ball, strike);
    }

    private int checkBallPosition(Integer number) {
        return this.answer.indexOf(number);
    }

    public record judgeNumberResult(Integer ball, Integer strike) { }
}
