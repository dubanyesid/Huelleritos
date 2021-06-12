package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.FormularioPregunta;
import co.edu.ufps.huelleritos.util.Conexion;

public class FormularioPreguntaDAO extends Conexion<FormularioPregunta> implements GenericDAO<FormularioPregunta>{
	public FormularioPreguntaDAO() {
		super(FormularioPregunta.class);
	}
}				