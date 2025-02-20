package br.com.urbanflow.avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDto {
    @JsonProperty("nota")
    @NotNull(message = "Nota não pode ser vazia")
    private Integer nota;

    @JsonProperty("dataAvaliacao")
    @NotNull(message = "Data da Avaliacao não pode ser vazia")
    private LocalDate dataAvaliacao;

    @JsonProperty("comentario")
    @NotNull(message = "Comentario não pode ser vazio")
    private String comentario;
}
