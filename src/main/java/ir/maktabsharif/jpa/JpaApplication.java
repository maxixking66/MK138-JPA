package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.*;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

//                TypedQuery<User> typedQuery = em.createQuery("from User u join fetch u.wallet", User.class);
                TypedQuery<User> typedQuery = em.createQuery("from User u", User.class);

                EntityGraph<User> userWalletGraph = em.createEntityGraph(User.class);
                userWalletGraph.addAttributeNode("wallet");

                typedQuery.setHint(
                        "jakarta.persistence.fetchgraph",
//                "jakarta.persistence.loadgraph",
                        userWalletGraph
                );

                List<User> users = typedQuery.getResultList();

                System.out.println(users.size());

                users.forEach(user -> System.out.println(user.getWallet().getCredit()));
            }

        }
    }
}