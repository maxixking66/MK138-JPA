package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import ir.maktabsharif.jpa.domains.base.BaseDomain_;
import ir.maktabsharif.jpa.util.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class SimpleCrudRepository<T extends BaseDomain<ID>, ID extends Number>
        implements CrudRepository<T, ID> {

    protected final EntityManager entityManager;

    @Override
    public T save(T t) {
        return JpaUtils.executeInTransaction(
                this.entityManager,
                () -> {
                    if (Objects.isNull(t.getId())) {
                        entityManager.persist(t);
                    } else {
                        return entityManager.merge(t);
                    }
                    return t;
                }
        );
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T findById(ID id) {
//        return entityManager.find(getEntityClass(), id);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getEntityClass());
        Root<T> tRoot = query.from(getEntityClass());
//        select * from users as u where u.id = ?
        query.where(cb.equal(tRoot.get(BaseDomain_.ID), id));
        return entityManager.createQuery(query).getSingleResultOrNull();
    }

    @Override
    public long count() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> tRoot = query.from(getEntityClass());
        query.select(cb.count(tRoot));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public boolean existsById(ID id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> tRoot = query.from(getEntityClass());
        query.where(
                cb.equal(
                        tRoot.get(BaseDomain_.ID), id
                )
        ).select(cb.count(tRoot));
        return entityManager.createQuery(query).getSingleResult() > 0;
    }

    @Override
    public void deleteAll() {
        JpaUtils.executeInTransaction(
                entityManager,
                () -> {
                    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                    CriteriaDelete<T> delete = cb.createCriteriaDelete(getEntityClass());
                    delete.from(getEntityClass());
                    entityManager.createQuery(delete).executeUpdate();
                    return null;
                }
        );
    }

    @Override
    public void deleteById(ID id) {
        JpaUtils.executeInTransaction(
                this.entityManager,
                () -> {
//                    TODO impl deleteByIdLogic
                    return null;
                }
        );
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    protected abstract Class<T> getEntityClass();
}
