import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestEvaluatorTest {

    @Test
    void amount1000NotUrgentMustBeApproved(){
        Request request = new Request(1000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();

        assertEquals(Decision.APPROVED, requestEvaluator.evaluate(request));
    }

    @Test
    void amount1000UrgentMustBeManualReview(){
        Request request = new Request(1000, true);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        Decision decision = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, decision);
    }

    @Test
    void amount5000MustRequireManualReview(){
        Request request = new Request(5000, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        Decision decision = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, decision);
    }

    @Test
    void amount5001MustBeRejected(){
        Request request = new Request(5001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        Decision decision = requestEvaluator.evaluate(request);

        assertEquals(Decision.REJECTED, decision);
    }

    @Test
    void amount1001NotUrgentMustRequireManualReview(){
        Request request = new Request(1001, false);
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        Decision decision = requestEvaluator.evaluate(request);

        assertEquals(Decision.MANUAL_REVIEW, decision);
    }
}
