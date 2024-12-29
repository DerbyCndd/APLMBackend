/*package com.example.demo.controller;

import com.example.demo.dto.HistoryResponseDTO;
import com.example.demo.dto.HistorySaveDto;
import com.example.demo.domain.history.History;
import com.example.demo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/history")
public class HistoryController {


    // Injeção de dependência
    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/log")
    public ResponseEntity<HistoryResponseDTO> createLog(@RequestBody @Valid HistorySaveDto body) {

        History newLog = new History();
        newLog.setBike_id(body.idBike());
        newLog.setUser_id(body.idUser());
        newLog.setRota(body.rota());
        newLog.setEstacao_id(body.estacao());

        this.historyRepository.save(newLog);

        return ResponseEntity.ok(new HistoryResponseDTO(newLog.getBike_id(), newLog.getUser_id(), newLog.getEstacao_id(), newLog.getRota()));
    }
}
*/