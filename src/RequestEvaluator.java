public class RequestEvaluator {

    public EvaluationResult evaluate(Request  request){
        if (request.getAmount() <= 1000 && !request.isUrgent()){
            return new EvaluationResult(Decision.APPROVED, ReasonCode.AUTOMATIC_APPROVAL, "Amount is at most 1000 and is not urgent");
        } else if (request.getAmount() <= 5000 && request.isUrgent()) {
            return new EvaluationResult(Decision.MANUAL_REVIEW, ReasonCode.URGENT_REQUEST, "Urgent request requires manual review");
        } else if (request.getAmount() <= 5000) {
            return new EvaluationResult(Decision.MANUAL_REVIEW, ReasonCode.AMOUNT_REQUIRES_REVIEW, "Request does not meet automatic" + " approval criteria and amount is at most 5000");
        } else {
            return new EvaluationResult(Decision.REJECTED, ReasonCode.AMOUNT_LIMIT_EXCEEDED, "Amount exceeds 5000");
        }
    }
}
