import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestEvaluatorTest {

    @Test
    void amount1000NotUrgentMustBeApproved(){
        Request request = new Request(1000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.APPROVED, result.decision());
        assertEquals("Amount is at most 1000 and is not urgent", result.reason());
    }

    @Test
    void amount1000UrgentMustBeManualReview(){
        Request request = new Request(1000, true);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
    }

    @Test
    void amount5000MustRequireManualReview(){
        Request request = new Request(5000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
        assertEquals("Request does not meet automatic approval criteria and amount is at most 5000", result.reason());
    }

    @Test
    void amount5001MustBeRejected(){
        Request request = new Request(5001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.REJECTED, result.decision());
        assertEquals("Amount exceeds 5000", result.reason());
    }

    @Test
    void amount1001NotUrgentMustRequireManualReview(){
        Request request = new Request(1001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        EvaluationResult result = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, result.decision());
    }
}
