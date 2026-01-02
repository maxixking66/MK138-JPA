package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.domains.User_;
import ir.maktabsharif.jpa.repositories.base.SimpleCrudRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserRepositoryImpl extends SimpleCrudRepository<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(getEntityClass());
        Root<User> userRoot = query.from(getEntityClass());
        query.where(
                cb.equal(
                        userRoot.get(User_.username), username
                )
        );
        return entityManager.createQuery(query).getSingleResultOrNull();
    }
}
