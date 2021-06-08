package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.HistorialAnimal;
import co.edu.ufps.huelleritos.util.Conexion;

public class HistorialAnimalDAO extends Conexion<HistorialAnimal> implements GenericDAO<HistorialAnimal>{
	public HistorialAnimalDAO() {
		super(HistorialAnimal.class);
	}
}	