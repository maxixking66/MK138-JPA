package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.domains.User_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class BaseUserRepositoryImpl<T extends User> extends SimpleCrudRepository<T, Long>
        implements BaseUserRepository<T> {

    public BaseUserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public T findByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getEntityClass());
        Root<T> userRoot = query.from(getEntityClass());
        query.where(
                cb.equal(
                        userRoot.get(User_.USERNAME), username
                )
        );
        return entityManager.createQuery(query).getSingleResultOrNull();
    }
}
