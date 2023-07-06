package fat.pe.api.controller;

import fat.pe.api.domain.user.User;
import fat.pe.api.infra.DataTokenJwt;
import fat.pe.api.infra.TokenService;
import fat.pe.api.user.DataAutentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAutentication dataAutentication){
        var token = new UsernamePasswordAuthenticationToken(dataAutentication.login(),dataAutentication.password());
        var authentication = manager.authenticate(token);
        var authToken =  tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJwt(authToken));
    }

}
