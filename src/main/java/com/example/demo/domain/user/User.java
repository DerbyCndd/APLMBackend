package com.example.demo.domain.user;


import com.example.demo.dto.UserSaveDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "user")
@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class User {

    @Id  @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String senha;

    private String localizacao;

    private int pontos;

    public User(UserSaveDto userSaveDto){
        this.localizacao = userSaveDto.localizacao();
        this.nome = userSaveDto.nome();
        this.pontos = userSaveDto.pontos();
        this.senha = userSaveDto.senha();
    }

}
