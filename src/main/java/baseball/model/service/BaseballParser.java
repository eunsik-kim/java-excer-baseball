package baseball.model.service;

import java.util.Arrays;
import java.util.List;

public class BaseballParser {
    public List<Integer> parseInput (String inputStr) {
        try {
            return Arrays.stream(inputStr.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 숫자들이 정수가 아닙니다. 입력 : " +  inputStr);
        }
    }
}
