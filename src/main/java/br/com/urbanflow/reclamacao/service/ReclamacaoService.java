package br.com.urbanflow.reclamacao.service;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import br.com.urbanflow.reclamacao.repository.ReclamacaoIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReclamacaoService implements ReclamacaoIService {
    private final ReclamacaoIRepository reclamacaoIRepository;
    @Override
    public Reclamacao save(Reclamacao reclamacao) {
        return reclamacaoIRepository.save(reclamacao);
    }

    @Override
    public void delete(Reclamacao reclamacao) {
        reclamacaoIRepository.delete(reclamacao);
    }

    @Override
    public Reclamacao update(Reclamacao reclamacao) {
        return reclamacaoIRepository.save(reclamacao);
    }

    @Override
    public Page<Reclamacao> findAll(Pageable pageable) {
        return reclamacaoIRepository.findAll(pageable);
    }
}
