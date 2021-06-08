package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adoptante database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Adoptante.getMaxID", query = "Select max(a.usuario_DNI) as maxid from Adoptante a"),
	@NamedQuery(name="Adoptante.findAll", query="SELECT a FROM Adoptante a") })
public class Adoptante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int usuario_DNI;

	private String estado;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="id_formulario")
	private Formulario formulario;

	//bi-directional many-to-one association to SeguimientoAnimal
	@ManyToOne
	@JoinColumn(name="codigo_seguimiento")
	private SeguimientoAnimal seguimientoAnimal;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	private Usuario usuario;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="adoptante")
	private List<Animal> animals;

	public Adoptante() {
	}

	public int getUsuario_DNI() {
		return this.usuario_DNI;
	}

	public void setUsuario_DNI(int usuario_DNI) {
		this.usuario_DNI = usuario_DNI;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public SeguimientoAnimal getSeguimientoAnimal() {
		return this.seguimientoAnimal;
	}

	public void setSeguimientoAnimal(SeguimientoAnimal seguimientoAnimal) {
		this.seguimientoAnimal = seguimientoAnimal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setAdoptante(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setAdoptante(null);

		return animal;
	}

}