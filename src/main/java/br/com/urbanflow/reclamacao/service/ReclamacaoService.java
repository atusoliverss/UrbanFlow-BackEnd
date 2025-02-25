package br.com.urbanflow.reclamacao.service;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.reclamacao.enums.StatusReclamacao;
import br.com.urbanflow.reclamacao.repository.ReclamacaoIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        if (!reclamacaoIRepository.existsById(reclamacao.getId())) {
            throw new BusinessException("Reclamação não encontrada.");
        }
        reclamacaoIRepository.delete(reclamacao);
    }

    @Override
    public Reclamacao update(Reclamacao reclamacao) {
        // Verificar status antes de realizar a atualização
        if (reclamacao.getStatus() == StatusReclamacao.FINALIZADA) {
            throw new BusinessException("Não é possível atualizar uma reclamação finalizada.");
        }
        return reclamacaoIRepository.save(reclamacao);
    }

    @Override
    public Page<Reclamacao> findAll(Pageable pageable) {
        return reclamacaoIRepository.findAll(pageable);
    }

    @Override
    public Page<Reclamacao> findByStatus(StatusReclamacao status, Pageable pageable) {
        return reclamacaoIRepository.findByStatus(status, pageable);
    }
}
