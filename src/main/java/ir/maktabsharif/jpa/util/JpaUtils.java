package ir.maktabsharif.jpa.util;

import jakarta.persistence.EntityManager;

import java.util.function.Supplier;

public class JpaUtils {

    private JpaUtils() {
    }

    public static <E> E executeInTransaction(EntityManager entityManager, Supplier<E> logicSupplier) {
        boolean shouldCommit = false;
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
            shouldCommit = true;
        }
        E result = logicSupplier.get();
        if (shouldCommit) {
            entityManager.getTransaction().commit();
        }
        return result;
    }
}
