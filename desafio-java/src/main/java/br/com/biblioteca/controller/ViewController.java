package br.com.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.biblioteca.model.entity.Projeto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class ViewController {

	private final ProjetoController projetoController;

	@GetMapping("/")
	public String home(Model model, HttpServletRequest httpServletRequest) {
		return "index";
	}

	@GetMapping("/cadastrar")
	public String cadastrarProjetoView(){
		return "cadastrar-projeto";
	}

	@GetMapping("/listarProjetos")
	public ModelAndView listarProjetos (){
		List<Projeto> projetoList = projetoController.listProjetos();
		ModelAndView model = new ModelAndView("listar-projetos");
		model.addObject("projetoList", projetoList);
		return model;
	}
}
