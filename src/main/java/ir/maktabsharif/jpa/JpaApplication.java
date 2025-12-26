package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaApplication {

    static void main() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {

            try (EntityManager entityManager = emf.createEntityManager()) {

                entityManager.getTransaction().begin();

                List<User> userList = entityManager.createQuery(
                        "select u from User u", User.class
                ).getResultList();

//                userList.forEach(
//                        user -> System.out.println(user.getId() + " contains in em: " + entityManager.contains(user))
//                );

                userList.forEach(
                        user -> {
                            if (user.getId() % 2 != 0) {
                                user.setUsername(
                                        user.getUsername() + "*"
                                );
                            }
                        }
                );

                entityManager.getTransaction().commit();
            }

        }
    }
}