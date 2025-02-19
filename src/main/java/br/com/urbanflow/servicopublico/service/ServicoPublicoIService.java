package br.com.urbanflow.servicopublico.service;

import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicoPublicoIService {
    Page<ServicoPublico> findAll(Pageable pageable);
    ServicoPublico findByNome(String nome);
}
