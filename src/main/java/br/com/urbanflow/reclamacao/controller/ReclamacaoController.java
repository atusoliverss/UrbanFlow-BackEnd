package br.com.urbanflow.reclamacao.controller;

import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import br.com.urbanflow.reclamacao.dto.ReclamacaoPostDto;
import br.com.urbanflow.reclamacao.dto.ReclamacaoPutRequestDto;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.mapper.ReclamacaoMapper;
import br.com.urbanflow.reclamacao.service.ReclamacaoIService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reclamacoes")
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReclamacaoController {

    private final ReclamacaoIService reclamacaoService;
    private final ObjectMapperUtil objectMapperUtil;
    private final ReclamacaoMapper reclamacaoMapper;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ReclamacaoPostDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.reclamacaoService.findAll(pageable).map(c -> objectMapperUtil.map(c, ReclamacaoPostDto.class)));
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid ReclamacaoPostDto reclamacaoPostDto) {
        Reclamacao reclamacao = reclamacaoMapper.toEntity(reclamacaoPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamacaoMapper.toDto(reclamacaoService.save(reclamacao)));
    }

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestBody @Valid ReclamacaoPostDto reclamacaoPostDto) {
        reclamacaoService.delete(objectMapperUtil.map(reclamacaoPostDto, Reclamacao.class));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid ReclamacaoPutRequestDto reclamacaoPutDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(reclamacaoService.update(objectMapperUtil.map(reclamacaoPutDto, Reclamacao.class)), ReclamacaoPostDto.class));
    }
}
