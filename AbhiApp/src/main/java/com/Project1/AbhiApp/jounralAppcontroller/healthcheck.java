package com.Project1.AbhiApp.jounralAppcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheck {

    @GetMapping("/health_check")
    public String healthcheck(){
        return  "OK Manish";
    }
}
