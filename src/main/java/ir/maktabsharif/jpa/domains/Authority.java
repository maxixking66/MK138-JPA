package ir.maktabsharif.jpa.domains;

import ir.maktabsharif.jpa.domains.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Authority.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseDomain<Long> {

    public static final String TABLE_NAME = "authorities";

    private String name;
}
