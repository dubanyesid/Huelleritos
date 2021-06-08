package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Guarderia;
import co.edu.ufps.huelleritos.util.Conexion;

public class GuarderiaDAO extends Conexion<Guarderia> implements GenericDAO<Guarderia>{
	public GuarderiaDAO() {
		super(Guarderia.class);
	}
}	