
package br.com.urbanflow.endereco.service;

import br.com.urbanflow.endereco.entity.Endereco;
import br.com.urbanflow.endereco.repository.EnderecoIRepository;
import java.util.List;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EnderecoService implements EnderecoIService{
    private final EnderecoIRepository enderecoRepository; // Injeta o repositório de enderecos.
//CRUD ALUNOS
    @Override
    @Transactional
    public Endereco save(Endereco endereco){
            return enderecoRepository.save(endereco); // Salva o endereco no repositório.
    }

    @Override
    @Transactional
    public Endereco update(Endereco endereco){
            return enderecoRepository.save(endereco); // Atualiza o endereco no repositório.
    }

    @Override
    @Transactional
    public void delete(Endereco endereco){
        enderecoRepository.delete(endereco); // Deleta o endereco do repositório.
    }

    @Override
    public Endereco findById(Long id){
        return enderecoRepository.findById(id).orElseThrow(() -> new BusinessException("Endereço de id " + id + " não encontrado")); // Busca o endereco no repositório pelo ID.
    }

    @Override
    public List<Endereco> findAll(){
        return enderecoRepository.findAll(); // Busca todos os enderecos no repositório.
    }
}
