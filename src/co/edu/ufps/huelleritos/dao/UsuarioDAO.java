package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Usuario;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class UsuarioDAO extends Conexion<Usuario> implements GenericDAO<Usuario>{
	public UsuarioDAO() {
		super(Usuario.class);
	}
}
