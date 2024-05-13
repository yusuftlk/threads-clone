package com.project.threadsclone.repository;

import com.project.threadsclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByMail(String mail);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
