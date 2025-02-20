package br.com.urbanflow.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginPostRequestDto {
    @JsonProperty("email")
    @NotBlank(message = "email não pode ser vazio")
    @NotNull(message = "email é obrigatório")
    private String email;

    @JsonProperty("senha")
    @NotBlank(message = "senha não pode ser vazio")
    @NotNull(message = "senha é obrigatório")
    private String senha;
}
