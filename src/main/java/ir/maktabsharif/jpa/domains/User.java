package ir.maktabsharif.jpa.domains;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User extends BaseDomain<Long> {

    public static final String TABLE_NAME = "users";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String USERNAME_COLUMN = "username";
    public static final String DESCRIPTION_COLUMN = "description";
    public static final String MY_TEXT_COLUMN = "my_text";
    public static final String IS_ACTIVE_COLUMN = "is_active";
    public static final String GRADE_COLUMN = "grade";

    @Column(name = FIRST_NAME_COLUMN, comment = "فامیلی")
    private String firstName;

    @Column(name = LAST_NAME_COLUMN, comment = "this is lastName col")
    private String lastName;

    @Column(name = USERNAME_COLUMN, nullable = false, unique = true, length = 2048)
    private String username;

    @Column(name = DESCRIPTION_COLUMN, columnDefinition = "VARCHAR")
    private String description;

    @Column(name = MY_TEXT_COLUMN)
    private String myText;

    @Column(name = IS_ACTIVE_COLUMN)
    private Boolean isActive;

    @Column(name = GRADE_COLUMN)
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @ManyToMany
    @JoinTable(name = "u_w_s")
    private Set<Wallet> wallets;

}
