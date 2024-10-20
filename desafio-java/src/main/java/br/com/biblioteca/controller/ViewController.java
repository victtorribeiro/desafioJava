package br.com.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class ViewController {

	@GetMapping("/")
	public String home(Model model, HttpServletRequest httpServletRequest) {
		return "index";
	}

	@GetMapping("/cadastrar")
	public String cadastrarProjetoView(){
		return "cadastrar-projeto";
	}

	@GetMapping("/listarProjetos")
	public String listarProjetos (){
		return "listar-projetos";
	}
}
