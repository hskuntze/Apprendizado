package br.edu.infnet.Apprendizado.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.Apprendizado.entities.Usuario;
import br.edu.infnet.Apprendizado.services.AppService;
import br.edu.infnet.Apprendizado.services.UsuarioService;

@SessionAttributes("user")
@Controller
public class AppController {
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private AppService appService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model) {
		model.addAttribute("projeto", appService.getProjeto());
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		Usuario usuario = userService.validate(email, senha);
		
		if(usuario != null) {
			model.addAttribute("user", usuario);
			return "home";
		}
		return "error";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}
}
