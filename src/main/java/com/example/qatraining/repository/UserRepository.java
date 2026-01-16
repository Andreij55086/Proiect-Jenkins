package com.example.qatraining.repository;

import com.example.qatraining.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final Map<Long, User> data = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public User save(User u) {
        if (u.getId() == null) {
            u.setId(seq.incrementAndGet());
        }
        data.put(u.getId(), u);
        return u;
    }

    public Optional<User> findById(Long id) { return Optional.ofNullable(data.get(id)); }
    public Optional<User> findByUsername(String username) {
        return data.values().stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).findFirst();
    }
    public List<User> findAll() { return new ArrayList<>(data.values()); }
    public void deleteById(Long id) { data.remove(id); }
    public void clear() { data.clear(); }
}
