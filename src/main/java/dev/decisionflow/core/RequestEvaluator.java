package dev.decisionflow.core;

import java.util.ArrayList;
import java.util.List;

public class RequestEvaluator {
    private final List<RequestRule> rules;

    public RequestEvaluator(){
        rules = new ArrayList<>();
        rules.add(new AutomaticApprovalRule());
        rules.add(new UrgentRequestRule());
        rules.add(new AmountReviewRule());
        rules.add(new AmountExceededRule());

    }

    public EvaluationResult evaluate(Request  request){
        for (RequestRule rule : rules){
            if (rule.appliesTo(request)){
                return rule.resultFor(request);
            }
        }

        throw new IllegalStateException("No matching rule found for request");
    }
}
