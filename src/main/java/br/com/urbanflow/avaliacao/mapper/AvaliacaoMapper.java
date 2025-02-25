package br.com.urbanflow.avaliacao.mapper;

import br.com.urbanflow.avaliacao.dto.AvaliacaoDto;
import br.com.urbanflow.avaliacao.entities.Avaliacao;
import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.morador.service.MoradorIService;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.servicopublico.service.ServicoPublicoIService;
import br.com.urbanflow.usuario.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AvaliacaoMapper {

    private final ServicoPublicoIService servicoPublicoIService;
    private final UsuarioIService usuarioIService;
    private final MoradorIService moradorIService;

    public Avaliacao toEntity(AvaliacaoDto dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setDataAvaliacao(dto.getDataAvaliacao());
        avaliacao.setComentario(dto.getComentario());

        Morador morador = moradorIService.findById(usuarioIService.findByEmail(dto.getEmailMorador()).getId());
        avaliacao.setMorador(morador);

        ServicoPublico servicoPublico = servicoPublicoIService.findByNome(dto.getNomeServicoPublico());
        avaliacao.setServicoPublico(servicoPublico);

        return avaliacao;
    }

    public AvaliacaoDto toDto(Avaliacao avaliacao) {
        AvaliacaoDto dto = new AvaliacaoDto();
        dto.setNota(avaliacao.getNota());
        dto.setDataAvaliacao(avaliacao.getDataAvaliacao());
        dto.setComentario(avaliacao.getComentario());
        dto.setNomeServicoPublico(avaliacao.getServicoPublico().getNome());
        dto.setEmailMorador(avaliacao.getMorador().getEmail());
        return dto;
    }
}
