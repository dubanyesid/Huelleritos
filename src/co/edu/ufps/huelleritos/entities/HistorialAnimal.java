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

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="historialAnimal")
	private List<Animal> animals;

	//bi-directional many-to-many association to Enfermedad
	@ManyToMany
	@JoinTable(
		name="enfermedad_historial"
		, joinColumns={
			@JoinColumn(name="id_historial")
			}
		, inverseJoinColumns={
			@JoinColumn(name="codigo_enfermedad")
			}
		)
	private List<Enfermedad> enfermedads;

	//bi-directional many-to-one association to OperacionesHistorial
	@OneToMany(mappedBy="historialAnimal")
	private List<OperacionesHistorial> operacionesHistorials;

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

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setHistorialAnimal(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setHistorialAnimal(null);

		return animal;
	}

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public List<OperacionesHistorial> getOperacionesHistorials() {
		return this.operacionesHistorials;
	}

	public void setOperacionesHistorials(List<OperacionesHistorial> operacionesHistorials) {
		this.operacionesHistorials = operacionesHistorials;
	}

	public OperacionesHistorial addOperacionesHistorial(OperacionesHistorial operacionesHistorial) {
		getOperacionesHistorials().add(operacionesHistorial);
		operacionesHistorial.setHistorialAnimal(this);

		return operacionesHistorial;
	}

	public OperacionesHistorial removeOperacionesHistorial(OperacionesHistorial operacionesHistorial) {
		getOperacionesHistorials().remove(operacionesHistorial);
		operacionesHistorial.setHistorialAnimal(null);

		return operacionesHistorial;
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