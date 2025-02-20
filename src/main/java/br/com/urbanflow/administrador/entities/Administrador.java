package br.com.urbanflow.administrador.entities;

import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.usuario.entities.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador extends Usuario implements Serializable {

    @Column(name = "cnpj", length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private ServicoPublico servicoPublico;

}
