package org.healthtest.model;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Component
/*
@Service
@Controller
@Configuration
@Repository
 */
//@Scope("prototype")
public class Rabbit {
    private String name;

    public Rabbit() {
    }

    public Rabbit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
