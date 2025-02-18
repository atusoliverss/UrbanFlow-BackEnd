
package br.com.urbanflow.endereco.entity;

import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="endereco")
public class Endereco extends PersistenceEntity {
    // Campos individuais
    @Column(nullable = false, length = 15)
    private String cep;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 200)
    private String logradouro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(length = 200)
    private String complemento;
}
