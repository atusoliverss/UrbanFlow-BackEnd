package br.com.urbanflow.administrador.mapper;

import br.com.urbanflow.administrador.dto.AdministradorDto;
import br.com.urbanflow.administrador.dto.AdministradorGetDto;
import br.com.urbanflow.administrador.entities.Administrador;
import br.com.urbanflow.servicopublico.dto.ServicoDto;
import br.com.urbanflow.servicopublico.entities.ServicoPublico;
import br.com.urbanflow.usuario.dto.UsuarioGetResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AdministradorMapper {

    public Administrador toEntity(AdministradorDto dto, ServicoPublico servico) {
        Administrador administrador = new Administrador();

        // Convertendo UsuarioPostRequestDto para Usuario
        administrador.setNome(dto.getUsuario().getNome());
        administrador.setEmail(dto.getUsuario().getEmail());
        administrador.setTelefone(dto.getUsuario().getTelefone());
        administrador.setDataNascimento(dto.getUsuario().getDataNascimento());
        administrador.setSenha(dto.getUsuario().getSenha());
        administrador.setTipo(dto.getUsuario().getTipo());

        // Setando CNPJ, Cargo e Serviço
        administrador.setCnpj(dto.getCnpj());
        administrador.setCargo(dto.getCargo());
        administrador.setServicoPublico(servico); // Associando o serviço existente

        return administrador;
    }

    public AdministradorGetDto toDto(Administrador administrador) {
        UsuarioGetResponseDto usuarioDto = new UsuarioGetResponseDto(
                administrador.getNome(),
                administrador.getEmail(),
                administrador.getTelefone(),
                administrador.getDataNascimento(),
                administrador.getTipo()
        );

        ServicoDto servicoDto = new ServicoDto(
                administrador.getServicoPublico().getNome()
        );

        return new AdministradorGetDto(usuarioDto, administrador.getCnpj(), administrador.getCargo(), servicoDto.getNome());
    }
}


