package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.TipoNoticia;
import co.edu.ufps.huelleritos.util.Conexion;

public class TipoNoticiaDAO extends Conexion<TipoNoticia> implements GenericDAO<TipoNoticia>{
	
	public TipoNoticiaDAO() {
		super(TipoNoticia.class);
	}

}
