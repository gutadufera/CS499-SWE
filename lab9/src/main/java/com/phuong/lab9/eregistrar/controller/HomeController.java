package com.phuong.lab9.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/eregistrar"})
    public String displayHomePage(){
        return "/home/index";
    }
}
