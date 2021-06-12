package co.edu.ufps.huelleritos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import co.edu.ufps.huelleritos.entities.Pregunta;
import co.edu.ufps.huelleritos.util.Conexion;

public class PreguntaDAO extends Conexion<Pregunta> implements GenericDAO<Pregunta>{
	public PreguntaDAO() {
		super(Pregunta.class);
	}
	
	public List<Pregunta> listarFormAdopta(){
		Query consulta= getEm().createNamedQuery(Pregunta.class.getSimpleName()+".findAdopta", Pregunta.class);
		List<Pregunta> lista = (ArrayList<Pregunta>) consulta.getResultList();
		return lista;
	}
	
	public List<Pregunta> listarFormHogarPaso(){
		Query consulta= getEm().createNamedQuery(Pregunta.class.getSimpleName()+".findHogar", Pregunta.class);
		List<Pregunta> lista = (ArrayList<Pregunta>) consulta.getResultList();
		return lista;
	}
}	