package br.com.urbanflow.administrador.service;

import br.com.urbanflow.administrador.dto.AdministradorDto;
import br.com.urbanflow.administrador.entities.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdministradorIService {
    Page<Administrador> findAll(Pageable pageable);
    Administrador findById(Long id);
    Administrador save(AdministradorDto administrador);
    void delete(String cnpj);
    Administrador update(Administrador administrador);
}
