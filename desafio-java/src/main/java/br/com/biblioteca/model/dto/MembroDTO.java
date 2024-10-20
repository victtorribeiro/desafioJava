package br.com.biblioteca.model.dto;

import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.model.entity.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembroDTO {

    private Pessoa pessoa;
    private Projeto projeto;
}
