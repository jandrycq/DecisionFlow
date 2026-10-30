package dev.decisionflow;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EvaluationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validEvaluationMustReturnHttp200() throws Exception {
        String json = """
                {
                    "amount": 700,
                    "urgent": false
                }
                """;


        mockMvc.perform(
                post("/api/evaluations").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.decision").value("APPROVED"))
                .andExpect(jsonPath("$.reasonCode").value("AUTOMATIC_APPROVAL"));


    }

    @Test
    void negativeAmountMustReturnHttp400() throws Exception{
        String json = """
                {
                    "amount": -1000,
                    "urgent": false
                }
                """;

        mockMvc.perform(
                post("/api/evaluations").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }
}

