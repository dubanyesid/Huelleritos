package co.edu.ufps.huelleritos.dao;


import javax.persistence.EntityManager;

import co.edu.ufps.huelleritos.entities.Administrador;
import co.edu.ufps.huelleritos.util.Conexion;

public class AdministradorDAO extends Conexion<Administrador> implements GenericDAO<Administrador> {
	
	public AdministradorDAO(){
		super(Administrador.class);
	}
	
}