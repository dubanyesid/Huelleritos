package co.edu.ufps.sorteo.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Data
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String documento;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to Boleta
	@OneToMany(mappedBy="personaBean")
	private List<Boleta> boletas;

	//bi-directional many-to-one association to Sorteo
	@ManyToOne
	@JoinColumn(name="sorteo")
	private Sorteo sorteoBean;

	public Persona() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Boleta> getBoletas() {
		return this.boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Boleta addBoleta(Boleta boleta) {
		getBoletas().add(boleta);
		boleta.setPersonaBean(this);

		return boleta;
	}

	public Boleta removeBoleta(Boleta boleta) {
		getBoletas().remove(boleta);
		boleta.setPersonaBean(null);

		return boleta;
	}

	public Sorteo getSorteoBean() {
		return this.sorteoBean;
	}

	public void setSorteoBean(Sorteo sorteoBean) {
		this.sorteoBean = sorteoBean;
	}

}