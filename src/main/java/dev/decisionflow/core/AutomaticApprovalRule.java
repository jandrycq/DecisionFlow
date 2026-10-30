package dev.decisionflow.core;

public class AutomaticApprovalRule implements RequestRule{

    @Override
    public boolean appliesTo(Request request) {
        return request.getAmount() <= 1000 && !request.isUrgent();
    }

    @Override
    public EvaluationResult resultFor(Request request) {
        return new EvaluationResult(Decision.APPROVED, ReasonCode.AUTOMATIC_APPROVAL, "Amount is at most 1000 and is not urgent");
    }
}
