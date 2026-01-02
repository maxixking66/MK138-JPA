package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.util.ApplicationContext;

public class JpaApplication {

    static void main() {

        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();

        User user = new User();
        user.setFirstName("mohsen");
        user.setLastName("asgari");
        user.setUsername("mat");
        user.setIsActive(true);
        userRepository.save(user);

    }
}