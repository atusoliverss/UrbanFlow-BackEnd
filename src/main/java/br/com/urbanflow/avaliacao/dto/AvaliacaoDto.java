package br.com.urbanflow.avaliacao.dto;

import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
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

    @JsonProperty("morador")
    @NotNull(message = "evidencia não pode ser vazia")
    private String emailMorador;

    @JsonProperty("servico")
    @NotNull(message = "servico não pode ser vazio")
    private String nomeServicoPublico;
}
