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

                User first = new User();
                first.setUsername("first");

                em.persist(first);


                User second = new User();
                second.setUsername("second");

                em.persist(second);


                Wallet wallet = new Wallet();
                wallet.setUser(second);

                em.persist(wallet);


//                first.setWallet(wallet);

                em.getTransaction().commit();

            }

        }
    }
}