package br.com.urbanflow.avaliacao.service;

import br.com.urbanflow.avaliacao.entities.Avaliacao;
import br.com.urbanflow.avaliacao.repository.AvaliacaoIRepository;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.repository.ReclamacaoIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoService implements AvaliacaoIService {
    private final AvaliacaoIRepository avaliacaoIRepository;
    @Override
    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoIRepository.save(avaliacao);
    }

    @Override
    public void delete(Avaliacao avaliacao) {
        avaliacaoIRepository.delete(avaliacao);
    }

    @Override
    public Avaliacao update(Avaliacao avaliacao) {
        return avaliacaoIRepository.save(avaliacao);
    }

    @Override
    public Page<Avaliacao> findAll(Pageable pageable) {
        return avaliacaoIRepository.findAll(pageable);
    }
}
