package co.edu.ufps.sorteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.sorteo.entities.Boleta;
import co.edu.ufps.sorteo.repository.BoletaRepo;

@Controller
@RequestMapping("/boleta")
public class BoletaController {

	@Autowired
	BoletaRepo boletaRepo;
	
	@GetMapping("/boleta")
	public String index() {
		Boleta b= new Boleta();
		b.setId(45);
		boletaRepo.save(b);
		return "index";
	}
	
}
