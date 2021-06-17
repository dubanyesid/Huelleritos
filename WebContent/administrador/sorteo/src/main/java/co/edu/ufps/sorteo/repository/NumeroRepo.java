package co.edu.ufps.sorteo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.sorteo.entities.Numero;


public interface NumeroRepo extends JpaRepository<Numero, Integer> {
	
	

}