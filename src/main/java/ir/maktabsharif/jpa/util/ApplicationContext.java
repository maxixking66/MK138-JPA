package ir.maktabsharif.jpa.util;

import ir.maktabsharif.jpa.repositories.CustomerRepository;
import ir.maktabsharif.jpa.repositories.CustomerRepositoryImpl;
import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.repositories.UserRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class ApplicationContext {

    private static ApplicationContext context;

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private UserRepository userRepository;

    private CustomerRepository customerRepository;

    public static ApplicationContext getInstance() {
        if (context == null) {
            context = new ApplicationContext();
        }
        return context;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (Objects.isNull(entityManagerFactory)) {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        if (Objects.isNull(entityManager)) {
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    public UserRepository getUserRepository() {
        if (Objects.isNull(userRepository)) {
            userRepository = new UserRepositoryImpl(getEntityManager());
        }
        return userRepository;
    }

    public CustomerRepository getCustomerRepository() {
        if (Objects.isNull(customerRepository)) {
            customerRepository = new CustomerRepositoryImpl(getEntityManager());
        }
        return customerRepository;
    }
}
