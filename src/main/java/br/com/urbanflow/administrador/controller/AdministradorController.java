package br.com.urbanflow.administrador.controller;

import br.com.urbanflow.administrador.dto.AdministradorDto;
import br.com.urbanflow.administrador.dto.AdministradorGetDto;
import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.administrador.mapper.AdministradorMapper;
import br.com.urbanflow.administrador.service.AdministradorIService;
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
@RequestMapping(path = "/administradores")
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdministradorController {
    private final AdministradorIService administradorService;
    private final AdministradorMapper administradorMapper;
    private final ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AdministradorGetDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.administradorService.findAll(pageable).map(administradorMapper::toDto));
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid AdministradorDto administradorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorMapper.toDto(administradorService.save(administradorDto)));

    }


    @DeleteMapping(path = "/delete/{cnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("cnpj") String cnpj) {
        administradorService.delete(cnpj);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid AdministradorDto administradorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(administradorService.update(objectMapperUtil.map(administradorDto, Administrador.class)), AdministradorDto.class));
    }
}
