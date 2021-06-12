package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pregunta database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p"),
	@NamedQuery(name="Pregunta.findAdopta", query="SELECT p FROM Pregunta p WHERE p.encuesta.idEncuesta=1 "),
	@NamedQuery(name="Pregunta.findHogar", query="SELECT p FROM Pregunta p where p.encuesta.idEncuesta=2" )})
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pregunta")
	private int idPregunta;

	private int estado;

	private String texto;

	//bi-directional many-to-one association to FormularioPregunta
	@OneToMany(mappedBy="pregunta")
	private List<FormularioPregunta> formularioPreguntas;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="pregunta")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne
	@JoinColumn(name="id_encuesta")
	private Encuesta encuesta;

	public Pregunta() {
	}

	public int getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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
		formularioPregunta.setPregunta(this);

		return formularioPregunta;
	}

	@Override
	public String toString() {
		return "Pregunta [idPregunta=" + idPregunta + ", estado=" + estado + ", texto=" + texto
				+ ", formularioPreguntas=" + formularioPreguntas + ", opcions=" + opcions + ", encuesta=" + encuesta
				+ "]";
	}

	public FormularioPregunta removeFormularioPregunta(FormularioPregunta formularioPregunta) {
		getFormularioPreguntas().remove(formularioPregunta);
		formularioPregunta.setPregunta(null);

		return formularioPregunta;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setPregunta(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setPregunta(null);

		return opcion;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

}