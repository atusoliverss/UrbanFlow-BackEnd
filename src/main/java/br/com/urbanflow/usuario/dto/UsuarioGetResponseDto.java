package br.com.urbanflow.usuario.dto;

import br.com.urbanflow.usuario.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetResponseDto {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("dataNascimento")
    private Date dataNascimento;
}
