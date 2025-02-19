package br.com.urbanflow.servicopublico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPublicoGetResponseDto {
    @JsonProperty("nome")
    @NotNull(message = "nome não pode ser vazio")
    private String nome;

    @JsonProperty("descricao")
    @NotNull(message = "descricao não pode ser vazio")
    private String descricao;

    @JsonProperty("categoria")
    @NotNull(message = "categoria não pode ser vazio")
    private String categoria;
}
