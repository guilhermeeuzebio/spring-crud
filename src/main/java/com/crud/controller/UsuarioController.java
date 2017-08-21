package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;
import com.crud.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/entrar"}, method = RequestMethod.GET)
	public ModelAndView entrar(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("entrar");
		return modelAndView;
	}
	/*
	@RequestMapping("/entrar")
	public String entrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "entrar";
	}
	*/
	@RequestMapping("/cadastrar")
	public String cadastrarUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		return "cadastrarUsuario";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario, BindingResult bindingResult, Model model) {
		Usuario usuarioExiste = usuarioService.findUserByEmail(usuario.getEmail());
		if (usuarioExiste != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		else {
			usuarioService.salvarUsuario(usuario);
			//modelAndView.addObject("successMessage", "User has been registered successfully");
			model.addAttribute("usuario", new Usuario());
			//modelAndView.setViewName("registration");
		}
		
		return "entrar";
	}	
}
