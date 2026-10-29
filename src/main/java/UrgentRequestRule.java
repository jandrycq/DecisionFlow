public class UrgentRequestRule implements RequestRule{
    @Override
    public boolean appliesTo(Request request) {
        return request.getAmount() <= 5000 && request.isUrgent();
    }

    @Override
    public EvaluationResult resultFor(Request request) {
        return new EvaluationResult(Decision.MANUAL_REVIEW, ReasonCode.URGENT_REQUEST, "Urgent request requires manual review");
    }
}
