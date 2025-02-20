package br.com.urbanflow.historico.repository;

import br.com.urbanflow.historico.entities.Historico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoIRepository extends JpaRepository<Historico, Long> {
    Page<Historico> findHistoricoById(Long id, Pageable pageable);

    Historico findHistoricoById(Long id);
}
