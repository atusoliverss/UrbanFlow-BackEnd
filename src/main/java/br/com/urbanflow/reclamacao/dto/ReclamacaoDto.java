package br.com.urbanflow.reclamacao.dto;

import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReclamacaoDto {
    @JsonProperty("descricao")
    @NotNull(message = "descricao não pode ser vazia")
    private String descricao;

    @JsonProperty("dataReclacao")
    @NotNull(message = "data da reclamacao não pode ser vazia")
    private LocalDate dataReclamacao;

    @JsonProperty("status")
    @NotNull(message = "status não pode ser vazio")
    private StatusReclamacao status;

    @JsonProperty("evidencia")
    @NotNull(message = "evidencia não pode ser vazia")
    private byte[] evidencia;

    @JsonProperty("servico")
    @NotNull(message = "servico não pode ser vazio")
    @Valid
    private ServicoPublico servicoPublico;
}
