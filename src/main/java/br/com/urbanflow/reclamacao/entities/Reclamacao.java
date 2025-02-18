package br.com.urbanflow.reclamacao.entities;

import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reclamacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamacao extends PersistenceEntity implements Serializable {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_reclamacao", nullable = false)
    private LocalDate dataReclamacao;

    @Column(nullable = false, length = 50)
    private String status;

    @Lob
    private byte[] evidencia;

    @ManyToOne
    @JoinColumn(name = "fk_servico_publico", nullable = false)
    private ServicoPublico servicoPublico;
}
