package br.com.urbanflow.morador.repository;

import br.com.urbanflow.morador.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoradorIRepository extends JpaRepository<Morador, Long> {
    Optional<Morador> findByCpf(String cpf);
}
