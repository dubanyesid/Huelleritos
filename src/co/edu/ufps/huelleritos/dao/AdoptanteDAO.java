package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.Adoptante;
import co.edu.ufps.huelleritos.util.Conexion;
import co.edu.ufps.huelleritos.util.GenericDAO;

public class AdoptanteDAO extends Conexion<Adoptante> implements GenericDAO<Adoptante> {
	public AdoptanteDAO(){
		super(Adoptante.class);
	}
}
