package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.base.SimpleCrudRepository;
import jakarta.persistence.EntityManager;

public class UserRepositoryImpl extends SimpleCrudRepository<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
