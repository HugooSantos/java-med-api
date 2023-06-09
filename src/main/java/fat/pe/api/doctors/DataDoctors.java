package fat.pe.api.doctors;

import fat.pe.api.address.AddressData;

public record DataDoctors(String name, String email, String crm, Speciality speciality, AddressData addressData) {
}
