// 1. Form-based Authentication
package com.example.security1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

    @GetMapping("/hii")
    public String sayHello(){
        return "Hii";
    }
}
