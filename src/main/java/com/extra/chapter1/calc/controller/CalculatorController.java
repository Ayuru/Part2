package com.extra.chapter1.calc.controller;

import com.extra.chapter1.calc.service.CalculatorService;
import com.extra.chapter1.calc.domian.Operations;
import com.extra.chapter1.calc.domian.Operators;
import com.extra.chapter1.calc.event.CalculationRegisteredEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public Integer getAddition(@RequestParam Integer a, @RequestParam Integer b) {
        Operations calculation = new Operations(a,b, Operators.ADD, calculatorService.add(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getOperator(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/subtract")
    public Integer getSubtraction(@RequestParam Integer a, @RequestParam Integer b) {
        Operations calculation = new Operations(a,b, Operators.SUBTRACT, calculatorService.subtract(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getOperator(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/multiply")
    public Integer getMultiplication(@RequestParam Integer a, @RequestParam Integer b) {
        Operations calculation = new Operations(a,b, Operators.MULTIPLY, calculatorService.multiply(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getOperator(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/divide")
    public Integer getDivision(@RequestParam Integer a, @RequestParam Integer b) {
        Operations calculation = new Operations(a,b, Operators.DIVIDE, calculatorService.divide(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getOperator(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
