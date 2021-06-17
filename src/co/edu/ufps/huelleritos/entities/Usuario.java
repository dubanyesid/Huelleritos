package co.edu.ufps.huelleritos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity(name="usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM usuario u"),
	@NamedQuery(name="Usuario.logAdmin", query="SELECT u FROM usuario u join u.administradors admin where u.usuario=:usuario and u.contrase�a=:contrasenia "),
	@NamedQuery(name="Usuario.logAdoptante", query="SELECT u FROM usuario u join u.adoptante adopta where u.usuario=:usuario and u.contrase�a=:contrasenia "),
	@NamedQuery(name="Usuario.logHogar", query="SELECT u FROM usuario u join u.hogarDePaso hogar where u.usuario=:usuario and u.contrase�a=:contrasenia ")


})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private String contrase�a;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="usuarioBean")
	private List<Administrador> administradors;

	//bi-directional one-to-one association to Adoptante
	@OneToOne(mappedBy="usuarioBean",cascade=CascadeType.PERSIST)
	private Adoptante adoptante;

	//bi-directional many-to-one association to Formulario
	@OneToMany(mappedBy="usuarioBean")
	private List<Formulario> formularios;

	//bi-directional one-to-one association to HogarDePaso
	@OneToOne(mappedBy="usuarioBean")
	private HogarDePaso hogarDePaso;

	public Usuario() {
	}
	
	public Usuario(String usuario, String contrase�a) {
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return this.contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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

	public void iniciarFormularios() {
		this.formularios=new ArrayList<Formulario>();
	}
	public void IniciarAdministradors() {
		this.administradors=new ArrayList<Administrador>();
	}
	public void IniciarAdoptante() {
		this.adoptante=new Adoptante();
	}
	public void IniciarHogar() {
		this.hogarDePaso=new HogarDePaso();
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

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrase�a=" + contrase�a + "]";
	}
	
	

}