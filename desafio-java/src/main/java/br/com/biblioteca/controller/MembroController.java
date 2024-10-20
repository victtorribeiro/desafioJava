package br.com.biblioteca.controller;

import br.com.biblioteca.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membro")
@AllArgsConstructor
public class MembroController {

    private final MembroService membroService;

}
