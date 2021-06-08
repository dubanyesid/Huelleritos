package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the estado_animal database table.
 * 
 */
@Entity
@Table(name="estado_animal")
@NamedQuery(name="EstadoAnimal.findAll", query="SELECT e FROM EstadoAnimal e")
public class EstadoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="estadoAnimalBean")
	private List<Animal> animals = new ArrayList();

	public EstadoAnimal(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public EstadoAnimal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setEstadoAnimalBean(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setEstadoAnimalBean(null);

		return animal;
	}

}