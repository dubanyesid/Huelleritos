package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Noticia;
import co.edu.ufps.huelleritos.util.Conexion;

public class NoticiaDAO extends Conexion<Noticia> implements GenericDAO<Noticia>{
	public NoticiaDAO() {
		super(Noticia.class);
	}
}	