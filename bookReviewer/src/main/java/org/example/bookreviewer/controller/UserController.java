package org.example.bookreviewer.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookreviewer.model.User;
import org.example.bookreviewer.repository.UserRepository;
import org.example.bookreviewer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public List<User> gettAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userRepository.delete(user);
    }
}
