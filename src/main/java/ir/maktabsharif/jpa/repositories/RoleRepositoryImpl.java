package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.domains.Role;
import ir.maktabsharif.jpa.repositories.base.SimpleCrudRepository;
import jakarta.persistence.EntityManager;

public class RoleRepositoryImpl extends SimpleCrudRepository<Role, Long> implements RoleRepository {

    public RoleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
