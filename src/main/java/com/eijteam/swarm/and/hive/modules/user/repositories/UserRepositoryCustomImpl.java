package com.eijteam.swarm.and.hive.modules.user.repositories;

import com.eijteam.swarm.and.hive.modules.user.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getByEmail(String email) {
        Query query = entityManager.createNativeQuery(
                "SELECT u.* FROM user_account as u +" +
                   "WHERE u.email = ?", User.class);

        query.setParameter(1, email);

        return null;
    }

}
