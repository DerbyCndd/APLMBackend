package com.example.demo.controller;


import com.example.demo.domain.estacao.Estacao;
import com.example.demo.dto.EstacaoResponseDTO;
import com.example.demo.dto.EstacaoSaveDto;
import com.example.demo.repository.EstacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estacao")
public class EstacaoController {

    @Autowired
    private EstacaoRepository estacaoRepository;

    @PostMapping("/adicionarEstacao")
    public ResponseEntity adicionarEstacao(@RequestBody EstacaoSaveDto body){

        Estacao newestacao = new Estacao();
        newestacao.setLongitude(body.longitude());
        newestacao.setLatitude(body.latitude());
        newestacao.setQuntddBikes(0);
        this.estacaoRepository.save(newestacao);
        return ResponseEntity.ok(new EstacaoResponseDTO(newestacao.getQuntddBikes(), newestacao.getLongitude(), newestacao.getLatitude()));
    }

}
