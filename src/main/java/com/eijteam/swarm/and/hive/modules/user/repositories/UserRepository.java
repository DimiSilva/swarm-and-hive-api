package com.eijteam.swarm.and.hive.modules.user.repositories;

import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    User findByEmail(String email);
}
