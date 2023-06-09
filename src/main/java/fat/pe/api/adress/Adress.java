package fat.pe.api.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {

    private String publicAdress;
    private String neighborhood;
    private String cep;
    private String city;
    private String state;
    private String complement;
    private String number;
}
