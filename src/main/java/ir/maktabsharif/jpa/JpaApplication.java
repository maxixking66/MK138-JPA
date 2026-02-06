package ir.maktabsharif.jpa;

public class JpaApplication {

    static void main() throws InterruptedException {
        long start = System.currentTimeMillis();
        getCustomerInformation("002112121");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static CustomerInformation getCustomerInformation(String accountNumber) throws InterruptedException {
        CustomerInformation customerInformation = new CustomerInformation();
        fetchPersonalInformation(customerInformation, accountNumber);
        fetchBalanceInformation(customerInformation, accountNumber);
        fetchAccountInformation(customerInformation, accountNumber);
        return customerInformation;
    }

    static void fetchPersonalInformation(CustomerInformation information,
                                         String accountNumber) throws InterruptedException {
        Thread.sleep(500);
    }

    static void fetchBalanceInformation(CustomerInformation information,
                                        String accountNumber) throws InterruptedException {
        Thread.sleep(1500);
    }

    static void fetchAccountInformation(CustomerInformation information,
                                        String accountNumber) throws InterruptedException {
        Thread.sleep(100);
    }

}

class CustomerInformation {
    PersonalInformation personal;
    BalanceInformation balance;
    AccountInformation account;
}

class PersonalInformation {
    String firstName;
    String lastName;
    String nationalCode;
}

class BalanceInformation {
    long balance;
}

class AccountInformation {
    String accountNumber;
    String branch;
}