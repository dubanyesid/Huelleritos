package co.edu.ufps.huelleritos.dao;


import co.edu.ufps.huelleritos.entities.EstadoAnimal;
import co.edu.ufps.huelleritos.util.Conexion;

public class EstadoAnimalDAO extends Conexion<EstadoAnimal> implements GenericDAO<EstadoAnimal>{
	public EstadoAnimalDAO() {
		super(EstadoAnimal.class);
	}

}
