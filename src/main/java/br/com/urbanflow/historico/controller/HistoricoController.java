package br.com.urbanflow.historico.controller;

import br.com.urbanflow.historico.dto.HistoricoDto;
import br.com.urbanflow.historico.dto.HistoricoPutRequestDto;
import br.com.urbanflow.historico.entities.Historico;
import br.com.urbanflow.historico.service.HistoricoIService;
import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import br.com.urbanflow.reclamacao.dto.ReclamacaoPostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/historico")
@RequiredArgsConstructor
public class HistoricoController {
    private final HistoricoIService historicoIService;
    private final ObjectMapperUtil objectMapperUtil;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid HistoricoDto historicoDto ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(objectMapperUtil
                        .map(historicoIService.saveHistorico(objectMapperUtil
                                .map(historicoDto, Historico.class)), ReclamacaoPostDto.class));
    }

    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable ("id") Long id) {
        historicoIService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid HistoricoPutRequestDto historicoPutRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(objectMapperUtil
                        .map(historicoIService.updateHistorico(objectMapperUtil.map(historicoPutRequestDto, Historico.class)), HistoricoDto.class));
    }
}