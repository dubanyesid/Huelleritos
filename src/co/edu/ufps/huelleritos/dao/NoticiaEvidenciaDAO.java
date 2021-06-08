package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.NoticiaEvidencia;
import co.edu.ufps.huelleritos.util.Conexion;

public class NoticiaEvidenciaDAO extends Conexion<NoticiaEvidencia> implements GenericDAO<NoticiaEvidencia>{
	public NoticiaEvidenciaDAO() {
		super(NoticiaEvidencia.class);
	}
}	