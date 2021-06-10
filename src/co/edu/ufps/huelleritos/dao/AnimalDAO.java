package co.edu.ufps.huelleritos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.util.Conexion;

public class AnimalDAO extends Conexion<Animal> implements GenericDAO<Animal> {
 public AnimalDAO() {
	 super(Animal.class);
	 em=super.getEm();
 }
 
 EntityManager em;
 
 public List<Animal> listAdopcion(){
		TypedQuery<Animal> consulta= em.createNamedQuery(Animal.class.getSimpleName()+".findAllAdopcion", Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}


public List<Animal> listPrioridad(){
	TypedQuery<Animal> consulta= em.createNamedQuery(Animal.class.getSimpleName()+".findAllPrioritario", Animal.class);
	List<Animal> lista = (List<Animal>) consulta.getResultList();
	return lista;
}

}