package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.entity.Membro;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public void salvarMembro(MembroDTO membroDTO) {
        Membro membro = new Membro();
        BeanUtils.copyProperties(membroDTO, membro);
        membroRepository.save(membro);
    }

    public void alterarMembro(MembroDTO membroDTO) {
        Membro membro = membroRepository.findByProjeto(membroDTO.getProjeto());
        if (membro != null) {
            BeanUtils.copyProperties(membroDTO, membro);
            membroRepository.save(membro);
        }
    }

    public void deletarMembro(Projeto projeto) {
        Membro membro = membroRepository.findByProjeto(projeto);
        if (membro != null) {
            membroRepository.deleteById(membro.getId());
        }
    }

}
