package br.com.urbanflow.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPutRequestDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @Email(message = "Invalid email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;
}
