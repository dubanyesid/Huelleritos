package co.edu.ufps.huelleritos.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.SeguimientoAnimal;
import co.edu.ufps.huelleritos.entities.Usuario;
import co.edu.ufps.huelleritos.negocio.Puntaje;
import co.edu.ufps.huelleritos.util.Conexion;

public class SeguimientoAnimalDAO extends Conexion<SeguimientoAnimal> implements GenericDAO<SeguimientoAnimal> {

	public SeguimientoAnimalDAO() {
		super(SeguimientoAnimal.class);
	}

	public SeguimientoAnimal findByAnimal(String codigoAnimal) {
		SeguimientoAnimal seguimientoAnimal = null;
		Query query = getEm().createNamedQuery(SeguimientoAnimal.class.getSimpleName() + ".findByAnimal",
				SeguimientoAnimal.class);
		query.setParameter("codigoAnimal", codigoAnimal);
		try {
			seguimientoAnimal = (SeguimientoAnimal) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return seguimientoAnimal;
	}

	public List<SeguimientoAnimal> buscarSeguimientosPorAnimal(String idAnimal) {
			Query consulta = getEm().createNativeQuery(
					"SELECT seguimiento_animal.codigo_seguimiento,seguimiento_animal.foto,seguimiento_animal.observacion,seguimiento_animal.fecha from animal"
					+ " INNER JOIN seguimiento_animal on seguimiento_animal.codigo_animal = animal.codigo_animal where animal.codigo_animal=:codigoanimal "
					+ "ORDER BY fecha DESC").setParameter("codigoanimal", idAnimal);
			List<Object []> lista = consulta.getResultList();
			List<SeguimientoAnimal> listSeguimientos =null;
			if(lista!=null) {
				listSeguimientos = new ArrayList<>();
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				for(Object [] s:lista) {
					
					try {
						listSeguimientos.add(new SeguimientoAnimal(s[0].toString(), sdf.parse(s[3].toString()), s[1].toString(),s[2].toString()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return listSeguimientos;
		}

}
