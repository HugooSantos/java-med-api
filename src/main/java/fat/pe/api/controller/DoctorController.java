package fat.pe.api.controller;

import fat.pe.api.doctors.DataDoctors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @PostMapping
    public void store(@RequestBody DataDoctors dataDoctors){
        System.out.println(dataDoctors);
    }

}
