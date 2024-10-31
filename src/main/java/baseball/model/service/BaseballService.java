package baseball.model.service;

import java.util.List;

public class BaseballService {
    private final BaseballJudge baseballJudge;
    private final BaseballParser baseballParser;
    private final BaseballValidator baseballValidator;
    private BaseballService(BaseballJudge baseballJudge, BaseballParser baseballParser, BaseballValidator baseballValidator) {
        this.baseballJudge = baseballJudge;
        this.baseballParser = baseballParser;
        this.baseballValidator = baseballValidator;
    }

    public static BaseballService createService(){
        return new BaseballService(new BaseballJudge(), new BaseballParser(), new BaseballValidator());
    }

    public BaseballJudge.judgeNumberResult jundgeNumber (String numbers) {
        List<Integer> parsedNumbers = this.baseballParser.parseInput(numbers);
        this.baseballValidator.validateInput(parsedNumbers);
        return baseballJudge.judgeNumber(parsedNumbers);
    }

    public void resetAnswer () {
        baseballJudge.setupAnwser();
    }
}
