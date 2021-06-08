package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noticia_evento database table.
 * 
 */
@Entity
@Table(name="noticia_evento")
@NamedQuery(name="NoticiaEvento.findAll", query="SELECT n FROM NoticiaEvento n")
public class NoticiaEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_noticia_evento")
	private int idNoticiaEvento;

	@Lob
	private String descripcion;

	private String imgane;

	private String titulo;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	@JoinColumn(name="id_administrador")
	private Administrador administrador;

	public NoticiaEvento() {
	}

	public NoticiaEvento(int idNoticiaEvento, String descripcion, String imgane, String titulo) {
		super();
		this.idNoticiaEvento = idNoticiaEvento;
		this.descripcion = descripcion;
		this.imgane = imgane;
		this.titulo = titulo;
	}

	public int getIdNoticiaEvento() {
		return this.idNoticiaEvento;
	}

	public void setIdNoticiaEvento(int idNoticiaEvento) {
		this.idNoticiaEvento = idNoticiaEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImgane() {
		return this.imgane;
	}

	public void setImgane(String imgane) {
		this.imgane = imgane;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}