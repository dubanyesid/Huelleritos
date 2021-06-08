package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	private String codigoEnfermedad;

	private String descripcion;

	@Column(name="nombre_enfermedad")
	private String nombreEnfermedad;

	@Column(name="tratamiento_enfermedad")
	private String tratamientoEnfermedad;

	//bi-directional many-to-one association to EnfermedadHistorial
	@OneToMany(mappedBy="enfermedad")
	private List<EnfermedadHistorial> enfermedadHistorials;

	public Enfermedad() {
	}

	public String getCodigoEnfermedad() {
		return this.codigoEnfermedad;
	}

	public void setCodigoEnfermedad(String codigoEnfermedad) {
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

	public List<EnfermedadHistorial> getEnfermedadHistorials() {
		return this.enfermedadHistorials;
	}

	public void setEnfermedadHistorials(List<EnfermedadHistorial> enfermedadHistorials) {
		this.enfermedadHistorials = enfermedadHistorials;
	}

	public EnfermedadHistorial addEnfermedadHistorial(EnfermedadHistorial enfermedadHistorial) {
		getEnfermedadHistorials().add(enfermedadHistorial);
		enfermedadHistorial.setEnfermedad(this);

		return enfermedadHistorial;
	}

	public EnfermedadHistorial removeEnfermedadHistorial(EnfermedadHistorial enfermedadHistorial) {
		getEnfermedadHistorials().remove(enfermedadHistorial);
		enfermedadHistorial.setEnfermedad(null);

		return enfermedadHistorial;
	}

}