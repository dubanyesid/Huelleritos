package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the operaciones_animal database table.
 * 
 */
@Entity
@Table(name="operaciones_animal")
@NamedQuery(name="OperacionesAnimal.findAll", query="SELECT o FROM OperacionesAnimal o")
public class OperacionesAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_operaciones_animal")
	private int idOperacionesAnimal;

	@Column(name="nombre_operacion")
	private String nombreOperacion;

	//bi-directional many-to-one association to OperacionesHistorial
	@OneToMany(mappedBy="operacionesAnimal")
	private List<OperacionesHistorial> operacionesHistorials;

	public OperacionesAnimal() {
	}

	public int getIdOperacionesAnimal() {
		return this.idOperacionesAnimal;
	}

	public void setIdOperacionesAnimal(int idOperacionesAnimal) {
		this.idOperacionesAnimal = idOperacionesAnimal;
	}

	public String getNombreOperacion() {
		return this.nombreOperacion;
	}

	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}

	public List<OperacionesHistorial> getOperacionesHistorials() {
		return this.operacionesHistorials;
	}

	public void setOperacionesHistorials(List<OperacionesHistorial> operacionesHistorials) {
		this.operacionesHistorials = operacionesHistorials;
	}

	public OperacionesHistorial addOperacionesHistorial(OperacionesHistorial operacionesHistorial) {
		getOperacionesHistorials().add(operacionesHistorial);
		operacionesHistorial.setOperacionesAnimal(this);

		return operacionesHistorial;
	}

	public OperacionesHistorial removeOperacionesHistorial(OperacionesHistorial operacionesHistorial) {
		getOperacionesHistorials().remove(operacionesHistorial);
		operacionesHistorial.setOperacionesAnimal(null);

		return operacionesHistorial;
	}

}