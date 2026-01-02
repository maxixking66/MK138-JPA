package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import ir.maktabsharif.jpa.util.JpaUtils;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class SimpleCrudRepository<T extends BaseDomain<ID>, ID extends Number>
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
        return List.of();
    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public void deleteAll() {

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
}
