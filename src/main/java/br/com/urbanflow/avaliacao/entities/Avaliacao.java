package br.com.urbanflow.avaliacao.entities;

import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import br.com.urbanflow.morador.entities.Morador;
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
@Table(name = "avaliacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao extends PersistenceEntity implements Serializable {

    @Column(nullable = false)
    private Integer nota;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDate dataAvaliacao;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "fk_servico_publico", nullable = false)
    private ServicoPublico servicoPublico;

    @ManyToOne
    @JoinColumn(name = "fk_morador", nullable = false)
    private Morador morador;
}

