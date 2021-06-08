package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the tipo_noticia database table.
 * 
 */
@Entity
@Table(name="tipo_noticia")
@NamedQuery(name="TipoNoticia.findAll", query="SELECT t FROM TipoNoticia t")
public class TipoNoticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_noticia")
	private int idtipoNoticia;

	private String tipo;

	//bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy="tipoNoticia")
	private List<Noticia> noticias = new ArrayList();

	public TipoNoticia() {
	}
	
	public TipoNoticia(int idtipoNoticia, String tipo) {
		super();
		this.idtipoNoticia = idtipoNoticia;
		this.tipo = tipo;
	}

	public int getIdtipoNoticia() {
		return this.idtipoNoticia;
	}

	public void setIdtipoNoticia(int idtipoNoticia) {
		this.idtipoNoticia = idtipoNoticia;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setTipoNoticia(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setTipoNoticia(null);

		return noticia;
	}

}