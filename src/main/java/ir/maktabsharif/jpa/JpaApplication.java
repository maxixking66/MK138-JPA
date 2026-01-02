package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.util.ApplicationContext;

public class JpaApplication {

    static void main() {

        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();

        System.out.println(userRepository.findByUsername("mat"));

    }
}