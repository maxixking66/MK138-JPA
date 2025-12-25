package ir.maktabsharif.jpa.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = User.TABLE_NAME, indexes = {
        @Index(columnList = User.USERNAME_COLUMN, unique = true),
        @Index(columnList = User.FIRST_NAME_COLUMN + ", " + User.LAST_NAME_COLUMN, unique = true),
})
@Setter
@Getter
@NoArgsConstructor
public class User {

    public static final String TABLE_NAME = "users";
    public static final String ID_COLUMN = "id";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String USERNAME_COLUMN = "username";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = FIRST_NAME_COLUMN)
    private String firstName;

    @Column(name = LAST_NAME_COLUMN)
    private String lastName;

    @Column(name = USERNAME_COLUMN)
    private String username;
}
