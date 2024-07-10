package com.extra.chapter1.calc.service;


import com.extra.chapter1.beanLifecycle.simpleLogger;
import com.extra.chapter1.calc.event.CalculationRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CalculationManager implements ApplicationListener<CalculationRegisteredEvent> {

    private static final Logger logger = Logger.getLogger(CalculationManager.class.getName());

    @Override
    public void onApplicationEvent(CalculationRegisteredEvent event) {
       logger.log(Level.INFO,event.getOperator() +  " " + event.getFirstVariable() +
               " and " + event.getSecondVariable() +  " = " + event.getResult() +".");
    }
}
