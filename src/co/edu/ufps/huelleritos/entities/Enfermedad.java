package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_enfermedad")
	private int codigoEnfermedad;

	private String descripcion;

	@Column(name="nombre_enfermedad")
	private String nombreEnfermedad;

	@Column(name="tratamiento_enfermedad")
	private String tratamientoEnfermedad;

	//bi-directional many-to-many association to HistorialAnimal
	@ManyToMany(mappedBy="enfermedads")
	private List<HistorialAnimal> historialAnimals = new ArrayList();

	
	public Enfermedad(int codigoEnfermedad, String descripcion, String nombreEnfermedad, String tratamientoEnfermedad) {
		super();
		this.codigoEnfermedad = codigoEnfermedad;
		this.descripcion = descripcion;
		this.nombreEnfermedad = nombreEnfermedad;
		this.tratamientoEnfermedad = tratamientoEnfermedad;
	}

	public Enfermedad() {
	}

	public int getCodigoEnfermedad() {
		return this.codigoEnfermedad;
	}

	public void setCodigoEnfermedad(int codigoEnfermedad) {
		this.codigoEnfermedad = codigoEnfermedad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreEnfermedad() {
		return this.nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public String getTratamientoEnfermedad() {
		return this.tratamientoEnfermedad;
	}

	public void setTratamientoEnfermedad(String tratamientoEnfermedad) {
		this.tratamientoEnfermedad = tratamientoEnfermedad;
	}

	public List<HistorialAnimal> getHistorialAnimals() {
		return this.historialAnimals;
	}

	public void setHistorialAnimals(List<HistorialAnimal> historialAnimals) {
		this.historialAnimals = historialAnimals;
	}

}