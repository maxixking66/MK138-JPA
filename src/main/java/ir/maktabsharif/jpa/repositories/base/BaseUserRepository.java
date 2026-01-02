package ir.maktabsharif.jpa.repositories.base;

import ir.maktabsharif.jpa.domains.User;

public interface BaseUserRepository<T extends User> extends CrudRepository<T, Long> {

    T findByUsername(String username);
}
