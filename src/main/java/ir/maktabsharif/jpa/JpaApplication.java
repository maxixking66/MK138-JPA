package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.util.ApplicationContext;

public class JpaApplication {

    static void main() {

        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();

        User user = userRepository.findById(52L);
        user.setIsActive(true);
        user.setLastName("Asgari");
        userRepository.save(user);

    }
}