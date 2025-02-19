package br.com.urbanflow.usuario.service;

import br.com.urbanflow.usuario.dto.UsuarioPutRequestDto;
import br.com.urbanflow.usuario.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioIService {
    Page<Usuario> findAll(Pageable pageable);
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void delete(String email);
    Usuario update(UsuarioPutRequestDto user);

    Usuario findByEmail(String email);
    Usuario findByEmailAndSenha(String email, String senha);
}
