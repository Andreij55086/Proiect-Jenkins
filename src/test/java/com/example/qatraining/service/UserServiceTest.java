package com.example.qatraining.service;

import com.example.qatraining.model.User;
import com.example.qatraining.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository repo;
    private UserService service;

    @BeforeEach
    void setUp() {
        repo = Mockito.mock(UserRepository.class);
        service = new UserService(repo);
    }

    @Test
    void createUser_normalizesAndSaves() {
        when(repo.findByUsername("john")).thenReturn(Optional.empty());
        when(repo.save(any())).thenAnswer(inv -> { User u = inv.getArgument(0); u.setId(1L); return u; });

        User created = service.createUser("  John  ", "j@e.com");

        assertEquals("john", created.getUsername());
        verify(repo).save(any(User.class));
    }

    // TODO: test duplicate username -> throws IllegalStateException
    @Test
    void createUser_duplicateUsername_throwsIllegalState_andDoesNotSave() {
        // Arrange
        // simulăm că în repo există deja "john" (case-insensitive)
        when(repo.findByUsername("john")).thenReturn(Optional.of(new User(1L, "john", "old@x.com")));

        // Act + Assert
        assertThrows(IllegalStateException.class,
                () -> service.createUser("John", "new@x.com"));

        // și ne asigurăm că NU s-a încercat salvarea
        verify(repo, never()).save(any());
    }





    // TODO: test blank username after normalization -> throws IllegalArgumentException

    @Test
    void verificablank(){
    String ceva = " \t ";

    assertThrows(IllegalArgumentException.class,() ->service.createUser(ceva,"ceva@mail.com"));

    verify(repo,never()).save(any());
    }

}

