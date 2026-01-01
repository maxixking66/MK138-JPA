package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.constants.AuthorityNames;
import ir.maktabsharif.jpa.domains.Authority;
import ir.maktabsharif.jpa.domains.Role;
import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.Pageable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

                initAuthorities(em);

                em.getTransaction().begin();

                Role role = new Role();
                role.setName("مدیر");
                em.persist(role);

                role = new Role();
                role.setName("دبیر");
                em.persist(role);


                em.getTransaction().commit();

//                findAllUsers(
//                        em, Pageable.defaultPage()
//                );

                findAllUsers(
                        em,
                        new Pageable() {
                            @Override
                            public int size() {
                                return 2;
                            }

                            @Override
                            public int page() {
                                return 2;
                            }
                        }
                );


//                TypedQuery<User> typedQuery = em.createQuery("from User u", User.class);
//                EntityGraph<?> userWalletGraph = em.getEntityGraph(User.USER_ROLES_AUTHORITIES_GRAPH);
//                typedQuery.setHint(
//                        "jakarta.persistence.fetchgraph",
////                "jakarta.persistence.loadgraph",
//                        userWalletGraph
//                );

//                List<User> users = typedQuery.getResultList();
//
//                System.out.println(users.size());
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

    private static void findAllUsers(EntityManager em, Pageable pageable) {
        TypedQuery<User> typedQuery = em.createQuery("from User u order by u.id desc", User.class);
        typedQuery.setFirstResult(pageable.offset());
        typedQuery.setMaxResults(pageable.size());

        typedQuery.setHint(
                "jakarta.persistence.fetchgraph",
                em.getEntityGraph(User.USER_ROLES_AUTHORITIES_GRAPH)
        );

        List<User> users = typedQuery.getResultList();

        users.forEach(user -> System.out.println(user.getId()));
    }
}