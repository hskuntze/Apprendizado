package br.edu.infnet.Apprendizado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/responsaveis")
public class ResponsavelController {
	@GetMapping(value = "/lista")
	public String lista() {
		return "responsavel/lista";
	}
}
