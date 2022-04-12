package com.diary.web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @PostMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping ("/")
public String home() {
    return "home";
}
@Mapping("/error")
    public String error() {
        return "default";
}
}
