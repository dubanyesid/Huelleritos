package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the seguimiento_animal database table.
 * 
 */
@Entity
@Table(name="seguimiento_animal")
@NamedQueries({@NamedQuery(name="SeguimientoAnimal.findAll", query="SELECT s FROM SeguimientoAnimal s"),
	@NamedQuery(name="SeguimientoAnimal.findByAnimal", query="SELECT s FROM SeguimientoAnimal s join s.animal a where a.codigoAnimal=:codigoAnimal")})
public class SeguimientoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_seguimiento")
	private String codigoSeguimiento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Lob
	private String foto;

	@Lob
	private String observacion;

	@Lob
	private String video;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="codigo_animal")
	private Animal animal;

	public SeguimientoAnimal() {
	}

	public SeguimientoAnimal(String codigoSeguimiento, Date fecha, String foto, String observacion) {
		super();
		this.codigoSeguimiento = codigoSeguimiento;
		this.fecha = fecha;
		this.foto = foto;
		this.observacion = observacion;
	}

	public String getCodigoSeguimiento() {
		return this.codigoSeguimiento;
	}

	public void setCodigoSeguimiento(String codigoSeguimiento) {
		this.codigoSeguimiento = codigoSeguimiento;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}