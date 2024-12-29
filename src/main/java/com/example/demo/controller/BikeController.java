package com.example.demo.controller;

import com.example.demo.domain.bike.Bike;
import com.example.demo.domain.user.User;
import com.example.demo.dto.BikeResponseDTO;
import com.example.demo.dto.BikeSaveDto;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint para adicionar uma nova bicicleta.
     */
    @PostMapping("/adicionarBike")
    public ResponseEntity<BikeResponseDTO> adicionarBike(@RequestBody BikeSaveDto body){
        Bike newBike = new Bike();
        newBike.setEstacao(body.estacao());
        newBike.setLocalizacao(body.localizacao());
        newBike.setReferencia(body.referencia());
        newBike.setEstado(body.estado());

        this.bikeRepository.save(newBike);

        // Retorna a resposta com sucesso e os detalhes da nova bicicleta
        return ResponseEntity.status(HttpStatus.CREATED).body(new BikeResponseDTO(newBike.getReferencia(), newBike.isEstado()));
    }

    /**
     * Endpoint para reservar uma bicicleta.
     */
    @PostMapping("/reservarBike")
    public ResponseEntity<String> reservarBike(@RequestParam String bikeId, @RequestParam String userId) {

        // Verifica se a bicicleta existe
        Bike bike = bikeRepository.findById(bikeId).orElse(null);
        if (bike == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bicicleta não encontrada.");
        }

        // Verifica se a bicicleta está disponível (estado 'true' significa disponível)
        if (!bike.isEstado()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bicicleta indisponível.");
        }

        // Verifica se o usuário existe
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        // Reserva a bicicleta (altera o estado para false, indicando que está alugada)
        bike.setEstado(false);
        bikeRepository.save(bike);

        // Retorna a resposta de sucesso com a confirmação de que a bicicleta foi reservada
        return ResponseEntity.status(HttpStatus.OK).body("Bicicleta reservada com sucesso.");
    }
}
