import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RequestEvaluatorTest {

    @Test
    void amount1000NotUrgentMustBeApproved(){
        Request request = new Request(1000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.APPROVED, result.decision());
        assertEquals(ReasonCode.AUTOMATIC_APPROVAL, result.reasonCode());
        assertFalse(result.reason().isBlank());
    }

    @Test
    void amount1000UrgentMustBeManualReview(){
        Request request = new Request(1000, true);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
        assertEquals(ReasonCode.URGENT_REQUEST, result.reasonCode());
        assertFalse(result.reason().isBlank());
    }

    @Test
    void amount5000MustRequireManualReview(){
        Request request = new Request(5000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
        assertEquals(ReasonCode.AMOUNT_REQUIRES_REVIEW, result.reasonCode());
        assertFalse(result.reason().isBlank());
    }

    @Test
    void amount5001MustBeRejected(){
        Request request = new Request(5001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.REJECTED, result.decision());
        assertEquals(ReasonCode.AMOUNT_LIMIT_EXCEEDED, result.reasonCode());
        assertFalse(result.reason().isBlank());
    }

    @Test
    void amount1001NotUrgentMustRequireManualReview(){
        Request request = new Request(1001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
    }
}
