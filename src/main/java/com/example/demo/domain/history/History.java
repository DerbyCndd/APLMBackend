/*package com.example.demo.domain.history;

import com.example.demo.domain.bike.Bike;
import com.example.demo.domain.estacao.Estacao;
import com.example.demo.domain.user.User;
import com.example.demo.dto.HistorySaveDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "history")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String estacao_id;
    private String bike_id;
    private String user_id;

    @NotNull
    private String rota; // Nome mais descritivo para a trajetória

    // Construtor que converte o DTO para a entidade
    public History(HistorySaveDto historySaveDto) {
        if (historySaveDto == null) {
            throw new IllegalArgumentException("O DTO de entrada não pode ser nulo.");
        }



        this.estacao_id = historySaveDto.estacao(); // Ou conversão: new Estacao(historySaveDto.estacaoId());
        this.bike_id = historySaveDto.idBike();     // Ou conversão: new Bike(historySaveDto.bikeId());
        this.user_id = historySaveDto.idUser();     // Ou conversão: new User(historySaveDto.userId());
        this.rota = historySaveDto.rota(); // Nome atualizado
    }
}
*/