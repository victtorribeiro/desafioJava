package br.com.biblioteca.service;

import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;



}
