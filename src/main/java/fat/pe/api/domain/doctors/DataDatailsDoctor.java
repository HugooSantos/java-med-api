package fat.pe.api.domain.doctors;

public record DataDatailsDoctor(Long id, String name, String email, String crm, Speciality speciality) {
    public DataDatailsDoctor(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
