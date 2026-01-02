package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.domains.base.BaseDomain;

import java.util.List;

public interface CrudRepository<T extends BaseDomain<ID>, ID extends Number> {

    T save(T t);

    List<T> findAll();

    T findById(ID id);

    long count();

    boolean existsById(ID id);

    void deleteAll();

    void deleteById(ID id);
}
