package com.extra.chapter1.beanLifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifecycleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();

        LibraryManager manager = context.getBean(LibraryManager.class);
        System.out.println("Context and beans are set up and ready to work");
        context.close();
    }

}