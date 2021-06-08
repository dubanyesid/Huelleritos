package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.util.Conexion;

public class AnimalDAO extends Conexion<Animal> implements GenericDAO<Animal> {
 public AnimalDAO() {
	 super(Animal.class);
 }
}
