package br.com.urbanflow.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPutRequestDto {
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    @Email(message = "email inválido")
    private String email;

    @JsonProperty("telefone")
    private String telefone;
}
