package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operaciones_animal database table.
 * 
 */
@Entity
@Table(name="operaciones_animal")
@NamedQuery(name="OperacionesAnimal.findAll", query="SELECT o FROM OperacionesAnimal o")
public class OperacionesAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_operaciones_animal")
	private int idOperacionesAnimal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_operacion")
	private Date fechaOperacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recuperacion")
	private Date fechaRecuperacion;

	@Column(name="nombre_operacion")
	private String nombreOperacion;

	private String observaciones;

	//bi-directional many-to-one association to HistorialAnimal
	@ManyToOne
	@JoinColumn(name="id_historial_animal")
	private HistorialAnimal historialAnimal;

	public OperacionesAnimal() {
	}

	public int getIdOperacionesAnimal() {
		return this.idOperacionesAnimal;
	}

	public void setIdOperacionesAnimal(int idOperacionesAnimal) {
		this.idOperacionesAnimal = idOperacionesAnimal;
	}

	public Date getFechaOperacion() {
		return this.fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public Date getFechaRecuperacion() {
		return this.fechaRecuperacion;
	}

	public void setFechaRecuperacion(Date fechaRecuperacion) {
		this.fechaRecuperacion = fechaRecuperacion;
	}

	public String getNombreOperacion() {
		return this.nombreOperacion;
	}

	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public HistorialAnimal getHistorialAnimal() {
		return this.historialAnimal;
	}

	public void setHistorialAnimal(HistorialAnimal historialAnimal) {
		this.historialAnimal = historialAnimal;
	}

}