package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encuesta database table.
 * 
 */
@Entity
@NamedQuery(name="Encuesta.findAll", query="SELECT e FROM Encuesta e")
public class Encuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_encuesta")
	private int idEncuesta;

	private String tipo;

	private String titulo;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="encuesta")
	private List<Pregunta> preguntas;

	public Encuesta() {
	}

	
	
	public Encuesta(Integer idEncuesta, String tipo) {
		super();
		this.idEncuesta = idEncuesta;
		this.tipo = tipo;
	}



	public int getIdEncuesta() {
		return this.idEncuesta;
	}

	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setEncuesta(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setEncuesta(null);

		return pregunta;
	}

}