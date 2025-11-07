package com.renew.userservice.repo;


import com.renew.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    boolean existsByEmailAndUseridIsNot(String email, UUID userid);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);


    Optional<User> findByUsername(String username);
}
