package br.com.urbanflow.servicopublico.repository;

import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoPublicoIRepository extends JpaRepository<ServicoPublico, Long> {
    Optional<ServicoPublico> findByNome(String nome);
}
