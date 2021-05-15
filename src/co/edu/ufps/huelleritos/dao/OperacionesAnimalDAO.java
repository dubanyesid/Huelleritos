package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.OperacionesAnimal;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class OperacionesAnimalDAO extends Conexion<OperacionesAnimal> implements GenericDAO<OperacionesAnimal>{
	public OperacionesAnimalDAO() {
		super(OperacionesAnimal.class);
	}
}	