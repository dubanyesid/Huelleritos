package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formulario_animal database table.
 * 
 */
@Entity
@Table(name="formulario_animal")
@NamedQuery(name="FormularioAnimal.findAll", query="SELECT f FROM FormularioAnimal f")
public class FormularioAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_formulario_animal")
	private int idFormularioAnimal;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="codigo_animal")
	private Animal animal;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="id_formulario")
	private Formulario formulario;

	public FormularioAnimal() {
	}
	
	public FormularioAnimal(int idFormularioAnimal, Animal animal, Formulario formulario) {
		super();
		this.idFormularioAnimal = idFormularioAnimal;
		this.animal = animal;
		this.formulario = formulario;
	}



	public int getIdFormularioAnimal() {
		return this.idFormularioAnimal;
	}

	public void setIdFormularioAnimal(int idFormularioAnimal) {
		this.idFormularioAnimal = idFormularioAnimal;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

}