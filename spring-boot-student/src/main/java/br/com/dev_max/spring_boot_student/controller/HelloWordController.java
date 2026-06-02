package br.com.dev_max.spring_boot_student.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/hello")
public class HelloWordController {

    @GetMapping
    public String helloWord() {helloWord
        return "Hello Word!";
    }

}
