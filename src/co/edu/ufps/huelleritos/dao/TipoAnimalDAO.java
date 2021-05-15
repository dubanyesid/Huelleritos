package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.TipoAnimal;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class TipoAnimalDAO extends Conexion<TipoAnimal> implements GenericDAO<TipoAnimal>{
	public TipoAnimalDAO() {
		super(TipoAnimal.class);
	}
}
