public class RequestEvaluator {

    public EvaluationResult evaluate(Request  request){
        if (request.getAmount() <= 1000 && !request.isUrgent()){
            return new EvaluationResult(Decision.APPROVED, "Amount is at most 1000 and is not urgent");
        } else if (request.getAmount() <= 5000) {
            return new EvaluationResult(Decision.MANUAL_REVIEW, "Request does not meet automatic" +
                    " approval criteria and amount is at most 5000");
        } else {
            return new EvaluationResult(Decision.REJECTED, "Amount exceeds 5000");
        }
    }
}
