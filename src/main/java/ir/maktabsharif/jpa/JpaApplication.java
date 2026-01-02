package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.domains.Customer;
import ir.maktabsharif.jpa.domains.User;
import ir.maktabsharif.jpa.repositories.UserRepository;
import ir.maktabsharif.jpa.util.ApplicationContext;

public class JpaApplication {

    static void main() {

        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();

        userRepository.save(new User());

        ApplicationContext.getInstance().getCustomerRepository().save(new Customer());

    }
}