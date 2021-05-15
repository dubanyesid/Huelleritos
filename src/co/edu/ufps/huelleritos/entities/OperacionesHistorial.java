package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operaciones_historial database table.
 * 
 */
@Entity
@Table(name="operaciones_historial")
@NamedQuery(name="OperacionesHistorial.findAll", query="SELECT o FROM OperacionesHistorial o")
public class OperacionesHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_operacion")
	private Date fechaOperacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recuperacion")
	private Date fechaRecuperacion;

	@Lob
	private String observaciones;

	//bi-directional many-to-one association to HistorialAnimal
	@ManyToOne
	@JoinColumn(name="id_historial_animal")
	private HistorialAnimal historialAnimal;

	//bi-directional many-to-one association to OperacionesAnimal
	@ManyToOne
	@JoinColumn(name="id_operaciones_animal")
	private OperacionesAnimal operacionesAnimal;

	public OperacionesHistorial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public OperacionesAnimal getOperacionesAnimal() {
		return this.operacionesAnimal;
	}

	public void setOperacionesAnimal(OperacionesAnimal operacionesAnimal) {
		this.operacionesAnimal = operacionesAnimal;
	}

}