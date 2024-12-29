package com.example.demo.domain.estacao;


import com.example.demo.dto.EstacaoSaveDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "estacao")
@Entity(name = "estacao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Estacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int quntddBikes;
    private String longitude;
    private String latitude;

    public Estacao(EstacaoSaveDto estacaoSaveDto){
        this.quntddBikes = estacaoSaveDto.quntddBikes();
        this.latitude = estacaoSaveDto.latitude();
        this.longitude = estacaoSaveDto.longitude();
    }
}
