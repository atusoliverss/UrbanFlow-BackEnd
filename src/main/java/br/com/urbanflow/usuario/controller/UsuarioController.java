package br.com.urbanflow.usuario.controller;

import br.com.urbanflow.infrastructure.mapper.ObjectMapperUtil;
import br.com.urbanflow.usuario.dto.UsuarioGetResponseDto;
import br.com.urbanflow.usuario.dto.UsuarioLoginPostRequestDto;
import br.com.urbanflow.usuario.dto.UsuarioPostRequestDto;
import br.com.urbanflow.usuario.dto.UsuarioPutRequestDto;
import br.com.urbanflow.usuario.entities.Usuario;
import br.com.urbanflow.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta classe é um controlador REST, gerenciando requisições HTTP.
@RequestMapping(path = "/usuarios") // Define a base do caminho de todas as rotas deste controlador.
@RequiredArgsConstructor // Gera automaticamente um construtor com base nos atributos finais (final).
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    // Injeção de dependência do repositório de usuários.
    private final UsuarioService userService;
    private final ObjectMapperUtil objectMapperUtil;

    /**
     * Endpoint para buscar todos os usuários.
     * @return Lista de usuários no formato JSON, com status HTTP 200 (OK).
     */
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findAll(pageable).map(c -> objectMapperUtil.map(c, UsuarioGetResponseDto.class)));
    }

    /**
     * Endpoint para salvar um novo usuário.
     * @param user Objeto Usuario recebido no corpo da requisição no formato JSON.
     * @return O usuário salvo, com status HTTP 201 (Created).
     */
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid UsuarioPostRequestDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(userService.save(objectMapperUtil.map(user, Usuario.class)), UsuarioGetResponseDto.class));
    }

    /**
     * Endpoint para deletar um usuário pelo ID.
     * @param email ID do usuário a ser deletado, recebido como variável de caminho.
     * @return Resposta sem conteúdo (HTTP 204 - No Content) após a exclusão.
     */
    @DeleteMapping(path = "/delete/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("email") String email) {
        userService.delete(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Endpoint para atualizar um usuário existente.
     * @param user Objeto Usuario recebido no corpo da requisição no formato JSON.
     * @return O usuário atualizado, com status HTTP 200 (OK).
     */
    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody @Valid UsuarioPutRequestDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objectMapperUtil.map(userService.update(user), UsuarioGetResponseDto.class));
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody @Valid UsuarioLoginPostRequestDto loginUser) {
        Usuario usuario = userService.findByEmailAndSenha(loginUser.getEmail(), loginUser.getSenha());

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
        }

        return ResponseEntity.ok(objectMapperUtil.map(usuario, UsuarioGetResponseDto.class));
    }

}
