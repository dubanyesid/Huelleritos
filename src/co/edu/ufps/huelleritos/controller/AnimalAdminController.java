package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.EstadoAnimalDAO;
import co.edu.ufps.huelleritos.dao.GuarderiaDAO;
import co.edu.ufps.huelleritos.dao.PrioridadDAO;
import co.edu.ufps.huelleritos.dao.SeguimientoAnimalDAO;
import co.edu.ufps.huelleritos.dao.TipoAnimalDAO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.Guarderia;
import co.edu.ufps.huelleritos.entities.Prioridad;
import co.edu.ufps.huelleritos.entities.SeguimientoAnimal;
import co.edu.ufps.huelleritos.entities.TipoAnimal;

/**
 * Servlet implementation class AnimalAdminController
 */
@WebServlet({"/admin/animal", "/admin/animal/listar", "/admin/animal/eliminar", "/admin/animal/editar","/admin/animal/seguimiento",
	"/admin/animal/editar/enviar", "/admin/animal/agregar", "/admin/animal/agregar/enviar",
	"/admin/animal/historial", "/admin/animal/historial/vacuna"})
public class AnimalAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnimalDAO animalDAO;
	private TipoAnimalDAO tipoAnimalDAO;
	private GuarderiaDAO guarderiaDAO;
	private PrioridadDAO prioridadDAO;
	private EstadoAnimalDAO estadoAnimalDAO;
	private SeguimientoAnimalDAO seguimientoAnimalDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalAdminController() {
        super();
        animalDAO = new AnimalDAO();
        tipoAnimalDAO = new TipoAnimalDAO();
		guarderiaDAO = new GuarderiaDAO();
		prioridadDAO = new PrioridadDAO();
		estadoAnimalDAO = new EstadoAnimalDAO();
		seguimientoAnimalDAO = new SeguimientoAnimalDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String estoy = path.replace("/admin", "");

		if (request.getSession().getAttribute("usuario") == null
				|| request.getSession().getAttribute("tipoUsuario") == null
				|| !request.getSession().getAttribute("tipoUsuario").equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/Usuario/Login");
			return;
		}

		if (path.equals("/admin")) {
			// request.getRequestDispatcher("/inicioAdmin.jsp").include(request, response);
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
		} else if (estoy.contains("/animal")) {
			String ubicacion = estoy.replace("/animal", "");
			animales(request, response, ubicacion);
		}
	}

	protected void animales(HttpServletRequest request, HttpServletResponse response, String estoy)
			throws ServletException, IOException {
		switch (estoy) {
		case "/historial":
			showViewHistorial(request, response);
			break;
		case "/listar":
			showViewListar(request, response);
			break;
		case "/agregar":
			showViewAgregar(request, response);
			break;
		case "/editar":
			showViewEditar(request, response);
			break;
		case "/eliminar":
			eliminarAnimal(request, response);
			break;
		case "/seguimiento":
			seguimientoAnimal(request, response);
			break;
		case "/agregar/enviar":
			registrarAnimal(request, response);
			break;
		case "/editar/enviar":
			editarAnimal(request, response);
			break;
		default:
			request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
			break;
		}

	}

	protected void showViewHistorial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoAnimal = request.getParameter("animal");
		if (codigoAnimal == null) {
			// ERROR
			// return;
		}

		Animal animalBuscado = animalDAO.find(codigoAnimal);

		request.setAttribute("historial", animalBuscado.getHistorialAnimals().get(0));
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/historial-clinico.jsp").forward(request, response);

	}

	protected void showViewListar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Animal> animales = animalDAO.list();
		request.setAttribute("animales", animales);
		// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
		request.getRequestDispatcher("/lista-animales.jsp").include(request, response);

	}

	protected void showViewAgregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TipoAnimal> tipoAnimales = tipoAnimalDAO.list();
		List<Prioridad> prioridades = prioridadDAO.list();
		List<Guarderia> guarderias = guarderiaDAO.list();
		request.setAttribute("tipos", tipoAnimales);
		request.setAttribute("prioridades", prioridades);
		request.setAttribute("guarderias", guarderias);
		request.getRequestDispatcher("/formulario-animal.jsp").include(request, response);

	}

	protected void showViewEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoAnimal = request.getParameter("animal");
		if (codigoAnimal == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animalBuscado = animalDAO.find(codigoAnimal);
		List<TipoAnimal> tipoAnimales = tipoAnimalDAO.list();
		List<Prioridad> prioridades = prioridadDAO.list();
		List<Guarderia> guarderias = guarderiaDAO.list();
		request.setAttribute("tipos", tipoAnimales);
		request.setAttribute("prioridades", prioridades);
		request.setAttribute("guarderias", guarderias);
		request.setAttribute("animal", animalBuscado);
		request.getRequestDispatcher("/editar-animal.jsp").include(request, response);

	}

	protected void eliminarAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoanimal = request.getParameter("animal");

		if (codigoanimal == null) {
			// ERROR response.sendredired();
			// return;
		}
		Animal animal = animalDAO.find(codigoanimal);
		if (animal == null) {
			// ERROR
			// return;
		}
		animalDAO.deleteClearCache(animal);
		response.sendRedirect(request.getContextPath() + "/admin/animal/listar");

	}
	
	protected void seguimientoAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idAnimal = request.getParameter("animal");
		
		if(idAnimal!=null) {
		List<SeguimientoAnimal> seg = seguimientoAnimalDAO.buscarSeguimientosPorAnimal(idAnimal);
		request.setAttribute("seguimientos", seg);
		// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
		request.getRequestDispatcher("/lista-seguimiento.jsp").forward(request, response);
		}

	}

	protected void registrarAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo"), nombre = request.getParameter("nombre"),
				tipo = request.getParameter("tipo"), fecha = request.getParameter("fecha"),
				sexo = request.getParameter("sexo"), raza = request.getParameter("raza"),
				edad = request.getParameter("edad"), peso = request.getParameter("peso"),
				color = request.getParameter("color"), guarderia = request.getParameter("guarderia"),
				prioridad = request.getParameter("prioridad"), descripcion = request.getParameter("descripcion"),
				foto = request.getParameter("archivo");
		System.out.println(fecha);
		boolean validos = validarParametros(request, response, codigo, nombre, tipo, fecha, sexo, raza, edad, peso,
				color, guarderia, prioridad, descripcion, foto);

		if (validos) {
			registroAnimal(request, response, codigo, nombre, tipo, fecha, sexo, raza, edad, peso,
				color, guarderia, prioridad, descripcion, foto);
		}
	}

	private void registroAnimal(HttpServletRequest request, HttpServletResponse response,String codigo,
			String nombre, String tipo, String fecha, String sexo, String raza, String edad, String peso, String color,
			String guarderia, String prioridad, String descripcion, String foto)
			throws ServletException, IOException {
		
		if (animalDAO.find(codigo) != null) {
			request.setAttribute("mensaje", "Ya existe el animal");
			request.getRequestDispatcher("/Error").forward(request, response);
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngreso = null;
		try {
			fechaIngreso = sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Animal animal = new Animal(codigo, color, descripcion, Integer.valueOf(edad), fechaIngreso, foto, nombre, peso,
				raza, sexo);
		int idTipo = Integer.parseInt(tipo);
		int idPrioridad = Integer.parseInt(prioridad);
		setAnimal(request,response,animal,idTipo, idPrioridad,guarderia);
		
		response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	}
	
	private void setAnimal(HttpServletRequest request, HttpServletResponse response, Animal animal, 
			int idTipo, int idPrioridad, String guarderia) throws ServletException, IOException {
		animal.setTipoAnimal(tipoAnimalDAO.find(idTipo));
		animal.setPrioridad(prioridadDAO.find(idPrioridad));
		animal.setGuarderia(guarderiaDAO.find(guarderia));
		animal.setEstadoAnimalBean(estadoAnimalDAO.find(3));
		animal.iniciarHistoria();
		animalDAO.insert(animal);
	}

	private boolean validarParametros(HttpServletRequest request, HttpServletResponse response, String codigo,
			String nombre, String tipo, String fecha, String sexo, String raza, String edad, String peso, String color,
			String guarderia, String prioridad, String descripcion, String foto) throws ServletException, IOException {
		if (codigo == null || nombre == null || tipo == null || fecha == null || sexo == null || raza == null
				|| edad == null || peso == null || color == null || guarderia == null || prioridad == null
				|| descripcion == null || foto == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/agregar?error=faltaAlgo");
			return false;
		}
		if (codigo.equals("") || nombre.equals("") || tipo.equals("") || fecha.equals("") || sexo.equals("")
				|| raza.equals("") || edad.equals("") || peso.equals("") || color.equals("") || guarderia.equals("")
				|| prioridad.equals("") || descripcion.equals("") || foto.equals("")) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/agregar?error=faltaAlgo");
			return false;
		}
		return true;
	}

	protected void editarAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo"), nombre = request.getParameter("nombre"),
				tipo = request.getParameter("tipo"), fecha = request.getParameter("fecha"),
				sexo = request.getParameter("sexo"), raza = request.getParameter("raza"),
				edad = request.getParameter("edad"), peso = request.getParameter("peso"),
				color = request.getParameter("color"), guarderia = request.getParameter("guarderia"),
				prioridad = request.getParameter("prioridad"), descripcion = request.getParameter("descripcion"),
				foto = request.getParameter("archivo");
		System.out.println(fecha);
		boolean validos = validarParametros(request, response, codigo, nombre, tipo, fecha, sexo, raza, edad, peso,
				color, guarderia, prioridad, descripcion, foto);

		if (validos) {
			int idTipo = Integer.parseInt(tipo);
			int idPrioridad = Integer.parseInt(prioridad);
			if (animalDAO.find(codigo) != null) {
				// ERROR YA EXISTE;
				// return;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaIngreso = null;
			try {
				fechaIngreso = sdf.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Animal animal = animalDAO.find(codigo);
			animal.setColor(color);
			animal.setDescripcion(descripcion);
			animal.setEdad(Integer.valueOf(edad));
			animal.setFechaIngreso(fechaIngreso);
			animal.setImagenAnimal(foto);
			animal.setNombreAnimal(nombre);
			animal.setPeso(peso);
			animal.setRaza(raza);
			animal.setSexo(sexo);
			animal.setTipoAnimal(tipoAnimalDAO.find(idTipo));
			animal.setPrioridad(prioridadDAO.find(idPrioridad));
			animal.setGuarderia(guarderiaDAO.find(guarderia));
			animalDAO.update(animal);
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
