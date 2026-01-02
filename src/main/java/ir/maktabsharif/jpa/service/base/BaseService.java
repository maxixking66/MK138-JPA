package ir.maktabsharif.jpa.service.base;

import ir.maktabsharif.jpa.domains.base.BaseDomain;

import java.util.List;

public interface BaseService<T extends BaseDomain<ID>, ID extends Number> {

    T save(T t);

    List<T> findAll();

    T findById(ID id);

    long count();

    boolean existsById(ID id);

    void deleteAll();

    void deleteById(ID id);

    void delete(T t);
}
