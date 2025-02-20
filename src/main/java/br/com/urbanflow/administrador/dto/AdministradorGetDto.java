package br.com.urbanflow.administrador.dto;

import br.com.urbanflow.usuario.dto.UsuarioGetResponseDto;
import br.com.urbanflow.usuario.dto.UsuarioPostRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorGetDto {
    @JsonProperty("usuario")
    private UsuarioGetResponseDto usuario;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("cargo")
    private String cargo;

    @JsonProperty("servico")
    private String servico;
}
