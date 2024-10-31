package baseball.exception;

public class InvalidInputException extends BaseballException{
    public InvalidInputException(String message) {
        super(message);
    }
    public InvalidInputException(String message, String inputStr) {
        super(message + "입력 : " + inputStr);
    }
}
