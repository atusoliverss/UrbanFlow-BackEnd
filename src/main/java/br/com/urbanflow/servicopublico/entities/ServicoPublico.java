package br.com.urbanflow.servicopublico.entities;

import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "servico_publico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPublico extends PersistenceEntity implements Serializable {

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 100)
    private String categoria;

    @OneToMany(mappedBy = "servicoPublico")
    private List<Administrador> administradores;
}

