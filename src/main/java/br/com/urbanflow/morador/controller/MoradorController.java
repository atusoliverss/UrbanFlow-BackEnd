package br.com.urbanflow.morador.controller;

import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import br.com.urbanflow.morador.dto.MoradorDto;
import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.morador.mapper.MoradorMapper;
import br.com.urbanflow.morador.service.MoradorIService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/moradores")
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MoradorController {
    private final MoradorIService moradorService;
    private final ObjectMapperUtil objectMapperUtil;
    private final MoradorMapper moradorMapper;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<MoradorDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.moradorService.findAll(pageable).map(c -> objectMapperUtil.map(c, MoradorDto.class)));
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid MoradorDto moradorDto) {
        Morador morador = moradorMapper.toEntity(moradorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(moradorMapper.toDto(moradorService.save(morador)));
    }


    @DeleteMapping(path = "/delete/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("cpf") String cpf) {
        moradorService.delete(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid MoradorDto morador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(moradorService.update(objectMapperUtil.map(morador, Morador.class)), MoradorDto.class));
    }
}
