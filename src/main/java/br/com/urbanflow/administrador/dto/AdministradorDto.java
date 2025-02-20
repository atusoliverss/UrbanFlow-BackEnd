package br.com.urbanflow.administrador.dto;

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
public class AdministradorDto {
    @JsonProperty("usuario")
    @Valid
    private UsuarioPostRequestDto usuario;

    @JsonProperty("cnpj")
    @NotNull
    private String cnpj;

    @JsonProperty("cargo")
    @NotNull
    private String cargo;

    @JsonProperty("servico")
    @NotNull
    private String servico;
}
