package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.util.Conexion;

public class FormularioDAO extends Conexion<Formulario> implements GenericDAO<Formulario>{
	public FormularioDAO() {
		super(Formulario.class);
	}
}				