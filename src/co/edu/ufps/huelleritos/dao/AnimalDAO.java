package co.edu.ufps.huelleritos.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.negocio.Puntaje;
import co.edu.ufps.huelleritos.util.Conexion;

public class AnimalDAO extends Conexion<Animal> implements GenericDAO<Animal> {
	public AnimalDAO() {
		super(Animal.class);
		em = super.getEm();
	}

	EntityManager em;

	public List<Animal> listAdopcion() {
		TypedQuery<Animal> consulta = em.createNamedQuery(Animal.class.getSimpleName() + ".findAllAdopcion",
				Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}

	public List<Animal> listPrioridad() {
		TypedQuery<Animal> consulta = em.createNamedQuery(Animal.class.getSimpleName() + ".findAllPrioritario",
				Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}

	public List<Animal> listAdoptado() {
		TypedQuery<Animal> consulta = em.createNamedQuery(Animal.class.getSimpleName() + ".findAllAdoptado",
				Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}
	
	public List<Animal> listAdultos() {
		TypedQuery<Animal> consulta = em.createNamedQuery(Animal.class.getSimpleName() + ".findAllAdultos",
				Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}
	
	public List<Animal> listCachorros() {
		TypedQuery<Animal> consulta = em.createNamedQuery(Animal.class.getSimpleName() + ".findAllCachorros",
				Animal.class);
		List<Animal> lista = (List<Animal>) consulta.getResultList();
		return lista;
	}

	public List<Animal> listAnimalesByUsuario(String usuario) {
		Query query = getEm().createNativeQuery(
				"Select a.codigo_animal,a.nombre_animal,tanimal.descripcion from animal a INNER JOIN formulario_animal fanimal on fanimal.codigo_animal=a.codigo_animal INNER JOIN formulario on formulario.id_formulario=fanimal.id_formulario INNER JOIN usuario on usuario.usuario=formulario.usuario INNER JOIN adoptante on adoptante.usuario = usuario.usuario INNER JOIN tipo_animal tanimal on tanimal.id=a.tipo_animal_id where usuario.usuario=:usuario");
		query.setParameter("usuario", usuario);
		List<Object[]> animalesEncontrados = query.getResultList();

		return animalesEncontrados.stream()
				.map(animal -> new Animal((String) animal[0], (String) animal[1], (String) animal[2]))
				.collect(Collectors.toList());
	}

	public Animal buscarAnimalPorFormulario(String idFormulario) {
		Query query = getEm().createNativeQuery(
				"SELECT a.codigo_animal, a.nombre_animal FROM formulario_animal f join animal a on a.codigo_animal=f.codigo_animal AND f.id_formulario=:idFormulario");
		query.setParameter("idFormulario", idFormulario);
		System.out.println(query.toString());
		
		List<Object []> lista = query.getResultList();
		List<Animal> listAnimales =null;
		Animal an=null;
		if(lista!=null) {
			listAnimales = new ArrayList<>();
			for(Object [] s:lista) {
				an=this.find(s[0].toString());
				System.out.println("x "+an);
			}
		}
		
		return an;
	}
}