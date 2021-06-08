package co.edu.ufps.huelleritos.dao;

import co.edu.ufps.huelleritos.entities.HogarDePaso;
import co.edu.ufps.huelleritos.util.Conexion;

public class HogarDePasoDAO extends Conexion<HogarDePaso> implements GenericDAO<HogarDePaso>{
	public HogarDePasoDAO() {
		super(HogarDePaso.class);
	}
}	