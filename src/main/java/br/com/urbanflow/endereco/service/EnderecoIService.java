
package br.com.urbanflow.endereco.service;

import br.com.urbanflow.endereco.entity.Endereco;

import java.util.List;

public interface EnderecoIService {
    Endereco save(Endereco endereco) throws RuntimeException;
    Endereco update(Endereco endereco) throws RuntimeException;
    void delete(Endereco endereco) throws RuntimeException;
    Endereco findById(Long id) throws RuntimeException;
    List<Endereco> findAll() throws RuntimeException;
}