package br.com.biblioteca.model.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaDTO {
    @NotNull
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Boolean gerente;
    private Boolean funcionario;
}
