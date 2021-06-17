package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the guarderia database table.
 * 
 */
@Entity(name="guarderia")
@NamedQuery(name="Guarderia.findAll", query="SELECT g FROM guarderia g")
public class Guarderia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_guarderia")
	private String nombreGuarderia;

	private String direccion;

	private double mensualidad;

	private String telefono;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="guarderia")
	private List<Animal> animals;

	public Guarderia() {
	}

	public String getNombreGuarderia() {
		return this.nombreGuarderia;
	}

	public void setNombreGuarderia(String nombreGuarderia) {
		this.nombreGuarderia = nombreGuarderia;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getMensualidad() {
		return this.mensualidad;
	}

	public void setMensualidad(double mensualidad) {
		this.mensualidad = mensualidad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setGuarderia(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setGuarderia(null);

		return animal;
	}

}