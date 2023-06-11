package fat.pe.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressData addressData) {
        this.street = addressData.street();
        this.neighborhood = addressData.neighborhood();
        this.cep = addressData.cep();
        this.city = addressData.city();
        this.state = addressData.state();
        this.complement = addressData.complement();
        this.number = addressData.number();
    }

    public void updateInfo(AddressData addressData) {
        this.street = addressData.street();
        this.neighborhood = addressData.neighborhood();
        this.cep = addressData.cep();
        this.city = addressData.city();
        this.state = addressData.state();
        this.complement = addressData.complement();
        this.number = addressData.number();
    }
}
