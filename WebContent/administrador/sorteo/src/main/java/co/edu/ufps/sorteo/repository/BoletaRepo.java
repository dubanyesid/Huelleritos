package co.edu.ufps.sorteo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.sorteo.entities.Boleta;


public interface BoletaRepo extends JpaRepository<Boleta, Integer> {
	
	

}