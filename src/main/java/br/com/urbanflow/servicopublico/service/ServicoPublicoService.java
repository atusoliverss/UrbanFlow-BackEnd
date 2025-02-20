package br.com.urbanflow.servicopublico.service;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.servicopublico.repository.ServicoPublicoIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicoPublicoService implements ServicoPublicoIService{
    private final ServicoPublicoIRepository repository;
    @Override
    public Page<ServicoPublico> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ServicoPublico findByNome(String nome) {
        return repository.findByNome(nome).orElseThrow(() -> new BusinessException("Serviço Público " + nome + " não encontrado"));
    }
}
