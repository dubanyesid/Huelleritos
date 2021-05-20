package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class AnimalDAO extends Conexion<Animal> implements GenericDAO<Animal> {
 public AnimalDAO() {
	 super(Animal.class);
 }
}
