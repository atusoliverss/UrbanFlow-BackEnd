package br.com.urbanflow.administrador.service;

import br.com.urbanflow.administrador.dto.AdministradorDto;
import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.administrador.mapper.AdministradorMapper;
import br.com.urbanflow.administrador.repository.AdministradorIRepository;
import br.com.urbanflow.infrastructure.exception.BusinessException;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.servicopublico.repository.ServicoPublicoIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministradorService implements AdministradorIService{

    private final AdministradorIRepository repository;
    private final ServicoPublicoIRepository servicoPublicoRepository;
    private final AdministradorMapper administradorMapper;

    @Override
    public Page<Administrador> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Administrador findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Administrador não encontrado"));
    }

    @Override
    public Administrador save(AdministradorDto administradorDto) {
        // Verificar se o serviço já existe no banco
        ServicoPublico servico = servicoPublicoRepository.findByNome(administradorDto.getServico()).orElseThrow(() -> new BusinessException("Serviço Publico não encontrado"));

        Administrador administrador = administradorMapper.toEntity(administradorDto, servico);

        return repository.save(administrador);
    }

    @Override
    public void delete(String cnpj) {
        Administrador administrador = repository.findByCnpj(cnpj).orElseThrow(() -> new BusinessException("Administrador não encontrado"));
        repository.delete(administrador);
    }

    @Override
    public Administrador update(Administrador administrador) {
        return repository.save(administrador);
    }
}
