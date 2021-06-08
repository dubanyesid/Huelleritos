package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Administrador.getMaxID", query = "Select max(a.idAdministrador) as maxid from Administrador a"),
	@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a") })

public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_administrador")
	private int idAdministrador;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to NoticiaEvento
	@OneToMany(mappedBy="administrador")
	private List<NoticiaEvento> noticiaEventos;

	//bi-directional many-to-one association to NoticiaEvidencia
	@OneToMany(mappedBy="administrador")
	private List<NoticiaEvidencia> noticiaEvidencias;

	public Administrador() {
	}

	public int getIdAdministrador() {
		return this.idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<NoticiaEvento> getNoticiaEventos() {
		return this.noticiaEventos;
	}

	public void setNoticiaEventos(List<NoticiaEvento> noticiaEventos) {
		this.noticiaEventos = noticiaEventos;
	}

	public NoticiaEvento addNoticiaEvento(NoticiaEvento noticiaEvento) {
		getNoticiaEventos().add(noticiaEvento);
		noticiaEvento.setAdministrador(this);

		return noticiaEvento;
	}

	public NoticiaEvento removeNoticiaEvento(NoticiaEvento noticiaEvento) {
		getNoticiaEventos().remove(noticiaEvento);
		noticiaEvento.setAdministrador(null);

		return noticiaEvento;
	}

	public List<NoticiaEvidencia> getNoticiaEvidencias() {
		return this.noticiaEvidencias;
	}

	public void setNoticiaEvidencias(List<NoticiaEvidencia> noticiaEvidencias) {
		this.noticiaEvidencias = noticiaEvidencias;
	}

	public NoticiaEvidencia addNoticiaEvidencia(NoticiaEvidencia noticiaEvidencia) {
		getNoticiaEvidencias().add(noticiaEvidencia);
		noticiaEvidencia.setAdministrador(this);

		return noticiaEvidencia;
	}

	public NoticiaEvidencia removeNoticiaEvidencia(NoticiaEvidencia noticiaEvidencia) {
		getNoticiaEvidencias().remove(noticiaEvidencia);
		noticiaEvidencia.setAdministrador(null);

		return noticiaEvidencia;
	}

}