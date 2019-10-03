package org.healthtest.model.impl;

import org.healthtest.model.*;
import org.springframework.stereotype.*;

@Service("croc")
public class Crocodile implements Animal {
    @Override
    public String getInfo() {
        return "Gena";
    }
}
