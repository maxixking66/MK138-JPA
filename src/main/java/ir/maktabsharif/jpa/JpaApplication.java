package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager entityManager = emf.createEntityManager()) {

                findUserByUsername(entityManager, "mat");
                findUserByUsername(entityManager, "2");
                findUserByUsername(entityManager, "3");

            }

        }
    }

    public static void findUserByUsername(EntityManager entityManager, String username) {

        TypedQuery<User> typedQuery = entityManager.createQuery(
                "from User u where u.username = ?1",
                User.class
        );
        typedQuery.setParameter(1, username);
        System.out.println(
                typedQuery.getSingleResultOrNull()
        );

    }
}