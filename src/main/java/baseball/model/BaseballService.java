package baseball.model;

public class BaseballService {
    private final BaseballJudge baseballJudge;
    private final BaseballPreprocessor baseballPreprocessor;
    private BaseballService(BaseballJudge baseballJudge, BaseballPreprocessor baseballPreprocessor) {
        this.baseballJudge = baseballJudge;
        this.baseballPreprocessor = baseballPreprocessor;
    }

    public static BaseballService createService(){
        return new BaseballService(new BaseballJudge(), new BaseballPreprocessor());
    }

    public BaseballJudge.judgeNumberResult jundgeNumber (String numbers) {
        return baseballJudge.judgeNumber(this.baseballPreprocessor.preprocessInput(numbers));
    }

    public void resetAnswer () {
        baseballJudge.setupAnser();
    }
}
