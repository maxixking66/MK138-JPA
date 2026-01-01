package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.constants.AuthorityNames;
import ir.maktabsharif.jpa.domains.Authority;
import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.*;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

                initAuthorities(em);

//                TypedQuery<User> typedQuery = em.createQuery("from User u join fetch u.wallet", User.class);
                TypedQuery<User> typedQuery = em.createQuery("from User u", User.class);

                EntityGraph<?> userWalletGraph = em.getEntityGraph(User.USER_ROLES_AUTHORITIES_GRAPH);
                typedQuery.setHint(
                        "jakarta.persistence.fetchgraph",
//                "jakarta.persistence.loadgraph",
                        userWalletGraph
                );

                List<User> users = typedQuery.getResultList();

                System.out.println(users.size());
            }

        }
    }

    private static void initAuthorities(EntityManager em) {
        AuthorityNames.ALL_AUTHORITIES
                .forEach(auth -> {
                    TypedQuery<Long> query = em.createQuery("select count(*) from Authority a where a.name = :authName", Long.class);
                    query.setParameter("authName", auth);
                    Long count = query.getSingleResult();
                    if (count == 0) {
                        em.getTransaction().begin();
                        Authority authority = new Authority();
                        authority.setName(auth);
                        em.persist(authority);
                        em.getTransaction().commit();
                    }
                });
    }
}