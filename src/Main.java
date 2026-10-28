import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeDemo();
    }

    private static void executeDemo() {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request(250, false));

        try {
            requests.add(new Request(-1000, true));

        }catch (IllegalArgumentException e){
            System.out.println("Error creating request: " + e.getMessage());
        }

        requests.add(new Request(0, false));
        requests.add(new Request(5000, true));
        requests.add(new Request(5001, false));
        requests.add(new Request(3000, false));

        iterateList(requests);
    }

    private static void iterateList(List<Request> requests) {
        RequestEvaluator requestEvaluator = new RequestEvaluator();
        for (Request request : requests) {
            EvaluationResult evaluationResult = requestEvaluator.evaluate(request);
            printResult(evaluationResult, request);
            System.out.println("\n-------------------------------------------");
        }
    }

    private static void printResult(EvaluationResult evaluationResult, Request request) {
        System.out.println("\nRequest amount: " + request.getAmount());
        System.out.println("Urgent: " + request.isUrgent());
        System.out.println("Decision: " + evaluationResult.decision());
        System.out.println("Reason: " + evaluationResult.reason());
        System.out.println("Reason Code: " + evaluationResult.reasonCode());
    }
}
