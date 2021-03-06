package com.gba.myroutine.repository;

import com.gba.myroutine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameIgnoreCaseContaining(String name);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String filter);
}