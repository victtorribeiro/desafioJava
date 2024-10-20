package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    private final PessoaService pessoaService;

    public Projeto salvarProjeto(ProjetoDTO projetoDTO){
        Projeto projeto = new Projeto();

        if(projetoDTO.getIdGerente() != null){
            Pessoa pessoa = new Pessoa(projetoDTO.getIdGerente());
            projetoDTO.setGerente(pessoa);
        }
        BeanUtils.copyProperties(projetoDTO, projeto);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos(){
        return projetoRepository.findAll();
    }
}
