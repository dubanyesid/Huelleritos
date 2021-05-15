package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_animal")
	private int codigoAnimal;

	private String color;

	private String descripcion;

	private int edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="imagen_animal")
	private String imagenAnimal;

	@Column(name="nombre_animal")
	private String nombreAnimal;

	private String peso;

	private String raza;

	private String sexo;

	//bi-directional many-to-one association to Adoptante
	@ManyToOne
	@JoinColumn(name="usuario_DNI")
	private Adoptante adoptante;

	//bi-directional many-to-one association to EstadoAnimal
	@ManyToOne
	@JoinColumn(name="estado_animal")
	private EstadoAnimal estadoAnimalBean;

	//bi-directional many-to-one association to Guarderia
	@ManyToOne
	@JoinColumn(name="nombre_guarderia")
	private Guarderia guarderia;

	//bi-directional many-to-one association to HistorialAnimal
	@ManyToOne
	@JoinColumn(name="id_historial")
	private HistorialAnimal historialAnimal;

	//bi-directional many-to-one association to Prioridad
	@ManyToOne
	@JoinColumn(name="id_prioridad")
	private Prioridad prioridad;

	//bi-directional many-to-one association to TipoAnimal
	@ManyToOne
	@JoinColumn(name="tipo_animal_id")
	private TipoAnimal tipoAnimal;

	public Animal() {
	}

	public int getCodigoAnimal() {
		return this.codigoAnimal;
	}

	public void setCodigoAnimal(int codigoAnimal) {
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

	public Adoptante getAdoptante() {
		return this.adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
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

	public HistorialAnimal getHistorialAnimal() {
		return this.historialAnimal;
	}

	public void setHistorialAnimal(HistorialAnimal historialAnimal) {
		this.historialAnimal = historialAnimal;
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

}