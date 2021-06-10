package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_opcion")
	private int idOpcion;

	private int estado;

	private int peso;

	private String texto;

	//bi-directional many-to-one association to FormularioPregunta
	@OneToMany(mappedBy="opcion")
	private List<FormularioPregunta> formularioPreguntas = new ArrayList();

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;

	public Opcion() {
	}
	

	public Opcion(int idOpcion, int estado, int peso, String texto, Pregunta pregunta) {
		super();
		this.idOpcion = idOpcion;
		this.estado = estado;
		this.peso = peso;
		this.texto = texto;
		this.pregunta = pregunta;
	}



	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<FormularioPregunta> getFormularioPreguntas() {
		return this.formularioPreguntas;
	}

	public void setFormularioPreguntas(List<FormularioPregunta> formularioPreguntas) {
		this.formularioPreguntas = formularioPreguntas;
	}

	public FormularioPregunta addFormularioPregunta(FormularioPregunta formularioPregunta) {
		getFormularioPreguntas().add(formularioPregunta);
		formularioPregunta.setOpcion(this);

		return formularioPregunta;
	}

	public FormularioPregunta removeFormularioPregunta(FormularioPregunta formularioPregunta) {
		getFormularioPreguntas().remove(formularioPregunta);
		formularioPregunta.setOpcion(null);

		return formularioPregunta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}


	@Override
	public String toString() {
		return "Opcion [idOpcion=" + idOpcion;
	}

}