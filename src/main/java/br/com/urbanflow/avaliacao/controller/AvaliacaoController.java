package br.com.urbanflow.avaliacao.controller;

import br.com.urbanflow.avaliacao.dto.AvaliacaoDto;
import br.com.urbanflow.avaliacao.entities.Avaliacao;
import br.com.urbanflow.avaliacao.service.AvaliacaoIService;
import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/avaliacoes")
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AvaliacaoController {
    private final AvaliacaoIService avaliacaoService;
    private final ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AvaliacaoDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.avaliacaoService.findAll(pageable).map(c -> objectMapperUtil.map(c, AvaliacaoDto.class)));
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid AvaliacaoDto avaliacaoDto ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(avaliacaoService.save(objectMapperUtil.map(avaliacaoDto, Avaliacao.class)), AvaliacaoDto.class));
    }

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestBody @Valid AvaliacaoDto avaliacaoDto) {
        avaliacaoService.delete(objectMapperUtil.map(avaliacaoDto, Avaliacao.class));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid AvaliacaoDto avaliacaoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(avaliacaoService.update(objectMapperUtil.map(avaliacaoDto, Avaliacao.class)), AvaliacaoDto.class));
    }
}
