package com.extra.chapter1.calc.domian;

import lombok.Data;


@Data
public class Operations {
    private final Integer firstVariable;
    private final Integer secondVariable;
    private final Operators operator;
    private final Integer result;
}

