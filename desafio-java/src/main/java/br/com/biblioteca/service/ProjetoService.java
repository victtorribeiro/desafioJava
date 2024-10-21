package br.com.biblioteca.service;

import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Pessoa;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    private final MembroService membroService;

    public Projeto salvarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();


        if (projetoDTO.getIdGerente() != null) {
            Pessoa pessoa = new Pessoa(projetoDTO.getIdGerente());
            projetoDTO.setGerente(pessoa);
        }
        BeanUtils.copyProperties(projetoDTO, projeto);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto alterarProjeto(Long id, ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        if (projetoDTO.getIdGerente() != null) {
            Pessoa pessoa = new Pessoa(projetoDTO.getIdGerente());
            projetoDTO.setGerente(pessoa);
        }
        BeanUtils.copyProperties(projetoDTO, projeto);
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    public Projeto buscarProjetoId(Long id) {
        Optional<Projeto> projetoBuscado = projetoRepository.findById(id);
        return projetoBuscado.orElse(null);
    }

    public ResponseEntity<String> deletarProjeto(Long id)  {
        Projeto projeto = buscarProjetoId(id);
        if(projeto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (projeto.getStatus().equals(StatusEnum.INICIADO) || projeto.getStatus().equals(StatusEnum.EM_ANDAMENTO) || projeto.getStatus().equals(StatusEnum.ENCERRADO)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        membroService.deletarMembro(projeto);
        projetoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
