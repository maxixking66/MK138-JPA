package ir.maktabsharif.jpa.util;

import ir.maktabsharif.jpa.domains.User;
import jakarta.persistence.PreUpdate;

public class UsersEntityListener {

    @PreUpdate
    public void performUsersPreUpdateLogic(User o) {
        System.out.println("users preUpdate");
    }
}
