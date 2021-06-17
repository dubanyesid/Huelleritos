package co.edu.ufps.sorteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.sorteo.entities.Boleta;
import co.edu.ufps.sorteo.repository.BoletaRepo;
import co.edu.ufps.sorteo.repository.NumeroRepo;

@Controller
@RequestMapping("/numero")
public class NumeroController {

	@Autowired
	NumeroRepo numeroRepo;
	
	@GetMapping("/index")
	public String index() {
		//Boleta b= new Boleta();
		//b.setId(45);
		//boletaRepo.save(b);
		return "index";
	}
	
}
