package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a"),
	@NamedQuery(name="Animal.findAllAdopcion", query="SELECT a FROM Animal a where a.estadoAnimalBean.descripcion='Guarderia'"),
	@NamedQuery(name="Animal.findAllPrioritario", query="SELECT a FROM Animal a where a.estadoAnimalBean.descripcion='Guarderia' and a.prioridad.prioridad='Urgente'")
})
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_animal")
	private String codigoAnimal;

	private String color;

	private String descripcion;

	private int edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Lob
	@Column(name="imagen_animal")
	private String imagenAnimal;

	@Column(name="nombre_animal")
	private String nombreAnimal;

	private String peso;

	private String raza;

	private String sexo;

	//bi-directional many-to-one association to EstadoAnimal
	@ManyToOne
	@JoinColumn(name="estado_animal")
	private EstadoAnimal estadoAnimalBean;

	//bi-directional many-to-one association to Guarderia
	@ManyToOne
	@JoinColumn(name="nombre_guarderia")
	private Guarderia guarderia;

	//bi-directional many-to-one association to Prioridad
	@ManyToOne
	@JoinColumn(name="id_prioridad")
	private Prioridad prioridad;

	//bi-directional many-to-one association to TipoAnimal
	@ManyToOne
	@JoinColumn(name="tipo_animal_id")
	private TipoAnimal tipoAnimal;

	//bi-directional many-to-one association to FormularioAnimal
	@OneToMany(mappedBy="animal")
	private List<FormularioAnimal> formularioAnimals;

	//bi-directional many-to-one association to HistorialAnimal
	@OneToMany(mappedBy="animal")
	private List<HistorialAnimal> historialAnimals;

	//bi-directional many-to-one association to SeguimientoAnimal
	@OneToMany(mappedBy="animal")
	private List<SeguimientoAnimal> seguimientoAnimals;

	public Animal() {
	}

	public String getCodigoAnimal() {
		return this.codigoAnimal;
	}

	public void setCodigoAnimal(String codigoAnimal) {
		this.codigoAnimal = codigoAnimal;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getImagenAnimal() {
		return this.imagenAnimal;
	}

	public void setImagenAnimal(String imagenAnimal) {
		this.imagenAnimal = imagenAnimal;
	}

	public String getNombreAnimal() {
		return this.nombreAnimal;
	}

	public void setNombreAnimal(String nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	public String getPeso() {
		return this.peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public EstadoAnimal getEstadoAnimalBean() {
		return this.estadoAnimalBean;
	}

	public void setEstadoAnimalBean(EstadoAnimal estadoAnimalBean) {
		this.estadoAnimalBean = estadoAnimalBean;
	}

	public Guarderia getGuarderia() {
		return this.guarderia;
	}

	public void setGuarderia(Guarderia guarderia) {
		this.guarderia = guarderia;
	}

	public Prioridad getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public TipoAnimal getTipoAnimal() {
		return this.tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<FormularioAnimal> getFormularioAnimals() {
		return this.formularioAnimals;
	}

	public void setFormularioAnimals(List<FormularioAnimal> formularioAnimals) {
		this.formularioAnimals = formularioAnimals;
	}

	public FormularioAnimal addFormularioAnimal(FormularioAnimal formularioAnimal) {
		getFormularioAnimals().add(formularioAnimal);
		formularioAnimal.setAnimal(this);

		return formularioAnimal;
	}

	public FormularioAnimal removeFormularioAnimal(FormularioAnimal formularioAnimal) {
		getFormularioAnimals().remove(formularioAnimal);
		formularioAnimal.setAnimal(null);

		return formularioAnimal;
	}

	public List<HistorialAnimal> getHistorialAnimals() {
		return this.historialAnimals;
	}

	public void setHistorialAnimals(List<HistorialAnimal> historialAnimals) {
		this.historialAnimals = historialAnimals;
	}

	public HistorialAnimal addHistorialAnimal(HistorialAnimal historialAnimal) {
		getHistorialAnimals().add(historialAnimal);
		historialAnimal.setAnimal(this);

		return historialAnimal;
	}

	public HistorialAnimal removeHistorialAnimal(HistorialAnimal historialAnimal) {
		getHistorialAnimals().remove(historialAnimal);
		historialAnimal.setAnimal(null);

		return historialAnimal;
	}

	public List<SeguimientoAnimal> getSeguimientoAnimals() {
		return this.seguimientoAnimals;
	}

	public void setSeguimientoAnimals(List<SeguimientoAnimal> seguimientoAnimals) {
		this.seguimientoAnimals = seguimientoAnimals;
	}

	public SeguimientoAnimal addSeguimientoAnimal(SeguimientoAnimal seguimientoAnimal) {
		getSeguimientoAnimals().add(seguimientoAnimal);
		seguimientoAnimal.setAnimal(this);

		return seguimientoAnimal;
	}

	public SeguimientoAnimal removeSeguimientoAnimal(SeguimientoAnimal seguimientoAnimal) {
		getSeguimientoAnimals().remove(seguimientoAnimal);
		seguimientoAnimal.setAnimal(null);

		return seguimientoAnimal;
	}

}