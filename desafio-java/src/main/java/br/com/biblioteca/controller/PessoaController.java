package br.com.biblioteca.controller;

import br.com.biblioteca.model.dto.PessoaDTO;
import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> adicionarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoaService.salvarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
    }

    @GetMapping("/listGerente")
    public List<Pessoa> listGerente(){
        return pessoaService.listGerente();
    }

}
