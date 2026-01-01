package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {


                List<User> users = em.createQuery("from User u join fetch u.wallet", User.class)
                        .getResultList();

                System.out.println(users.size());

                users.forEach(user -> System.out.println(user.getWallet().getCredit()));
            }

        }
    }
}