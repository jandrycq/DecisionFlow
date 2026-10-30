package dev.decisionflow.core;

public class AmountReviewRule implements RequestRule{

    @Override
    public boolean appliesTo(Request request) {
        return request.getAmount() <= 5000 && !request.isUrgent();
    }

    @Override
    public EvaluationResult resultFor(Request request) {
        return new EvaluationResult(Decision.MANUAL_REVIEW, ReasonCode.AMOUNT_REQUIRES_REVIEW,
                "Request does not meet automatic approval criteria and amount is at most 5000");
    }
}
