package br.com.urbanflow.usuario.tipo.morador.entities;

import br.com.urbanflow.endereco.entity.Endereco;
import br.com.urbanflow.usuario.entities.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "morador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Morador extends Usuario implements Serializable {
    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "fk_endereco", nullable = false)
    private Endereco endereco;
}

