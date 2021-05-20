package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Opcion;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class OpcionDAO extends Conexion<Opcion> implements GenericDAO<Opcion>{
	public OpcionDAO() {
		super(Opcion.class);
	}
}	