package baseball.model.service;

import baseball.exception.NotNumberException;

import java.util.Arrays;
import java.util.List;

public class BaseballParser {
    public List<Integer> parseInput (String inputStr) {
        try {
            return Arrays.stream(inputStr.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new NotNumberException(inputStr);
        }
    }
}
