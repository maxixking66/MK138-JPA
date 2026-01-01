package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.domains.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

                em.getTransaction().begin();

//                Wallet wallet = new Wallet();
//                em.persist(wallet);

                User user = new User();
                user.setWallet(new Wallet());
                em.persist(user);

                em.getTransaction().commit();

            }

        }
    }
}