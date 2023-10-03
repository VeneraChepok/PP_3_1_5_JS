package ru.kata.spring.boot_security.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminRestController {
    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> allUsers = userService.listUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Optional<User> > getUser(@PathVariable int id) {
        Optional<User> user = userService.show(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/users")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/users/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user, @PathVariable int id) {
        userService.update(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/admin")
    public ModelAndView userPage2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

}
