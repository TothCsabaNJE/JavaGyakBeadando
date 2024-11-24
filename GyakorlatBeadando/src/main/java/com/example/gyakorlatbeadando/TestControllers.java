package com.example.gyakorlatbeadando;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestControllers {
    private final UserRepository repository;
    public TestControllers(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    Iterable<User> readAll() {
        return repository.findAll();
    }

    @GetMapping("/test/{id}")
    User readOne(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/test")
    User create(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/test/{id}")
    User updateOne(@PathVariable Integer id, @RequestBody User user) {
        return repository.findById(id)
                .map(a->{
                    a.setName(user.getName());
                    a.setPassword(user.getPassword());
                    a.setRole(user.getRole());
                    return repository.save(a);
                })
                .orElseGet(()->{
                    user.setId(id);
                    return repository.save(user);
                });
    }

    @DeleteMapping("/test/{id}")
    void deleteOne(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
