package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noticia_evidencia database table.
 * 
 */
@Entity
@Table(name="noticia_evidencia")
@NamedQuery(name="NoticiaEvidencia.findAll", query="SELECT n FROM NoticiaEvidencia n")
public class NoticiaEvidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_noticia_evidencia")
	private int idNoticiaEvidencia;

	@Lob
	private String descripcion;

	private String imagen;

	private String titulo;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	@JoinColumn(name="id_administrador")
	private Administrador administrador;

	public NoticiaEvidencia() {
	}
	

	public NoticiaEvidencia(int idNoticiaEvidencia, String descripcion, String imagen, String titulo) {
		super();
		this.idNoticiaEvidencia = idNoticiaEvidencia;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.titulo = titulo;
	}


	public int getIdNoticiaEvidencia() {
		return this.idNoticiaEvidencia;
	}

	public void setIdNoticiaEvidencia(int idNoticiaEvidencia) {
		this.idNoticiaEvidencia = idNoticiaEvidencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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