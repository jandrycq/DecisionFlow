package dev.decisionflow.api;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EvaluationRequest (
        @NotNull
        @PositiveOrZero
        Double amount,
        @NotNull
        Boolean urgent
){

}
