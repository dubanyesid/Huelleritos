package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_animal database table.
 * 
 */
@Entity
@Table(name="tipo_animal")
@NamedQuery(name="TipoAnimal.findAll", query="SELECT t FROM TipoAnimal t")
public class TipoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="tipoAnimal")
	private List<Animal> animals;

	public TipoAnimal() {
	}

	public TipoAnimal(String descripcion) {
		this.descripcion=descripcion;
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
		animal.setTipoAnimal(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setTipoAnimal(null);

		return animal;
	}

}