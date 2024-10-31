package baseball.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballValidator {
    public void validateInput (List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요. 입력 : " +  parsedNumbers.toString());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(parsedNumbers);
        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException("서로다른 3개의 숫자를 입력해 주세요. 입력 : " +  parsedNumbers.toString());
        }
        if (parsedNumbers.stream().anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException("양의 정수를 입력해 주세요. 입력 : " +  parsedNumbers.toString());
        }
    }
}
