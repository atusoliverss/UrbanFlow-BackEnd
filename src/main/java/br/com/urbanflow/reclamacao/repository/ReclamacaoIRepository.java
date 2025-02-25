package br.com.urbanflow.reclamacao.repository;

import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReclamacaoIRepository extends JpaRepository<Reclamacao, Long> {
    Page<Reclamacao> findByStatus(StatusReclamacao status, Pageable pageable);  // Método para filtrar por status
}
