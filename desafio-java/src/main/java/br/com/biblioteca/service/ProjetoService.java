package br.com.biblioteca.service;

import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public Projeto salvarProjeto(Projeto projeto){
        return projetoRepository.save(projeto);
    }
}
