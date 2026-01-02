package ir.maktabsharif.jpa.repositories;

import ir.maktabsharif.jpa.domains.Customer;
import ir.maktabsharif.jpa.repositories.base.BaseUserRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer>
        implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

}
