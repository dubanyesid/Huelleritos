package co.edu.ufps.huelleritos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.Pregunta;
import co.edu.ufps.huelleritos.negocio.Puntaje;
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
	
	public List<Puntaje> listPreguntas(Integer idFormulario) {
		Query consulta = getEm().createNativeQuery(
				"select pregunta.texto,opcion.texto from pregunta INNER JOIN formulario_pregunta fpregunta on fpregunta.id_pregunta=pregunta.id_pregunta "
				+ "INNER JOIN opcion on opcion.id_pregunta=pregunta.id_pregunta and fpregunta.id_opcion=opcion.id_opcion "
				+ "INNER JOIN encuesta on encuesta.id_encuesta=pregunta.id_encuesta "
				+ "INNER JOIN formulario on fpregunta.id_formulario=formulario.id_formulario where formulario.id_formulario=:id_formulario "
				+ "order by pregunta.id_pregunta ASC").setParameter("id_formulario", idFormulario);
		List<Object []> lista = consulta.getResultList();
		List<Puntaje> listPuntajes =null;
		if(lista!=null) {
			listPuntajes = new ArrayList<>();
			for(Object [] s:lista) {
				Formulario f =new Formulario(Integer.parseInt(s[0].toString()),s[1].toString(),s[2].toString(),s[3].toString(),s[4].toString(),(Date)(s[5]));
				listPuntajes.add(s[0].toString());
			}
		}
		return listPuntajes;
	}
}	