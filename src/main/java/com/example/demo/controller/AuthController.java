package com.example.demo.controller;

import com.example.demo.domain.user.User;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserSaveDto;
import com.example.demo.infra.security.TokenService;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByNome(body.nome()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserSaveDto body){
        Optional<User> user = this.userRepository.findByNome(body.nome());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setNome(body.nome());
            newUser.setPontos(0);
            newUser.setLocalizacao(body.localizacao());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
