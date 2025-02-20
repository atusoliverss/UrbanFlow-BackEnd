package br.com.urbanflow.administrador.repository;

import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.morador.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorIRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByCnpj(String cnpj);
}
