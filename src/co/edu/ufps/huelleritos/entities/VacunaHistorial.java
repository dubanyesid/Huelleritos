package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vacuna_historial database table.
 * 
 */
@Entity
@Table(name="vacuna_historial")
@NamedQuery(name="VacunaHistorial.findAll", query="SELECT v FROM VacunaHistorial v")
public class VacunaHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vacuna_historial")
	private int idVacunaHistorial;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vacunacion")
	private Date fechaVacunacion;

	//bi-directional many-to-one association to HistorialAnimal
	@ManyToOne
	@JoinColumn(name="id_historial")
	private HistorialAnimal historialAnimal;

	//bi-directional many-to-one association to Vacuna
	@ManyToOne
	@JoinColumn(name="codigo_vacuna")
	private Vacuna vacuna;

	public VacunaHistorial() {
	}

	public int getIdVacunaHistorial() {
		return this.idVacunaHistorial;
	}

	public void setIdVacunaHistorial(int idVacunaHistorial) {
		this.idVacunaHistorial = idVacunaHistorial;
	}

	public Date getFechaVacunacion() {
		return this.fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public HistorialAnimal getHistorialAnimal() {
		return this.historialAnimal;
	}

	public void setHistorialAnimal(HistorialAnimal historialAnimal) {
		this.historialAnimal = historialAnimal;
	}

	public Vacuna getVacuna() {
		return this.vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

}