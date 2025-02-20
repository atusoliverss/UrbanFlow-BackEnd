package br.com.urbanflow.endereco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    @JsonProperty("logradouro")
    @NotBlank(message = "A rua do endereço não pode estar vazia.")
    private String logradouro;

    @JsonProperty("numero")
    @NotNull(message = "O número do endereço é obrigatorio.")
    //@Pattern(regexp = "\\d+", message = "O número deve conter apenas dígitos.")
    private int numero;

    @JsonProperty("cep")
    @NotBlank(message = "O CEP do endereço não pode estar vazio.")
    //@Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 'XXXXX-XXX'.")
    private String cep;

    @JsonProperty("complemento")
    @Size(max = 255, message = "O complemento deve ter no máximo 255 caracteres.")
    private String complemento;

    @JsonProperty("bairro")
    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 255, message = "O bairro deve ter no máximo 255 caracteres.")
    private String bairro;

    @JsonProperty("cidade")
    @NotBlank(message = "A cidade não pode estar vazia.")
    @Size(max = 255, message = "A cidade deve ter no máximo 255 caracteres.")
    private String cidade;
}
