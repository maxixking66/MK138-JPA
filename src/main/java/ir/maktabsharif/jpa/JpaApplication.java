package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager entityManager = emf.createEntityManager()) {

                User user = entityManager.find(User.class, 2L);

                System.out.println("before detach: " + entityManager.contains(user));
                entityManager.detach(user);
                System.out.println("after detach: " + entityManager.contains(user));
                user.setUsername("asgari@");

            }

        }
    }
}