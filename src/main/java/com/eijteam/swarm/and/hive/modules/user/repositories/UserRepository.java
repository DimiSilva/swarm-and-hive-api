package com.eijteam.swarm.and.hive.modules.user.repositories;

import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
