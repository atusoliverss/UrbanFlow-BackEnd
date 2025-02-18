package br.com.urbanflow.usuario.dto;

import br.com.urbanflow.usuario.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDto {
    @JsonProperty("name")
    @NotBlank(message = "The name cannot be empty")
    @NotNull(message = "The name is mandatory")
    private String name;

    @JsonProperty("login")
    @NotBlank(message = "The login cannot be empty")
    @NotNull(message = "The login is mandatory")
    @Size(min = 3, max = 30, message = "Login must have a minimum of 3 characters and a maximum of 30 characters")
    private String login;

    @JsonProperty("email")
    @Email(message = "Invalid email")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "The password cannot be empty")
    @NotNull(message = "The password is mandatory")
    private String password;

    @NotNull
    @NotBlank
    @JsonProperty("telefone")
    private String telefone;

    @NotNull
    @JsonProperty("dataNascimento")
    private Date dataNascimento;

    @NotNull
    @NotBlank
    @JsonProperty("tipo")
    private TipoUsuario tipoUsuario;
}
