package co.edu.ufps.huelleritos.dao;


import co.edu.ufps.huelleritos.entities.Vacuna;
import co.edu.ufps.huelleritos.util.Conexion;

public class VacunaDAO extends Conexion<Vacuna> implements GenericDAO<Vacuna>{
	public VacunaDAO() {
		super(Vacuna.class);
	}
}
