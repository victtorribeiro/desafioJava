package br.com.biblioteca.controller;


import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.service.MembroService;
import br.com.biblioteca.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    private final MembroService membroService;

    @PostMapping(value = "/cadastrarProjeto")
    public ResponseEntity<ProjetoDTO> adicionarProjeto(@RequestBody ProjetoDTO projetoDTO) {
        try {
            Projeto projeto = projetoService.salvarProjeto(projetoDTO);

            membroService.salvarMembro(new MembroDTO(projeto.getGerente(), projeto));

            return new ResponseEntity<>(projetoDTO, HttpStatus.OK);
        } catch (Exception ex) {
            ex.getMessage();
            return new ResponseEntity<>(projetoDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listProjetos")
    public List<Projeto> listProjetos() {
        return projetoService.listarProjetos();
    }



}
