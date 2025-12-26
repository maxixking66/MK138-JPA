package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager entityManager = emf.createEntityManager()) {

                EntityTransaction transaction = entityManager.getTransaction();
                transaction.begin();

                User user = new User();
                user.setUsername("mat");

                entityManager.persist(user);

                user.setFirstName("mohsen");

                transaction.commit();

            }

        }
    }
}