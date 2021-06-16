package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the adoptante database table.
 * 
 */
@Entity
@NamedQuery(name="Adoptante.findAll", query="SELECT a FROM Adoptante a")
public class Adoptante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private String estado;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Adoptante() {
	}

	public Adoptante(String usuario, String estado, Usuario usuarioBean) {
		this.usuario=usuario;
		this.estado=estado;
		this.usuarioBean=usuarioBean;
	}
	
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}