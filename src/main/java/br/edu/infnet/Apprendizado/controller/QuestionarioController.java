package br.edu.infnet.Apprendizado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/questionarios")
public class QuestionarioController {
	@GetMapping(value = "/lista")
	public String lista() {
		return "questionario/lista";
	}
}
