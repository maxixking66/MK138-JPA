package ir.maktabsharif.jpa.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class User {

    public static final String TABLE_NAME = "users";
    public static final String ID_COLUMN = "id";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = FIRST_NAME_COLUMN)
    private String firstName;

    @Column(name = LAST_NAME_COLUMN)
    private String lastName;
}
