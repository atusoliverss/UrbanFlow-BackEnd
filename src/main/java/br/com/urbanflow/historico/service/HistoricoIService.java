package br.com.urbanflow.historico.service;

import br.com.urbanflow.historico.entities.Historico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoricoIService {
    Historico saveHistorico(Historico historico);
    //Historico findHistoricoById(Long id);
    Historico findHistoricosById(Long id);
    Historico updateHistorico(Historico historico);
    void deleteById(Long id);
}