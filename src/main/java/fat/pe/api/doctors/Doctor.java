package fat.pe.api.doctors;


import fat.pe.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="doctors")
@Entity(name="doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Embedded
    private Address address;

    public Doctor(DataDoctors dataDoctors) {
        this.name = dataDoctors.name();
        this.email = dataDoctors.email();
        this.crm = dataDoctors.crm();
        this.speciality = dataDoctors.speciality();
        this.address = new Address(dataDoctors.addressData());
    }
}
