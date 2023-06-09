package fat.pe.api.controller;

import fat.pe.api.doctors.DataDoctors;
import fat.pe.api.doctors.Doctor;
import fat.pe.api.doctors.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public void store(@RequestBody DataDoctors dataDoctors){
        repository.save(new Doctor(dataDoctors));
    }

}
