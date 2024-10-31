package baseball.exception;

public class NotNumberException extends InvalidInputException {
    public NotNumberException(String inputStr) {
        super("입력한 숫자들이 정수가 아닙니다.", inputStr);
    }
}
