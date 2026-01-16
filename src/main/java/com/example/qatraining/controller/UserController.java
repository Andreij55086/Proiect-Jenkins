package com.example.qatraining.controller;

import com.example.qatraining.model.User;
import com.example.qatraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String email = body.get("email");
        User created = service.createUser(username, email);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<User> list() { return service.allUsers(); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
