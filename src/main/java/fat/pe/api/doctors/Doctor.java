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
    private Boolean active;
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Embedded
    private Address address;

    public Doctor(DataStoreDoctors dataDoctors) {
        this.active = true;
        this.name = dataDoctors.name();
        this.email = dataDoctors.email();
        this.crm = dataDoctors.crm();
        this.phone = dataDoctors.phone();
        this.speciality = dataDoctors.speciality();
        this.address = new Address(dataDoctors.addressData());
    }

    public void updateInfo(DataUpdateDoctors dataDoctors) {
        this.name = dataDoctors.name();
        this.address.updateInfo(dataDoctors.addressData());
    }

    public void delete() {
        this.active = false;
    }
}
