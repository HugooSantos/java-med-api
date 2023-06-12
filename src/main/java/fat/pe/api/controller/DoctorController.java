package fat.pe.api.controller;

import fat.pe.api.domain.doctors.*;
import fat.pe.api.domain.doctors.DataShowDoctor;
import fat.pe.api.domain.doctors.Doctor;
import fat.pe.api.domain.doctors.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity store(@RequestBody @Valid DataStoreDoctors dataDoctors, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(dataDoctors);
        repository.save(doctor);
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDatailsDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<DataShowDoctor>> show(){
        var all = repository.findAll().stream().map(DataShowDoctor::new).toList();
        return ResponseEntity.ok(all);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctors dataDoctors){
        var doctor = repository.getReferenceById(dataDoctors.id());
        doctor.updateInfo(dataDoctors);
        return ResponseEntity.ok(new DataDatailsDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity destroy(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDatailsDoctor(doctor));
    }
}
