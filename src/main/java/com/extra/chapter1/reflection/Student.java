package com.extra.chapter1.reflection;

import lombok.Getter;

import java.util.Random;

@Getter
public class Student {
    private String indexNumber;

    public Student() {
        Random random = new Random();
        this.indexNumber = random.ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

}