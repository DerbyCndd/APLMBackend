package com.example.demo.controller;

import com.example.demo.domain.user.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.UserSaveDto;
import com.example.demo.dto.UserUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    /*
    @PostMapping
    public ResponseEntity registerUser(@RequestBody @Valid UserSaveDto userSaveDto){
        User newUser = new User(userSaveDto);
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(userUpdateDto.id());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPontos(userUpdateDto.pontos());
            user.setLocalizacao(userUpdateDto.localizacao()); // Adicionei atualização de localizacao.

            // Salva as alterações no banco.
            userRepository.save(user);

            return ResponseEntity.ok(user);
        } else {
            // Retorna um 404 se o usuário não for encontrado.
            return ResponseEntity.notFound().build();
        }
    }

    */



}
