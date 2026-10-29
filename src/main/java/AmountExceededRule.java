public class AmountExceededRule implements RequestRule{

    @Override
    public boolean appliesTo(Request request) {
        return request.getAmount() > 5000;
    }

    @Override
    public EvaluationResult resultFor(Request request) {
        return new EvaluationResult(Decision.REJECTED, ReasonCode.AMOUNT_LIMIT_EXCEEDED, "Amount exceeds 5000");
    }
}
