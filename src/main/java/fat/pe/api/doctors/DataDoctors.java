package fat.pe.api.doctors;

import fat.pe.api.adress.AdressData;

public record DataDoctors(String name, String email, String crm, Speciality speciality, AdressData adressData) {
}
