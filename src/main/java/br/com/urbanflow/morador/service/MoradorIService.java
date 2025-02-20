package br.com.urbanflow.morador.service;

import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.usuario.dto.UsuarioPutRequestDto;
import br.com.urbanflow.usuario.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MoradorIService {
    Page<Morador> findAll(Pageable pageable);
    Morador findById(Long id);
    Morador save(Morador morador);
    void delete(String cpf);
    Morador update(Morador morador);
}
