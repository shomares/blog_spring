package org.upiita.spring.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.upiita.spring.formas.FormaSession;

@Controller
//@Scope ("request")
public class LoginControlador {
	
	
	@Autowired
	private FormaSession formaSesion;

	@RequestMapping(value="/login")
	public String login(@RequestParam(required = false) Boolean errorLogin, Model modelo, HttpSession sesion){
		System.out.println("LOGIN ENTRANDO");
		modelo.addAttribute("errorLogin", errorLogin);
		sesion.setAttribute("variable", 10);
		formaSesion.setItemsComprados(10);
		return "login";
	}
	@RequestMapping(value="/error403")
	public String error403(Authentication authentication, Model modelo)
	{
		System.out.println("Nombre: " + authentication.getName());
		modelo.addAttribute("email", authentication.getName());
		return "error-403";
		
	}

}
