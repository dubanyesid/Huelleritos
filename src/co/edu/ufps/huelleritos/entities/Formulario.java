package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the formulario database table.
 * 
 */
@Entity
@NamedQuery(name="Formulario.findAll", query="SELECT f FROM Formulario f")
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_formulario")
	private int idFormulario;

	private String apellido;

	private String celular;

	private String correo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Adoptante
	@OneToMany(mappedBy="formulario")
	private List<Adoptante> adoptantes;

	//bi-directional many-to-many association to Pregunta
	@ManyToMany
	@JoinTable(
		name="formulario_pregunta"
		, joinColumns={
			@JoinColumn(name="id_formulario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_pregunta")
			}
		)
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to HogarDePaso
	@OneToMany(mappedBy="formulario")
	private List<HogarDePaso> hogarDePasos;

	public Formulario() {
	}

	public int getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Adoptante> getAdoptantes() {
		return this.adoptantes;
	}

	public void setAdoptantes(List<Adoptante> adoptantes) {
		this.adoptantes = adoptantes;
	}

	public Adoptante addAdoptante(Adoptante adoptante) {
		getAdoptantes().add(adoptante);
		adoptante.setFormulario(this);

		return adoptante;
	}

	public Adoptante removeAdoptante(Adoptante adoptante) {
		getAdoptantes().remove(adoptante);
		adoptante.setFormulario(null);

		return adoptante;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<HogarDePaso> getHogarDePasos() {
		return this.hogarDePasos;
	}

	public void setHogarDePasos(List<HogarDePaso> hogarDePasos) {
		this.hogarDePasos = hogarDePasos;
	}

	public HogarDePaso addHogarDePaso(HogarDePaso hogarDePaso) {
		getHogarDePasos().add(hogarDePaso);
		hogarDePaso.setFormulario(this);

		return hogarDePaso;
	}

	public HogarDePaso removeHogarDePaso(HogarDePaso hogarDePaso) {
		getHogarDePasos().remove(hogarDePaso);
		hogarDePaso.setFormulario(null);

		return hogarDePaso;
	}

}