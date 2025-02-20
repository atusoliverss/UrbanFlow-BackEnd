package br.com.urbanflow.historico.dto;

import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoPutRequestDto {
    @JsonProperty("status")
    @NotNull(message = "status não pode ser vazio")
    private StatusReclamacao status;
}
