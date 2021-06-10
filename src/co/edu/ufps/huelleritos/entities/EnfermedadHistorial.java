package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the enfermedad_historial database table.
 * 
 */
@Entity
@Table(name="enfermedad_historial")
@NamedQuery(name="EnfermedadHistorial.findAll", query="SELECT e FROM EnfermedadHistorial e")
public class EnfermedadHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_enfermedad_historial")
	private int idEnfermedadHistorial;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to Enfermedad
	@ManyToOne
	@JoinColumn(name="codigo_enfermedad")
	private Enfermedad enfermedad;

	//bi-directional many-to-one association to HistorialAnimal
	@ManyToOne
	@JoinColumn(name="id_historial")
	private HistorialAnimal historialAnimal;

	public EnfermedadHistorial() {
	}

	public int getIdEnfermedadHistorial() {
		return this.idEnfermedadHistorial;
	}

	public void setIdEnfermedadHistorial(int idEnfermedadHistorial) {
		this.idEnfermedadHistorial = idEnfermedadHistorial;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Enfermedad getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public HistorialAnimal getHistorialAnimal() {
		return this.historialAnimal;
	}

	public void setHistorialAnimal(HistorialAnimal historialAnimal) {
		this.historialAnimal = historialAnimal;
	}

}