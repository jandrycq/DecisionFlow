package dev.decision.core;

import dev.decisionflow.core.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequestTest {

    @Test
    void amountZeroMustCreateValidRequest(){
        Request request = new Request(0, false);

        assertNotNull(request);
    }

    @Test
    void negativeAmountMustThrowIllegalException(){

        assertThrows(IllegalArgumentException.class, () -> new Request(-1000, true));
    }
}
