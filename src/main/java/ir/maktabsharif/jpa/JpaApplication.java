package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager entityManager = emf.createEntityManager()) {

                entityManager.getTransaction().begin();

                User u = new User();
                u.setUsername("444");

                u = entityManager.merge(u);

                u.setUsername(u.getUsername() + "*");

                entityManager.getTransaction().commit();


            }

        }
    }
}