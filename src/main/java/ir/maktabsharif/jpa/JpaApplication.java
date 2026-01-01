package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.domains.base.BaseDomain_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager em = emf.createEntityManager()) {

//                select u from User u
//                from User
//                em.createQuery("user User", User.class);
//                em.createQuery("select count(*) user User", Long.class);
//                em.createQuery("select count(*) user Wallet", Long.class);

//                select u from User u where u.firstName = 'x'
                CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
                CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
                Root<User> userRoot = query.from(User.class);

//                where u.firstName like '%m%'
//                query.where(
//                        criteriaBuilder.like(
//                                userRoot.get(User_.firstName),
//                                "%" + "m" + "%"
//                        )
//                );

//                u.id >= 5
                query.where(
                        criteriaBuilder.greaterThanOrEqualTo(
                                userRoot.get(BaseDomain_.ID),
                                5L
                        )
                );

                TypedQuery<User> typedQuery = em.createQuery(query);
                System.out.println(typedQuery.getResultList().size());

            }

        }
    }
}