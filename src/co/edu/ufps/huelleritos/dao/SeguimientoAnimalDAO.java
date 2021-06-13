package co.edu.ufps.huelleritos.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import co.edu.ufps.huelleritos.entities.SeguimientoAnimal;
import co.edu.ufps.huelleritos.util.Conexion;

public class SeguimientoAnimalDAO extends Conexion<SeguimientoAnimal> implements GenericDAO<SeguimientoAnimal>{

	public SeguimientoAnimalDAO() {
		super(SeguimientoAnimal.class);
	}
	
	
	public SeguimientoAnimal findByAnimal(String codigoAnimal) {
		SeguimientoAnimal seguimientoAnimal=null;
		Query query = getEm().createNamedQuery(SeguimientoAnimal.class.getSimpleName()+".findByAnimal",SeguimientoAnimal.class);
		query.setParameter("codigoAnimal", codigoAnimal);
		try {
			 seguimientoAnimal = (SeguimientoAnimal) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		return seguimientoAnimal;
	}
}
