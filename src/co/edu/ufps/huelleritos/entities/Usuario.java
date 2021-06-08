package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private String contraseña;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="usuarioBean")
	private List<Administrador> administradors = new ArrayList();

	//bi-directional one-to-one association to Adoptante
	@OneToOne(mappedBy="usuarioBean")
	private Adoptante adoptante;

	//bi-directional many-to-one association to Formulario
	@OneToMany(mappedBy="usuarioBean")
	private List<Formulario> formularios = new ArrayList();

	//bi-directional one-to-one association to HogarDePaso
	@OneToOne(mappedBy="usuarioBean")
	private HogarDePaso hogarDePaso;

	public Usuario() {
	}

	public Usuario(String usuario, String contraseña, Adoptante adoptante, HogarDePaso hogarDePaso) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.adoptante = adoptante;
		this.hogarDePaso = hogarDePaso;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setUsuarioBean(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setUsuarioBean(null);

		return administrador;
	}

	public Adoptante getAdoptante() {
		return this.adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public Formulario addFormulario(Formulario formulario) {
		getFormularios().add(formulario);
		formulario.setUsuarioBean(this);

		return formulario;
	}

	public Formulario removeFormulario(Formulario formulario) {
		getFormularios().remove(formulario);
		formulario.setUsuarioBean(null);

		return formulario;
	}

	public HogarDePaso getHogarDePaso() {
		return this.hogarDePaso;
	}

	public void setHogarDePaso(HogarDePaso hogarDePaso) {
		this.hogarDePaso = hogarDePaso;
	}

}