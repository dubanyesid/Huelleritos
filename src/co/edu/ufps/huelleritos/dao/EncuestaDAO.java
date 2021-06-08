package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Encuesta;
import co.edu.ufps.huelleritos.util.Conexion;

public class EncuestaDAO extends Conexion<Encuesta> implements GenericDAO<Encuesta>{
	public EncuestaDAO() {
		 super(Encuesta.class);
	 }
}
