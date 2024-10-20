package br.com.biblioteca.service;

import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa salvarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listGerente(){
        return pessoaRepository.findAllByGerenteIsTrue();
    }

}
