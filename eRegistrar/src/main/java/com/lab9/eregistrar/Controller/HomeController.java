package com.lab9.eregistrar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/eregistrar"})
    public String home() {
        return "student/list";
    }
}
