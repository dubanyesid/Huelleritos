package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity(name="noticia")

@NamedQueries({@NamedQuery(name="Noticia.findAll", query="SELECT n FROM noticia n"),
	@NamedQuery(name="Noticia.findAllEventos", query="SELECT n FROM noticia n WHERE n.tipoNoticia.idTipoNoticia=2"),
	@NamedQuery(name="Noticia.findAllEvidencias", query="SELECT n FROM noticia n WHERE n.tipoNoticia.idTipoNoticia=1")})

public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_noticia")
	private int idNoticia;

	@Lob
	private String descripcion;

	@Lob
	private String imagen;

	private String titulo;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	@JoinColumn(name="id_administrador")
	private Administrador administrador;

	//bi-directional many-to-one association to TipoNoticia
	@ManyToOne
	@JoinColumn(name="idtipo_noticia")
	private TipoNoticia tipoNoticia;

	public Noticia() {
	}

	public int getIdNoticia() {
		return this.idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
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

	public TipoNoticia getTipoNoticia() {
		return this.tipoNoticia;
	}

	public void setTipoNoticia(TipoNoticia tipoNoticia) {
		this.tipoNoticia = tipoNoticia;
	}

}