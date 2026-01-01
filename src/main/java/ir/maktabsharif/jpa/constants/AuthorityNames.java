package ir.maktabsharif.jpa.constants;

import java.util.ArrayList;
import java.util.List;

public class AuthorityNames {

    public static final String USER_MANAGEMENT = "USER_MANAGEMENT";
    public static final String WALLET_MANAGEMENT = "WALLET_MANAGEMENT";
    public static final String ROLES_MANAGEMENT = "ROLES_MANAGEMENT";

    public static final List<String> ALL_AUTHORITIES = new ArrayList<>();

    static {
        ALL_AUTHORITIES.add(USER_MANAGEMENT);
        ALL_AUTHORITIES.add(WALLET_MANAGEMENT);
        ALL_AUTHORITIES.add(ROLES_MANAGEMENT);
    }
}
