package com.example.qatraining.service;

import com.example.qatraining.model.User;
import com.example.qatraining.repository.UserRepository;
import com.example.qatraining.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(String username, String email) {
        String normalized = StringUtils.normalizeUsername(username);
        if (normalized.isBlank()) {
            throw new IllegalArgumentException("username is blank after normalization");
        }
        // business rule: usernames must be unique (case-insensitive)
        repo.findByUsername(normalized).ifPresent(u -> {
            throw new IllegalStateException("username already taken");
        });
        User u = new User(null, normalized, email);
        return repo.save(u);
    }

    public List<User> allUsers() { return repo.findAll(); }

    public void deleteUser(Long id) { repo.deleteById(id); }
}
