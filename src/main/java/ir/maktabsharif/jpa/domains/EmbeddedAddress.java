package ir.maktabsharif.jpa.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class EmbeddedAddress {

    public static final String ADDRESS_COLUMN = "address";
    public static final String POSTAL_CODE_COLUMN = "postal_code";

    @Column(name = ADDRESS_COLUMN)
    private String address;

    @Column(name = POSTAL_CODE_COLUMN)
    private String postalCode;
}
