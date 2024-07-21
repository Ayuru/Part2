package com.extra.chapter2.converter.controller;

import com.extra.chapter2.converter.domain.MyCustomClass;
import com.extra.chapter2.converter.domain.TaskClass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom/")
public class CustomController {

    @PostMapping(path = "add")
    public void acceptCustomTextType(@RequestBody MyCustomClass customObject) {
        System.out.println(customObject.getFieldOne());
        System.out.println(customObject.getFieldTwo());
        System.out.println(customObject.getFieldThree());
    }

    @PostMapping(path = "task")
    public void acceptCustomTaskTextType(@RequestBody TaskClass customTaskObject) {
        System.out.println(customTaskObject.getCharacterName());
        System.out.println(customTaskObject.getUniverse());
        System.out.println(customTaskObject.getPowerLevel());
        System.out.println(customTaskObject.getTournamentResult());
    }

}