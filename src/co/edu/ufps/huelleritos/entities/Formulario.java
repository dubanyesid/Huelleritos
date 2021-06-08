package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
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

	private String cedula;

	private String celular;

	private String correo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to FormularioAnimal
	@OneToMany(mappedBy="formulario")
	private List<FormularioAnimal> formularioAnimals = new ArrayList();

	//bi-directional many-to-one association to FormularioPregunta
	@OneToMany(mappedBy="formulario")
	private List<FormularioPregunta> formularioPreguntas = new ArrayList();

	public Formulario() {
	}
	
	public Formulario(int idFormulario, String apellido, String cedula, String celular, String correo, Date fecha,
			String nombre, String telefono, Usuario usuarioBean) {
		super();
		this.idFormulario = idFormulario;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.fecha = fecha;
		this.nombre = nombre;
		this.telefono = telefono;
		this.usuarioBean = usuarioBean;
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

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<FormularioAnimal> getFormularioAnimals() {
		return this.formularioAnimals;
	}

	public void setFormularioAnimals(List<FormularioAnimal> formularioAnimals) {
		this.formularioAnimals = formularioAnimals;
	}

	public FormularioAnimal addFormularioAnimal(FormularioAnimal formularioAnimal) {
		getFormularioAnimals().add(formularioAnimal);
		formularioAnimal.setFormulario(this);

		return formularioAnimal;
	}

	public FormularioAnimal removeFormularioAnimal(FormularioAnimal formularioAnimal) {
		getFormularioAnimals().remove(formularioAnimal);
		formularioAnimal.setFormulario(null);

		return formularioAnimal;
	}

	public List<FormularioPregunta> getFormularioPreguntas() {
		return this.formularioPreguntas;
	}

	public void setFormularioPreguntas(List<FormularioPregunta> formularioPreguntas) {
		this.formularioPreguntas = formularioPreguntas;
	}

	public FormularioPregunta addFormularioPregunta(FormularioPregunta formularioPregunta) {
		getFormularioPreguntas().add(formularioPregunta);
		formularioPregunta.setFormulario(this);

		return formularioPregunta;
	}

	public FormularioPregunta removeFormularioPregunta(FormularioPregunta formularioPregunta) {
		getFormularioPreguntas().remove(formularioPregunta);
		formularioPregunta.setFormulario(null);

		return formularioPregunta;
	}

}