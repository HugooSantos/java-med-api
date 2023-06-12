package fat.pe.api.controller;

import fat.pe.api.doctors.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public void store(@RequestBody @Valid DataStoreDoctors dataDoctors){
        repository.save(new Doctor(dataDoctors));
    }

    @GetMapping
    public List<DataShowDoctor> show(){
        return repository.findAll().stream().map(DataShowDoctor::new).toList();
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateDoctors dataDoctors){
        var doctor = repository.getReferenceById(dataDoctors.id());
        doctor.updateInfo(dataDoctors);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void destroy(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }
}
