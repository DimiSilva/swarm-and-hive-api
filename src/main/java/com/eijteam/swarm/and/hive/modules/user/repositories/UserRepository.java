package com.eijteam.swarm.and.hive.modules.user.repositories;

import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM u WHERE u.email = ?1")
    User getByEmail(String email);
}
