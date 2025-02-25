package br.com.urbanflow.reclamacao.mapper;

import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.morador.service.MoradorIService;
import br.com.urbanflow.reclamacao.dto.ReclamacaoPostDto;
import br.com.urbanflow.reclamacao.entities.Reclamacao;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.servicopublico.service.ServicoPublicoIService;
import br.com.urbanflow.usuario.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReclamacaoMapper {

    private final ServicoPublicoIService servicoPublicoIService;
    private final UsuarioIService usuarioIService;
    private final MoradorIService moradorIService;

    public Reclamacao toEntity(ReclamacaoPostDto dto){
        Reclamacao reclamacao = new Reclamacao();
        reclamacao.setDataReclamacao(dto.getDataReclamacao());
        reclamacao.setStatus(dto.getStatus());
        reclamacao.setDescricao(dto.getDescricao());

        Morador morador = moradorIService.findById(usuarioIService.findByEmail(dto.getEmailMorador()).getId());
        reclamacao.setMorador(morador);

        ServicoPublico servicoPublico = servicoPublicoIService.findByNome(dto.getNomeServicoPublico());
        reclamacao.setServicoPublico(servicoPublico);

        return reclamacao;
    }

    public ReclamacaoPostDto toDto(Reclamacao reclamacao){
        ReclamacaoPostDto dto = new ReclamacaoPostDto();
        dto.setDataReclamacao(reclamacao.getDataReclamacao());
        dto.setDescricao(reclamacao.getDescricao());
        dto.setStatus(reclamacao.getStatus());
        dto.setNomeServicoPublico(reclamacao.getServicoPublico().getNome());
        dto.setEmailMorador(reclamacao.getMorador().getEmail());
        return dto;
    }
}
