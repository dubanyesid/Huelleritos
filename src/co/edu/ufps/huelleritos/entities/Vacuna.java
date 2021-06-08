package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vacuna database table.
 * 
 */
@Entity

@NamedQueries({ @NamedQuery(name = "Vacuna.getMaxID", query = "Select max(v.codigoVacuna) as maxid from Vacuna v"),
	@NamedQuery(name="Vacuna.findAll", query="SELECT v FROM Vacuna v") })

public class Vacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_vacuna")
	private String codigoVacuna;

	@Lob
	private String descripcion;

	@Column(name="nombre_vacuna")
	private String nombreVacuna;

	//bi-directional many-to-one association to VacunaHistorial
	@OneToMany(mappedBy="vacuna")
	private List<VacunaHistorial> vacunaHistorials;

	public Vacuna() {
	}

	public String getCodigoVacuna() {
		return this.codigoVacuna;
	}

	public void setCodigoVacuna(String codigoVacuna) {
		this.codigoVacuna = codigoVacuna;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreVacuna() {
		return this.nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public List<VacunaHistorial> getVacunaHistorials() {
		return this.vacunaHistorials;
	}

	public void setVacunaHistorials(List<VacunaHistorial> vacunaHistorials) {
		this.vacunaHistorials = vacunaHistorials;
	}

	public VacunaHistorial addVacunaHistorial(VacunaHistorial vacunaHistorial) {
		getVacunaHistorials().add(vacunaHistorial);
		vacunaHistorial.setVacuna(this);

		return vacunaHistorial;
	}

	public VacunaHistorial removeVacunaHistorial(VacunaHistorial vacunaHistorial) {
		getVacunaHistorials().remove(vacunaHistorial);
		vacunaHistorial.setVacuna(null);

		return vacunaHistorial;
	}

}