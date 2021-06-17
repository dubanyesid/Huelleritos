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
import co.edu.ufps.sorteo.entities.Sorteo;
import co.edu.ufps.sorteo.repository.BoletaRepo;
import co.edu.ufps.sorteo.repository.SorteoRepo;

@Controller
@RequestMapping("/sorteo")
public class SorteoController {

	@Autowired
	SorteoRepo sorteoRepo;
		
	@GetMapping("/listarSorteos")
	public String listar(HttpServletRequest request, Model model) {
		
		model.addAttribute("list", sorteoRepo.findAll());
		
		return "listarSorteos";
	}
	
	@GetMapping("/registroSorteo")
	public String registroSorteo(HttpServletRequest request, Model model) {
		
		model.addAttribute("sorteo", new Sorteo());
		
		return "registroSorteo";
	}

	@PostMapping("/registroSorteoPost")
	public String registroPost(@ModelAttribute(value="sorteo") Sorteo sorteo, RedirectAttributes redirectAttrs) {
		
		this.sorteoRepo.save(sorteo);
		
		return "redirect:/index";
	}
	
}
