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
    @NotBlank(message = "The email cannot be empty")
    @NotNull(message = "The email is mandatory")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "The password cannot be empty")
    @NotNull(message = "The password is mandatory")
    private String password;
}
