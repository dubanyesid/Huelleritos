package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.NoticiaEvento;
import co.edu.ufps.huelleritos.util.Conexion;

public class NoticiaEventoDAO extends Conexion<NoticiaEvento> implements GenericDAO<NoticiaEvento>{
	public NoticiaEventoDAO() {
		super(NoticiaEvento.class);
	}
}	