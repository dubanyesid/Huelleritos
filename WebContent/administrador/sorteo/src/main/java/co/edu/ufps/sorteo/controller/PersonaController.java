package co.edu.ufps.sorteo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ufps.sorteo.entities.Boleta;
import co.edu.ufps.sorteo.entities.Persona;
import co.edu.ufps.sorteo.entities.Sorteo;
import co.edu.ufps.sorteo.repository.BoletaRepo;
import co.edu.ufps.sorteo.repository.PersonaRepo;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaRepo personaRepo;
	
	@GetMapping("/listarPersonas")
	public String listar(HttpServletRequest request, Model model) {
		
		model.addAttribute("list", personaRepo.findAll());
		
		return "listarPersonas";
	}
	
	@GetMapping("/registroPersona")
	public String registroSorteo(HttpServletRequest request, Model model) {
		
		model.addAttribute("persona", new Persona());
		
		return "registroPersona";
	}

	@PostMapping("/registroPersonaPost")
	public String registroPost(@ModelAttribute(value="sorteo") Persona persona, RedirectAttributes redirectAttrs) {
		
		this.personaRepo.save(persona);

		return "redirect:/index";
	}
}
