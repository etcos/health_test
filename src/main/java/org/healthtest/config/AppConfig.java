package org.healthtest.config;

import org.healthtest.model.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public Dog dog() {
        // any logic
        return new Dog("Sharik", "sweet");
    }
}
