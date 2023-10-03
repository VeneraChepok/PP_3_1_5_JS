package ru.kata.spring.boot_security.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @GetMapping("/user")
    public ModelAndView oneUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userpage");
        return modelAndView;
    }
    @GetMapping(value = "/")
    public ModelAndView printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        model.addAttribute("messages", messages);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/api/auth")
    public ResponseEntity<User> getAuthUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}
