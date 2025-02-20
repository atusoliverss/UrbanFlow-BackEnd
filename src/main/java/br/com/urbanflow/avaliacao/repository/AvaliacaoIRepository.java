package br.com.urbanflow.avaliacao.repository;

import br.com.urbanflow.avaliacao.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoIRepository extends JpaRepository<Avaliacao, Long> {
}
