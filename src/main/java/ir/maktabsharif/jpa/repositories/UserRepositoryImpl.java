package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.base.BaseUserRepositoryImpl;
import jakarta.persistence.EntityManager;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<User>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
