package fat.pe.api.domain.doctors;

public record DataShowDoctor(Long id, String name, String crm, String email, Speciality speciality) {

    public DataShowDoctor(Doctor doctor){
            this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getEmail(), doctor.getSpeciality());
    }

}
