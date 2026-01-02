package ir.maktabsharif.jpa.domains;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import ir.maktabsharif.jpa.util.UsersEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(value = UsersEntityListener.class)
public class Wallet extends BaseDomain<Long> {

    public static final String TABLE_NAME = "wallets";
    public static final String CASH_COLUMN = "cash";
    public static final String CREDIT_COLUMN = "credit";

    @Column(name = CASH_COLUMN, nullable = false)
    private Long cash = 0L;

    @Column(name = CREDIT_COLUMN, nullable = false)
    private Long credit = 0L;

//    @ManyToOne
//    private User user;
}
