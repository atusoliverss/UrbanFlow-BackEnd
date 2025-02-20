package br.com.urbanflow.historico.service;

import br.com.urbanflow.historico.entities.Historico;
import br.com.urbanflow.historico.repository.HistoricoIRepository;
import br.com.urbanflow.infrastructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HistoricoService implements HistoricoIService{
    private final HistoricoIRepository historicoIRepository;

    @Override
    @Transactional
    public Historico saveHistorico(Historico historico){
        try{
            log.info("Criando histórico");
            return historicoIRepository.save(historico);
        }catch (BusinessException e){
            log.error("Erro ao criar um historico");
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Historico findHistoricosById(Long id) {
        try{
            log.info("Buscando Historico via Id");
            return historicoIRepository.findHistoricoById(id);
        } catch (BusinessException e) {
            log.error("Erro ao buscar Historico");
            throw new BusinessException(e);
        }
    }

    @Override
    @Transactional
    public Historico updateHistorico(Historico historico){
        if (!this.historicoIRepository.existsById(historico.getId())) {
            log.warn("Nenhum Historico encontrado com o ID: {}", historico.getId());
            throw new BusinessException("Nenhum Historico encontrado");
        }
        try {
            log.info("Atualizando Historico");
            return historicoIRepository.save(historico);
        } catch (Exception e) {
            log.error("Erro ao atualizar Historico");
            throw new RuntimeException(e);
        }
    }
}