package ir.maktabsharif.jpa.domains;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Wallet extends BaseDomain<Long> {

    public static final String TABLE_NAME = "wallets";
    public static final String CASH_COLUMN = "cash";
    public static final String CREDIT_COLUMN = "credit";

    @Column(name = CASH_COLUMN, nullable = false)
    private Long cash = 0L;

    @Column(name = CREDIT_COLUMN, nullable = false)
    private Long credit = 0L;


    @ManyToOne
    @JoinColumn(name = "user_username", referencedColumnName = User.USERNAME_COLUMN)
    private User user;
}
