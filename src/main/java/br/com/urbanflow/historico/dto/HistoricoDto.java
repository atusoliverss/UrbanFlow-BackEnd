package br.com.urbanflow.historico.dto;

import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.historico.enums.StatusHistorico;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDto {
    @JsonProperty("status")
    @NotNull(message = "status não pode ser vazio")
    private StatusHistorico status;

    @JsonProperty("data")
    @NotNull(message = "data não pode ser vazia")
    private LocalDate data;

    @JsonProperty("descricao")
    @NotNull(message = "descricao não pode ser vazia")
    private String descricao;

    @JsonProperty("administrador")
    @NotNull(message = "administrador não pode ser vazio")
    private Administrador administrador;
}
