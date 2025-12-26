package ir.maktabsharif.jpa.domains;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class EmbeddedAddress {

    private String postalCode;

    private String address;
}
