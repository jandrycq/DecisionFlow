public class RequestEvaluator {

    public Decision evaluate(Request  request){
        if (request.getAmount() <= 1000 && !request.isUrgent()){
            return Decision.APPROVED;
        } else if (request.getAmount() <= 5000) {
            return Decision.MANUAL_REVIEW;
        } else {
            return Decision.REJECTED;
        }
    }
}
