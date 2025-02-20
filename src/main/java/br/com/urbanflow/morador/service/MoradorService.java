package br.com.urbanflow.morador.service;

import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.morador.repository.MoradorIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoradorService implements MoradorIService{
    private final MoradorIRepository moradorRepository;

    @Override
    public Page<Morador> findAll(Pageable pageable) {
        return moradorRepository.findAll(pageable);
    }

    @Override
    public Morador findById(Long id) {
        return moradorRepository.findById(id).orElseThrow(() -> new BusinessException("Morador não encontrado"));
    }

    @Override
    @Transactional
    public Morador save(Morador morador) {
        return moradorRepository.save(morador);
    }

    @Override
    public void delete(String cpf) {
        Morador morador = moradorRepository.findByCpf(cpf).orElseThrow(() -> new BusinessException("Morador não encontrado"));
        moradorRepository.delete(morador);
    }

    @Override
    public Morador update(Morador morador) {
        return moradorRepository.save(morador);
    }
}
