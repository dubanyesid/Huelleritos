package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String foto;

	@Lob
	private String observacion;

	private String video;

	//bi-directional many-to-one association to Adoptante
	@OneToMany(mappedBy="seguimientoAnimal")
	private List<Adoptante> adoptantes;

	//bi-directional many-to-one association to HogarDePaso
	@OneToMany(mappedBy="seguimientoAnimal")
	private List<HogarDePaso> hogarDePasos;

	public SeguimientoAnimal() {
	}

	public int getCodigoSeguimiento() {
		return this.codigoSeguimiento;
	}

	public void setCodigoSeguimiento(int codigoSeguimiento) {
		this.codigoSeguimiento = codigoSeguimiento;
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

	public List<Adoptante> getAdoptantes() {
		return this.adoptantes;
	}

	public void setAdoptantes(List<Adoptante> adoptantes) {
		this.adoptantes = adoptantes;
	}

	public Adoptante addAdoptante(Adoptante adoptante) {
		getAdoptantes().add(adoptante);
		adoptante.setSeguimientoAnimal(this);

		return adoptante;
	}

	public Adoptante removeAdoptante(Adoptante adoptante) {
		getAdoptantes().remove(adoptante);
		adoptante.setSeguimientoAnimal(null);

		return adoptante;
	}

	public List<HogarDePaso> getHogarDePasos() {
		return this.hogarDePasos;
	}

	public void setHogarDePasos(List<HogarDePaso> hogarDePasos) {
		this.hogarDePasos = hogarDePasos;
	}

	public HogarDePaso addHogarDePaso(HogarDePaso hogarDePaso) {
		getHogarDePasos().add(hogarDePaso);
		hogarDePaso.setSeguimientoAnimal(this);

		return hogarDePaso;
	}

	public HogarDePaso removeHogarDePaso(HogarDePaso hogarDePaso) {
		getHogarDePasos().remove(hogarDePaso);
		hogarDePaso.setSeguimientoAnimal(null);

		return hogarDePaso;
	}

}