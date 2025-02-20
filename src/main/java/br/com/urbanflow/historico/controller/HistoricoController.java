package br.com.urbanflow.historico.controller;

import br.com.urbanflow.historico.service.HistoricoIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/historico")
@RequiredArgsConstructor
public class HistoricoController {
    private final HistoricoIService historicoIService;


}
