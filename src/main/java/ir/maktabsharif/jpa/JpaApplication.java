package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.Grade;
import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

                em.getTransaction().begin();

                User u = new User();
                u.setUsername("mat");
                u.setGrade(Grade.F);
                em.persist(u);

                em.getTransaction().commit();

            }

        }
    }
}