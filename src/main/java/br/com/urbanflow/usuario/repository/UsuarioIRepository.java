package br.com.urbanflow.usuario.repository;

import br.com.urbanflow.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioIRepository extends JpaRepository<Usuario, Long> {
    //@Query("select u from Usuario u where u.login = ?1")
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    Optional<Usuario> findByTelefone(String telefone);
}
