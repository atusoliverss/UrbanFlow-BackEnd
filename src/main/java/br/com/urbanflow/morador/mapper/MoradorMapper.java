package br.com.urbanflow.morador.mapper;

import br.com.urbanflow.endereco.dto.EnderecoDto;
import br.com.urbanflow.endereco.entity.Endereco;
import br.com.urbanflow.morador.dto.MoradorDto;
import br.com.urbanflow.morador.entities.Morador;
import br.com.urbanflow.usuario.dto.UsuarioPostRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MoradorMapper {
    public Morador toEntity(MoradorDto dto) {
        Morador morador = new Morador();

        // Convertendo UsuarioPostRequestDto para Usuario
        morador.setNome(dto.getUsuario().getNome());
        morador.setEmail(dto.getUsuario().getEmail());
        morador.setTelefone(dto.getUsuario().getTelefone());
        morador.setDataNascimento(dto.getUsuario().getDataNascimento());
        morador.setSenha(dto.getUsuario().getSenha()); // Criptografar antes de salvar
        morador.setTipo(dto.getUsuario().getTipo());

        // Setando o CPF e Endereço
        morador.setCpf(dto.getCpf());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setNumero(dto.getEndereco().getNumero());
        endereco.setCep(dto.getEndereco().getCep());
        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setBairro(dto.getEndereco().getBairro());
        endereco.setCidade(dto.getEndereco().getCidade());

        morador.setEndereco(endereco);

        return morador;
    }

    public MoradorDto toDto(Morador morador) {
        UsuarioPostRequestDto usuarioDto = new UsuarioPostRequestDto();
        usuarioDto.setNome(morador.getNome());
        usuarioDto.setEmail(morador.getEmail());
        usuarioDto.setTelefone(morador.getTelefone());
        usuarioDto.setDataNascimento(morador.getDataNascimento());
        usuarioDto.setTipo(morador.getTipo());
        usuarioDto.setSenha(morador.getSenha());

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setLogradouro(morador.getEndereco().getLogradouro());
        enderecoDto.setNumero(morador.getEndereco().getNumero());
        enderecoDto.setCep(morador.getEndereco().getCep());
        enderecoDto.setComplemento(morador.getEndereco().getComplemento());
        enderecoDto.setBairro(morador.getEndereco().getBairro());
        enderecoDto.setCidade(morador.getEndereco().getCidade());

        return new MoradorDto(usuarioDto, morador.getCpf(), enderecoDto);
    }
}
