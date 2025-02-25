package br.com.urbanflow.reclamacao.dto;

import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReclamacaoPostDto {
    @JsonProperty("descricao")
    @NotNull(message = "descricao não pode ser vazia")
    private String descricao;

    @JsonProperty("dataReclamacao")
    @NotNull(message = "data da reclamacao não pode ser vazia")
    private LocalDate dataReclamacao;

    @JsonProperty("status")
    @NotNull(message = "status não pode ser vazio")
    private StatusReclamacao status;

//    @JsonProperty("evidencia")
    ////@NotNull(message = "evidencia não pode ser vazia")
    ////private byte[] evidencia;

    @JsonProperty("morador")
    @NotNull(message = "evidencia não pode ser vazia")
    private String emailMorador;

    @JsonProperty("servico")
    @NotNull(message = "servico não pode ser vazio")
    private String nomeServicoPublico;
}
