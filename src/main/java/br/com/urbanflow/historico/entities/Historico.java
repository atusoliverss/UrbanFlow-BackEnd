package br.com.urbanflow.historico.entities;

import br.com.urbanflow.historico.enums.StatusHistorico;
import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "historico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historico extends PersistenceEntity implements Serializable {

    @Column(nullable = false, length = 50)
    private StatusHistorico status;

    @Column(nullable = false)
    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_reclamacao", nullable = false)
    private Reclamacao reclamacao;
}
