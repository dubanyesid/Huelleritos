package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the historial_animal database table.
 * 
 */
@Entity
@Table(name="historial_animal")
@NamedQuery(name="HistorialAnimal.findAll", query="SELECT h FROM HistorialAnimal h")
public class HistorialAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_historial_animal")
	private int idHistorialAnimal;

	private String observaciones;

	//bi-directional many-to-one association to EnfermedadHistorial
	@OneToMany(mappedBy="historialAnimal")
	private List<EnfermedadHistorial> enfermedadHistorials;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="codigo_animal")
	private Animal animal;

	//bi-directional many-to-one association to OperacionesAnimal
	@OneToMany(mappedBy="historialAnimal")
	private List<OperacionesAnimal> operacionesAnimals;

	//bi-directional many-to-one association to VacunaHistorial
	@OneToMany(mappedBy="historialAnimal")
	private List<VacunaHistorial> vacunaHistorials;

	public HistorialAnimal() {
	}

	public int getIdHistorialAnimal() {
		return this.idHistorialAnimal;
	}

	public void setIdHistorialAnimal(int idHistorialAnimal) {
		this.idHistorialAnimal = idHistorialAnimal;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<EnfermedadHistorial> getEnfermedadHistorials() {
		return this.enfermedadHistorials;
	}

	public void setEnfermedadHistorials(List<EnfermedadHistorial> enfermedadHistorials) {
		this.enfermedadHistorials = enfermedadHistorials;
	}

	public EnfermedadHistorial addEnfermedadHistorial(EnfermedadHistorial enfermedadHistorial) {
		getEnfermedadHistorials().add(enfermedadHistorial);
		enfermedadHistorial.setHistorialAnimal(this);

		return enfermedadHistorial;
	}

	public EnfermedadHistorial removeEnfermedadHistorial(EnfermedadHistorial enfermedadHistorial) {
		getEnfermedadHistorials().remove(enfermedadHistorial);
		enfermedadHistorial.setHistorialAnimal(null);

		return enfermedadHistorial;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<OperacionesAnimal> getOperacionesAnimals() {
		return this.operacionesAnimals;
	}

	public void setOperacionesAnimals(List<OperacionesAnimal> operacionesAnimals) {
		this.operacionesAnimals = operacionesAnimals;
	}

	public OperacionesAnimal addOperacionesAnimal(OperacionesAnimal operacionesAnimal) {
		getOperacionesAnimals().add(operacionesAnimal);
		operacionesAnimal.setHistorialAnimal(this);

		return operacionesAnimal;
	}

	public OperacionesAnimal removeOperacionesAnimal(OperacionesAnimal operacionesAnimal) {
		getOperacionesAnimals().remove(operacionesAnimal);
		operacionesAnimal.setHistorialAnimal(null);

		return operacionesAnimal;
	}

	public List<VacunaHistorial> getVacunaHistorials() {
		return this.vacunaHistorials;
	}

	public void setVacunaHistorials(List<VacunaHistorial> vacunaHistorials) {
		this.vacunaHistorials = vacunaHistorials;
	}

	public VacunaHistorial addVacunaHistorial(VacunaHistorial vacunaHistorial) {
		getVacunaHistorials().add(vacunaHistorial);
		vacunaHistorial.setHistorialAnimal(this);

		return vacunaHistorial;
	}

	public VacunaHistorial removeVacunaHistorial(VacunaHistorial vacunaHistorial) {
		getVacunaHistorials().remove(vacunaHistorial);
		vacunaHistorial.setHistorialAnimal(null);

		return vacunaHistorial;
	}

}