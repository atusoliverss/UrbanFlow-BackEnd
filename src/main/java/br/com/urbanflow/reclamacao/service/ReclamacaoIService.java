package br.com.urbanflow.reclamacao.service;

import br.com.urbanflow.reclamacao.entities.Reclamacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.print.DocFlavor;

public interface ReclamacaoIService {
    Reclamacao save(Reclamacao reclamacao);
    void delete(Reclamacao reclamacao);
    Reclamacao update(Reclamacao reclamacao);
    Page<Reclamacao> findAll(Pageable pageable);
}

