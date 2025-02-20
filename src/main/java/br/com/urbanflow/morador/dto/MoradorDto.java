package br.com.urbanflow.morador.dto;

import br.com.urbanflow.endereco.dto.EnderecoDto;
import br.com.urbanflow.usuario.dto.UsuarioPostRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoradorDto {
    @JsonProperty("usuario")
    @Valid
    private UsuarioPostRequestDto usuario;

    @NotBlank(message = "cpf não pode ser vazio")
    @NotNull(message = "cpf é obrigatório")
    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("endereco")
    @Valid
    private EnderecoDto endereco;
}
