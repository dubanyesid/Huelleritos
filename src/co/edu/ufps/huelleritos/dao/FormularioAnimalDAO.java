package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.FormularioAnimal;
import co.edu.ufps.huelleritos.entities.FormularioPregunta;
import co.edu.ufps.huelleritos.util.Conexion;

public class FormularioAnimalDAO extends Conexion<FormularioAnimal> implements GenericDAO<FormularioAnimal>{
	public FormularioAnimalDAO() {
		super(FormularioAnimal.class);
	}
}				