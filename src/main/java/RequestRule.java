public interface RequestRule {
    boolean appliesTo(Request request);
    EvaluationResult resultFor(Request request);
}
