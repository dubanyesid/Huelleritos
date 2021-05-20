package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Enfermedad;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class EnfermedadDAO extends Conexion<Enfermedad> implements GenericDAO<Enfermedad>{
	 public EnfermedadDAO() {
		 super(Enfermedad.class);
	 }
}
