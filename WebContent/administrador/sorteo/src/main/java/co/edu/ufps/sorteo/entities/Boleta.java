package co.edu.ufps.sorteo.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the boleta database table.
 * 
 */
@Entity
@Data
@Table(name="boleta")
@NamedQuery(name="Boleta.findAll", query="SELECT b FROM Boleta b")
public class Boleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int boleta;

	private Timestamp fecha;

	private int ganadora;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="persona")
	private Persona personaBean;

	//bi-directional many-to-one association to Sorteo
	@ManyToOne
	@JoinColumn(name="sorteo")
	private Sorteo sorteoBean;

	//bi-directional many-to-one association to Numero
	@OneToMany(mappedBy="boletaBean")
	private List<Numero> numeros;

	public Boleta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoleta() {
		return this.boleta;
	}

	public void setBoleta(int boleta) {
		this.boleta = boleta;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getGanadora() {
		return this.ganadora;
	}

	public void setGanadora(int ganadora) {
		this.ganadora = ganadora;
	}

	public Persona getPersonaBean() {
		return this.personaBean;
	}

	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	public Sorteo getSorteoBean() {
		return this.sorteoBean;
	}

	public void setSorteoBean(Sorteo sorteoBean) {
		this.sorteoBean = sorteoBean;
	}

	public List<Numero> getNumeros() {
		return this.numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	public Numero addNumero(Numero numero) {
		getNumeros().add(numero);
		numero.setBoletaBean(this);

		return numero;
	}

	public Numero removeNumero(Numero numero) {
		getNumeros().remove(numero);
		numero.setBoletaBean(null);

		return numero;
	}

}