package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	private int dni;

	private String apellido;

	private String contraseña;

	private String correo;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="usuario")
	private List<Administrador> administradors;

	//bi-directional one-to-one association to Adoptante
	@OneToOne(mappedBy="usuario")
	private Adoptante adoptante;

	//bi-directional one-to-one association to HogarDePaso
	@OneToOne(mappedBy="usuario")
	private HogarDePaso hogarDePaso;

	public Usuario() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setUsuario(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setUsuario(null);

		return administrador;
	}

	public Adoptante getAdoptante() {
		return this.adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}

	public HogarDePaso getHogarDePaso() {
		return this.hogarDePaso;
	}

	public void setHogarDePaso(HogarDePaso hogarDePaso) {
		this.hogarDePaso = hogarDePaso;
	}

}