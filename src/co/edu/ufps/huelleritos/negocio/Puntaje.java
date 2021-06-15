package co.edu.ufps.huelleritos.negocio;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.entities.Formulario;

public class Puntaje {

	private Formulario formulario;
	private Integer puntaje;
	private Integer encuesta;
	
	public Puntaje() {
		
	}

	public Puntaje(Formulario formulario, Integer puntaje, Integer encuesta) {
		super();
		this.formulario = formulario;
		this.puntaje = puntaje;
		this.encuesta=encuesta;
	}


	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	
	public Integer getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Integer encuesta) {
		this.encuesta = encuesta;
	}

	@Override
	public String toString() {
		return "Puntaje [formulario=" + formulario + ", puntaje=" + puntaje + "]";
	}

	protected void ordenarPuntajes(List<Puntaje> puntajes)
			throws ServletException, IOException {
		Collections.sort(puntajes, new Comparator<Puntaje>() {
			@Override
			public int compare(Puntaje p1, Puntaje p2) {
				return p1.getPuntaje().compareTo(p2.getPuntaje());
			}
		});
	}
	
}
