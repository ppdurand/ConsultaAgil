package edu.example.ConsultaAgil.api.controller;

import edu.example.ConsultaAgil.application.dto.AuthDTO.*;
import edu.example.ConsultaAgil.domain.model.User;
import edu.example.ConsultaAgil.infra.repository.UserRepository;
import edu.example.ConsultaAgil.infra.security.TokenService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request){
        User user = this.userRepository.findByEmail(request.email()).orElseThrow(()->new RuntimeException("Email not found"));

        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            String token  = this.tokenService.generateToken(user);

            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody SignUpRequest request){
        System.out.println("entrou");
        Optional<User> userConsult = this.userRepository.findByEmail(request.email());
        if(userConsult.isPresent()) return ResponseEntity.badRequest().build();

        User user = new User();

        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setUsername(request.username());

        this.userRepository.save(user);

        String token  = this.tokenService.generateToken(user);
        System.out.println("Toke => " + token);
        System.out.println("Request =>" + request);
        return ResponseEntity.ok(new LoginResponse(user.getUsername(), token));
    }

}
