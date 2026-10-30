package dev.decisionflow.core;

public record EvaluationResult(
        Decision decision,
        ReasonCode reasonCode,
        String reason
) {

}
    