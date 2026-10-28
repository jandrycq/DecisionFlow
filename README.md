# DecisionFlow

DecisionFlow is a Java-based project focused on building a deterministic decision engine through incremental backend development.

The project explores how business rules can be evaluated consistently, with an emphasis on clean code, testing, and gradual architectural evolution.

**Current version: V0.2 — Early development**

## Current Features

DecisionFlow currently provides a simple console-based decision system.

- Request validation with the invariant `amount >= 0`.
- Deterministic decision evaluation based on amount and urgency.
- Three possible outcomes: `APPROVED`, `MANUAL_REVIEW`, and `REJECTED`.
- Console output of the evaluation result.
- Automated unit tests for validation and decision boundaries.

### Decision Flow

`Request → RequestEvaluator → Decision → Console`

Business rules are currently implemented directly inside `RequestEvaluator`.

## Tech Stack

- Java 21
- JUnit 5
- IntelliJ IDEA

The project currently uses plain Java without a build automation tool.

## Testing

The project includes 7 automated unit tests covering:

- Valid and invalid request amounts.
- The effect of the urgency flag.
- Decision boundaries at 1000/1001 and 5000/5001.

All 7 tests passed during the V0.2 validation.

JUnit dependencies are currently configured manually in IntelliJ IDEA.

## Current Limitations

- Console-based execution only.
- Business rules are embedded in `RequestEvaluator`.
- No Maven or Gradle configuration.
- No database, REST API, or persistence layer.
- No external deployment.

## Future Direction

DecisionFlow is being developed incrementally toward a more structured backend decision and workflow engine.

Potential future stages include configurable business rules, a Spring Boot REST API, persistence, security, audit capabilities, and eventually AI-assisted orchestration.

**These capabilities are part of the project's future direction and are not implemented in V0.2.**

The Git history starts from the existing V0.2 implementation. Earlier iterations were developed before version control was introduced.
