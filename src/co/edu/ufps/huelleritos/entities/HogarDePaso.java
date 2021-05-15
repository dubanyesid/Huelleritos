package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hogar_de_paso database table.
 * 
 */
@Entity
@Table(name="hogar_de_paso")
@NamedQuery(name="HogarDePaso.findAll", query="SELECT h FROM HogarDePaso h")
public class HogarDePaso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int usuario_DNI;

	private String direccion;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	private Formulario formulario;

	//bi-directional many-to-one association to SeguimientoAnimal
	@ManyToOne
	@JoinColumn(name="codigo_seguimiento")
	private SeguimientoAnimal seguimientoAnimal;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	private Usuario usuario;

	public HogarDePaso() {
	}

	public int getUsuario_DNI() {
		return this.usuario_DNI;
	}

	public void setUsuario_DNI(int usuario_DNI) {
		this.usuario_DNI = usuario_DNI;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

}