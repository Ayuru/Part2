package com.extra.chapter1.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class simpleLogger implements BeanPostProcessor {
    private static final Logger logger = Logger.getLogger(simpleLogger.class.getName());

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.log(Level.INFO, beanName + " is on fire!");
        return bean;
    }

}
