package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.EnfermedadHistorial;
import co.edu.ufps.huelleritos.entities.VacunaHistorial;
import co.edu.ufps.huelleritos.util.Conexion;

public class EnfermedadHistorialDAO extends Conexion<EnfermedadHistorial> implements GenericDAO<EnfermedadHistorial>{
	public EnfermedadHistorialDAO() {
		super(EnfermedadHistorial.class);
	}
}
