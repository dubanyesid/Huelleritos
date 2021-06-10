package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formulario_pregunta database table.
 * 
 */
@Entity
@Table(name="formulario_pregunta")
@NamedQuery(name="FormularioPregunta.findAll", query="SELECT f FROM FormularioPregunta f")
public class FormularioPregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_formulario_pregunta")
	private int idFormularioPregunta;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="id_formulario")
	private Formulario formulario;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_opcion")
	private Opcion opcion;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;

	public FormularioPregunta() {
	}

	public int getIdFormularioPregunta() {
		return this.idFormularioPregunta;
	}

	public void setIdFormularioPregunta(int idFormularioPregunta) {
		this.idFormularioPregunta = idFormularioPregunta;
	}

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}