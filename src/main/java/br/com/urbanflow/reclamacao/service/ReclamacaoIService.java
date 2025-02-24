package br.com.urbanflow.reclamacao.service;

import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReclamacaoIService {
    Reclamacao save(Reclamacao reclamacao);
    void delete(Reclamacao reclamacao);
    Reclamacao update(Reclamacao reclamacao);
    Page<Reclamacao> findAll(Pageable pageable);
    Page<Reclamacao> findByStatus(StatusReclamacao status, Pageable pageable);  // Verifique se este método está na interface
}
