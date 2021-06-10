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
	private String usuario;

	private String direccion;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public HogarDePaso() {
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}