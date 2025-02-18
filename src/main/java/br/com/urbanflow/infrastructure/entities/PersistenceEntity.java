package br.com.urbanflow.infrastructure.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass //Indica que esta classe não será mapeada diretamente para uma tabela de banco de dados, mas suas propriedades serão herdadas por subclasses que serão mapeadas para tabelas.
@Data //Anotação do Lombok que gera automaticamente métodos getters, setters, equals, hashCode e toString, além de um construtor para todos os campos finais.
public class PersistenceEntity {
    // Declaração do campo que representa a chave primária da entidade
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Define a estratégia de geração automática do valor do ID
    private Long id; // Campo que armazena o ID da entidade
}
