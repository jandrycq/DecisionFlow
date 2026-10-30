package dev.decisionflow.api;

import dev.decisionflow.core.EvaluationResult;
import dev.decisionflow.core.Request;
import dev.decisionflow.core.RequestEvaluator;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/evaluations")
public class EvaluationController {
    private final RequestEvaluator requestEvaluator;

    public EvaluationController(RequestEvaluator requestEvaluator){
        this.requestEvaluator = requestEvaluator;
    }

    @PostMapping
    public EvaluationResponse evaluate(@Valid @RequestBody EvaluationRequest input){
        Request request = new Request(input.amount(), input.urgent());
        EvaluationResult result = requestEvaluator.evaluate(request);

        return new EvaluationResponse(result.decision().name(), result.reasonCode().name(), result.reason());
    }
}
