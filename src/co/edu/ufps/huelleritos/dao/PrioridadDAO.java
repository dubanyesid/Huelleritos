package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Prioridad;
import co.edu.ufps.huelleritos.util.Conexion;

public class PrioridadDAO extends Conexion<Prioridad> implements GenericDAO<Prioridad>{
	public PrioridadDAO() {
		super(Prioridad.class);
	}
}
