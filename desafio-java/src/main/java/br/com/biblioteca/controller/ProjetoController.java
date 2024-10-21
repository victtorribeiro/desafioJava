package br.com.biblioteca.controller;


import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.service.MembroService;
import br.com.biblioteca.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
            ex.getStackTrace();
            return new ResponseEntity<>(projetoDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listProjetos")
    public List<Projeto> listProjetos() {
        return projetoService.listarProjetos();
    }

    @PutMapping("/atualizarProjeto/{id}")
    public ResponseEntity<ProjetoDTO> alterarProjeto(@PathVariable("id") Long id, @RequestBody ProjetoDTO projetoDTO) {
        try {
            Projeto projeto = projetoService.alterarProjeto(id, projetoDTO);

            membroService.alterarMembro(new MembroDTO(projeto.getGerente(), projeto));

            return new ResponseEntity<>(projetoDTO, HttpStatus.OK);
        }catch (Exception e) {
            e.getStackTrace();
            return new ResponseEntity<>(projetoDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletarProjeto/{id}")
    public ResponseEntity<String> deletarProjeto(@PathVariable Long id) {
        try {
            return projetoService.deletarProjeto(id);

        }catch (Exception e) {
            e.getStackTrace();
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    public List<RiscoEnum> listarRiscos() {
        return Arrays.asList(RiscoEnum.values());
    }
    public List<StatusEnum> listarStatus(){
        return Arrays.asList(StatusEnum.values());
    }

}
