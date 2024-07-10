package com.extra.chapter1.calc.event;

import com.extra.chapter1.calc.domian.Operators;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class CalculationRegisteredEvent extends ApplicationEvent {
    private final Integer firstVariable;
    private final Integer secondVariable;
    private final Operators operator;
    private final Integer result;

    public CalculationRegisteredEvent(Object source,
                                      Integer firstVariable,
                                      Integer secondVariable,
                                      Operators operator,
                                      Integer result) {
        super(source);
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
        this.operator = operator;
        this.result = result;
    }
}
