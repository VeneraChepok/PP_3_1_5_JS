package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService{

    User findUserById(int id);
    void add(User user);
    List<User> listUsers();

    Optional<User> show(int id);

    void update (User user, int id);

    void delete(int id);

}

