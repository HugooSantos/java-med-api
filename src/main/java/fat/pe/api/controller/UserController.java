package fat.pe.api.controller;

import fat.pe.api.domain.user.DataUser;
import fat.pe.api.domain.user.User;
import fat.pe.api.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity Store(@RequestBody @Valid DataUser dataUser){
        var user = new User();
        user.saveNewUser(dataUser);
        repository.save(user);
        return ResponseEntity.ok("usuario cadastrado com sucesso");
    }

}
