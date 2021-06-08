package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.VacunaHistorial;
import co.edu.ufps.huelleritos.util.Conexion;

public class VacunaHistorialDAO extends Conexion<VacunaHistorial> implements GenericDAO<VacunaHistorial>{
	public VacunaHistorialDAO() {
		super(VacunaHistorial.class);
	}
}
