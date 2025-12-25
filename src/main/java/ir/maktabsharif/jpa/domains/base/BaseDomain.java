package ir.maktabsharif.jpa.domains.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class BaseDomain<ID extends Number> implements Serializable {

    public static final String ID_COLUMN = "id";

    @Id
    @Column(name = ID_COLUMN)
    private ID id;
}
