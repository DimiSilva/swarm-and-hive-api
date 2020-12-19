package com.eijteam.swarm.and.hive.modules.user.repositories;

import com.eijteam.swarm.and.hive.modules.user.entities.User;

public interface UserRepositoryCustom {
    User getByEmail(String email);
}
