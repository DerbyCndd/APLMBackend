package com.example.demo.domain.bike;


import com.example.demo.domain.estacao.Estacao;
import com.example.demo.dto.BikeSaveDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "bike")
@Entity(name = "bike")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne // Muitas bicicletas para uma estação
    @JoinColumn(name = "estacao_id", referencedColumnName = "id", nullable = false) // Configuração da chave estrangeira
    private Estacao estacao;
    private String localizacao;
    private String referencia;
    private boolean estado;

    public Bike(BikeSaveDto bikeSaveDto){
        this.estado = bikeSaveDto.estado();
        this.estacao = bikeSaveDto.estacao();
        this.localizacao = bikeSaveDto.localizacao();
        this.referencia = bikeSaveDto.referencia();
    }


}
