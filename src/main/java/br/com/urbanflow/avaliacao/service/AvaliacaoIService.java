package br.com.urbanflow.avaliacao.service;

import br.com.urbanflow.avaliacao.entities.Avaliacao;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AvaliacaoIService {
    Avaliacao save(Avaliacao avaliacao);
    void delete(Avaliacao avaliacao);
    Avaliacao update(Avaliacao avaliacao);
    Page<Avaliacao> findAll(Pageable pageable);
}

