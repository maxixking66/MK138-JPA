package ir.maktabsharif.jpa.domains;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Role.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseDomain<Long> {

    public static final String TABLE_NAME = "roles";
    public static final String AUTHORITY_JOIN_TABLE = "roles_authorities";

    private String name;

    @ManyToMany
    @JoinTable(name = AUTHORITY_JOIN_TABLE)
    private Set<Authority> authorities = new HashSet<>();
}
