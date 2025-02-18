package br.com.urbanflow.usuario.entities;

import br.com.urbanflow.infrastructure.entities.PersistenceEntity;
import br.com.urbanflow.usuario.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity // Indica que esta classe é uma entidade JPA, representando uma tabela no banco de dados.
@Table(name = "usuario") // Especifica o nome da tabela associada a esta entidade.
@Data // Lombok: Gera automaticamente getters, setters, toString, equals e hashCode.
@AllArgsConstructor // Lombok: Gera um construtor com todos os atributos da classe.
@NoArgsConstructor // Lombok: Gera um construtor vazio.
@EqualsAndHashCode(callSuper = false) // Lombok: Configura o método equals e hashCode, ignorando atributos da classe pai.
@Builder
public class Usuario extends PersistenceEntity { // A classe Usuario herda atributos e comportamentos de PersistenceEntity.

    @Column(name = "name", nullable = false) // Indica que a coluna "name" não pode ser nula no banco de dados.
    private String name;

    @Column(name = "email",nullable = false, unique = true) // Indica que a coluna "email" não pode ser nula.
    private String email;

    @Column(name = "telefone", nullable = false, unique = true)
    private String telefone;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "senha",nullable = false) // Indica que a coluna "senha" não pode ser nula.
    private String senha;
}
