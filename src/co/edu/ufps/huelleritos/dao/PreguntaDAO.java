package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Pregunta;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class PreguntaDAO extends Conexion<Pregunta> implements GenericDAO<Pregunta>{
	public PreguntaDAO() {
		super(Pregunta.class);
	}
}	