package org.healthtest.model.impl;

import org.healthtest.model.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Service
public class Turtle implements Animal {
    @Override
    public String getInfo() {
        return "Donatello";
    }
}
