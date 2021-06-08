package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the prioridad database table.
 * 
 */
@Entity
@NamedQuery(name="Prioridad.findAll", query="SELECT p FROM Prioridad p")
public class Prioridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prioridad")
	private int idPrioridad;

	private String prioridad;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="prioridad")
	private List<Animal> animals = new ArrayList();

	
	public Prioridad(int idPrioridad, String prioridad) {
		super();
		this.idPrioridad = idPrioridad;
		this.prioridad = prioridad;
	}

	public Prioridad() {
	}
	
	public int getIdPrioridad() {
		return this.idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setPrioridad(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setPrioridad(null);

		return animal;
	}

}