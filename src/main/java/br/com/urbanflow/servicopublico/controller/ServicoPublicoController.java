package br.com.urbanflow.servicopublico.controller;

import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import br.com.urbanflow.servicopublico.dto.ServicoPublicoGetResponseDto;
import br.com.urbanflow.servicopublico.service.ServicoPublicoIService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/servicos")
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoPublicoController {
    private final ServicoPublicoIService servicoPublicoService;
    private final ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ServicoPublicoGetResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicoPublicoService.findAll(pageable).map(c -> objectMapperUtil.map(c, ServicoPublicoGetResponseDto.class)));
    }

    @GetMapping(path = "/findbynome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByNome(@PathVariable(value = "nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(objectMapperUtil.map(this.servicoPublicoService.findByNome(nome), ServicoPublicoGetResponseDto.class));
    }
}
