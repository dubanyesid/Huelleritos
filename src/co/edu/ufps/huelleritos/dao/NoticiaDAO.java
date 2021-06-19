package co.edu.ufps.huelleritos.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import co.edu.ufps.huelleritos.entities.Noticia;
import co.edu.ufps.huelleritos.entities.Noticia;
import co.edu.ufps.huelleritos.util.Conexion;

public class NoticiaDAO extends Conexion<Noticia> implements GenericDAO<Noticia>{
	public NoticiaDAO() {
		super(Noticia.class);
	}
	
	public List<Noticia> listEventos() {
		TypedQuery<Noticia> consulta = super.getEm().createNamedQuery(Noticia.class.getSimpleName() + ".findAllEventos",
				Noticia.class);
		List<Noticia> lista = (List<Noticia>) consulta.getResultList();
		return lista;
	}
	
	public List<Noticia> listEvidencias() {
		TypedQuery<Noticia> consulta = super.getEm().createNamedQuery(Noticia.class.getSimpleName() + ".findAllEvidencias",
				Noticia.class);
		List<Noticia> lista = (List<Noticia>) consulta.getResultList();
		return lista;
	}
}	