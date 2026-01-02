package ir.maktabsharif.jpa.service.base;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import ir.maktabsharif.jpa.repositories.base.CrudRepository;
import ir.maktabsharif.jpa.util.JpaUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseDomain<ID>, ID extends Number, R extends CrudRepository<T, ID>>
        implements BaseService<T, ID> {

    private final R repository;

    @Override
    public T save(T t) {
        return JpaUtils.executeInTransaction(
                repository.getEntityManager(),
                () -> repository.save(t)
        );
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }
}
