package com.extra.chapter1.reflection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/task3")
public class ReflectionTestStudent {

    @GetMapping("/students/{n}")
    public Map<String, String> createStudents(@PathVariable int n) {
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
        }

        Map<String, String> result = new HashMap<>();
        for (Student student : students) {
            try {
                Field field = Student.class.getDeclaredField("indexNumber");
                field.setAccessible(true);
                String indexNumber = (String) field.get(student);
                result.put(Integer.toHexString(System.identityHashCode(student)), indexNumber);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}