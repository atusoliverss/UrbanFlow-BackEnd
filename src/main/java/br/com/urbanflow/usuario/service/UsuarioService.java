package br.com.urbanflow.usuario.service;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.usuario.dto.UsuarioPutRequestDto;
import br.com.urbanflow.usuario.entities.Usuario;
import br.com.urbanflow.usuario.repository.UsuarioIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe de serviço responsável pela lógica de negócios relacionada à entidade {@link Usuario}.
 * Implementa a interface {@link UsuarioIService}.
 */
@Service
@RequiredArgsConstructor // Gera um construtor automaticamente para os atributos finais (final).
public class UsuarioService implements UsuarioIService {

    // Repositório responsável pela persistência dos usuários.
    private final UsuarioIRepository usuarioIRepository;

    /**
     * Retorna uma lista de todos os usuários cadastrados.
     *
     * @return Lista de usuários.
     */
    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioIRepository.findAll(pageable);
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id Identificador do usuário.
     * @return Usuário encontrado.
     * @throws BusinessException Caso o ID não seja encontrado.
     */
    @Override
    public Usuario findById(Long id) {
        return usuarioIRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Id não encontrado"));
    }

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param usuario Objeto usuário a ser salvo.
     * @return Usuário salvo.
     */

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioIRepository.save(usuario);
    }

    /**
     * Exclui um usuário pelo ID.
     *
     * @param email Email do usuário a ser excluído.
     */
    @Transactional
    @Override
    public void delete(String email) {
        Usuario usuario = usuarioIRepository.findByEmail(email).orElseThrow(() -> new BusinessException("Usuário de email" + email +" não encontrado"));
        usuarioIRepository.deleteById(usuario.getId());
    }


    /**
     * Atualiza um usuário existente no banco de dados com os novos dados fornecidos.
     *
     * @param user Objeto UsuarioPutRequestDto contendo as novas informações do usuário.
     * @return O usuário atualizado após a persistência no banco de dados.
     * @throws BusinessException Se o usuário com o email fornecido não for encontrado.
     */
    @Transactional
    @Override
    public Usuario update(UsuarioPutRequestDto user) {
        // Busca o usuário no banco de dados pelo email fornecido
        Usuario usuarioFound = usuarioIRepository.findByEmail(user.getEmail()).orElseThrow(() -> new BusinessException("Usuário de email" + user.getEmail() +" não encontrado"));

        // Verifica se o usuário foi encontrado
        if (usuarioFound != null) {
            // Atualiza os dados do usuário encontrado com as novas informações
            usuarioFound.setNome(user.getNome());

            // Salva o usuário atualizado no banco de dados
            return usuarioIRepository.save(usuarioFound);
        }

        // Lança uma exceção caso o usuário não seja encontrado
        throw new BusinessException("Usuário com Email: " + user.getEmail() + " não encontrado");
    }

    /**
     * Busca um usuário pelo email.
     *
     * @param email O email do usuário.
     * @return Um Optional contendo o usuário, caso exista.
     */
    @Override
    public Usuario findByEmail(String email) {
        return usuarioIRepository.findByEmail(email).orElseThrow(() -> new BusinessException("Usuário de email" + email +" não encontrado"));
    }

    /**
     * Busca um usuário pelo email e senha.
     *
     * @param email    O email do usuário.
     * @param senha A senha do usuário.
     * @return Um Optional contendo o usuário, caso as credenciais estejam corretas.
     */
    @Override
    public Usuario findByEmailAndSenha(String email, String senha) {
        return usuarioIRepository.findByEmailAndSenha(email, senha).orElseThrow(() -> new BusinessException("Usuário não encontrado"));
    }

}
