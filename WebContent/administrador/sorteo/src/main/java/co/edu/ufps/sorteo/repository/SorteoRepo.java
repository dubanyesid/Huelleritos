package co.edu.ufps.sorteo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ufps.sorteo.entities.Sorteo;


public interface SorteoRepo extends JpaRepository<Sorteo, Integer> {
	
	

}