package co.edu.ufps.huelleritos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.Usuario;
import co.edu.ufps.huelleritos.negocio.Puntaje;
import co.edu.ufps.huelleritos.util.Conexion;

public class FormularioDAO extends Conexion<Formulario> implements GenericDAO<Formulario> {
	public FormularioDAO() {
		super(Formulario.class);
	}

	public List<Puntaje> listAdopcion() {
		Query consulta = getEm().createNativeQuery(
				"select formulario.id_formulario,formulario.nombre,formulario.apellido,formulario.correo,formulario.celular,formulario.fecha,sum(opcion.peso)puntaje,formulario.usuario from formulario "
				+ "INNER JOIN formulario_pregunta fpregunta on fpregunta.id_formulario=formulario.id_formulario "
				+ "INNER JOIN opcion on opcion.id_opcion=fpregunta.id_opcion inner join pregunta on pregunta.id_pregunta = fpregunta.id_pregunta inner join encuesta on encuesta.id_encuesta= pregunta.id_encuesta where encuesta.id_encuesta=:id_encuesta "
				+ "GROUP by formulario.id_formulario ORDER by puntaje DESC").setParameter("id_encuesta", 1);
		List<Object []> lista = consulta.getResultList();
		List<Puntaje> listPuntajes =null;
		if(lista!=null) {
			listPuntajes = new ArrayList<>();
			for(Object [] s:lista) {
				Formulario f =new Formulario(Integer.parseInt(s[0].toString()),s[1].toString(),s[2].toString(),s[3].toString(),s[4].toString(),(Date)(s[5]));
				
				if(s[7]!=null) {
					Usuario u=new UsuarioDAO().find(s[7].toString());
					f.setUsuarioBean(u);
				}
				listPuntajes.add(new Puntaje(f,Integer.parseInt(s[6].toString()),1));
			}
		}
		return listPuntajes;
	}

	public List<Puntaje> listHogar() {
		Query consulta = getEm().createNativeQuery(
				"select formulario.id_formulario,formulario.nombre,formulario.apellido,formulario.correo,formulario.celular,formulario.fecha,sum(opcion.peso)puntaje, formulario.usuario from formulario "
				+ "INNER JOIN formulario_pregunta fpregunta on fpregunta.id_formulario=formulario.id_formulario "
				+ "INNER JOIN opcion on opcion.id_opcion=fpregunta.id_opcion inner join pregunta on pregunta.id_pregunta = fpregunta.id_pregunta inner join encuesta on encuesta.id_encuesta= pregunta.id_encuesta where encuesta.id_encuesta=:id_encuesta "
				+ "GROUP by formulario.id_formulario ORDER by puntaje DESC").setParameter("id_encuesta", 2);
		List<Object []> lista = consulta.getResultList();
		List<Puntaje> listPuntajes =null;
		if(lista!=null) {
			listPuntajes = new ArrayList<>();
			for(Object [] s:lista) {
				Formulario f =new Formulario(Integer.parseInt(s[0].toString()),s[1].toString(),s[2].toString(),s[3].toString(),s[4].toString(),(Date)(s[5]));
				if(s[7]!=null) {
					Usuario u=new UsuarioDAO().find(s[7].toString());
					f.setUsuarioBean(u);
				}
				listPuntajes.add(new Puntaje(f,Integer.parseInt(s[6].toString()),2));
			}
		}
		return listPuntajes;
	}
}