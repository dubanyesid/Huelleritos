package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.OperacionesHistorial;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class OperacionesHistorialDAO extends Conexion<OperacionesHistorial> implements GenericDAO<OperacionesHistorial>{
	public OperacionesHistorialDAO() {
		super(OperacionesHistorial.class);
	}
}	