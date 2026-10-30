package dev.decisionflow.config;

import dev.decisionflow.core.RequestEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

    @Bean
    public RequestEvaluator requestEvaluator(){
        return new RequestEvaluator();
    }
}
