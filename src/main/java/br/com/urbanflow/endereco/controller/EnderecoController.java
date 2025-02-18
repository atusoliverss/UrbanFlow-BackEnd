
package br.com.urbanflow.endereco.controller;

import br.com.urbanflow.endereco.service.EnderecoIService;
import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enderecos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class EnderecoController{
    private final EnderecoIService enderecoService; // Injeta o serviço de enderecos.
    private final ObjectMapperUtil objectMapperUtil;
}
