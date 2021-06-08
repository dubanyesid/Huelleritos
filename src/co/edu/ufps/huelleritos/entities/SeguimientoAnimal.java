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
@NamedQuery(name="SeguimientoAnimal.findAll", query="SELECT s FROM SeguimientoAnimal s")
public class SeguimientoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_seguimiento")
	private int codigoSeguimiento;

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
	
	public SeguimientoAnimal(int codigoSeguimiento, Date fecha, String foto, String observacion, String video,
			Animal animal) {
		super();
		this.codigoSeguimiento = codigoSeguimiento;
		this.fecha = fecha;
		this.foto = foto;
		this.observacion = observacion;
		this.video = video;
		this.animal = animal;
	}

	public int getCodigoSeguimiento() {
		return this.codigoSeguimiento;
	}

	public void setCodigoSeguimiento(int codigoSeguimiento) {
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