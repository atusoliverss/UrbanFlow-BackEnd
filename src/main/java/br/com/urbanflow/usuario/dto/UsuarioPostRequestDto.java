package br.com.urbanflow.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDto {
    @JsonProperty("nome")
    @NotBlank(message = "nome não pode ser vazio")
    @NotNull(message = "nome é obrigatório")
    private String nome;

    @JsonProperty("email")
    @Email(message = "email inválido")
    private String email;

    @JsonProperty("senha")
    @NotBlank(message = "senha não pode ser vazio")
    @NotNull(message = "senha é obrigatório")
    private String senha;

    @NotBlank(message = "telefone não pode ser vazio")
    @NotNull(message = "telefone é obrigatório")
    @JsonProperty("telefone")
    private String telefone;

    @NotBlank(message = "tipo não pode ser vazio")
    @NotNull(message = "tipo é obrigatório")
    @JsonProperty("tipo")
    private String tipo;

    @NotNull(message = "data nascimento é obrigatório")
    @JsonProperty("dataNascimento")
    private Date dataNascimento;

}
