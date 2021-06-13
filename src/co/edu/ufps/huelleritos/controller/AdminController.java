package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.text.DateFormat;
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
import co.edu.ufps.huelleritos.dao.TipoAnimalDAO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.EstadoAnimal;
import co.edu.ufps.huelleritos.entities.Guarderia;
import co.edu.ufps.huelleritos.entities.Prioridad;
import co.edu.ufps.huelleritos.entities.TipoAnimal;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({ "/admin", "/admin/animal", "/admin/animal/listar", "/admin/animal/agregar","/admin/animal/agregar/enviar",
	"/admin/animal/historial"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	TipoAnimalDAO tipoAnimalDAO;
	GuarderiaDAO guarderiaDAO;
	PrioridadDAO prioridadDAO;
	AnimalDAO animalDAO;
	EstadoAnimalDAO estadoAnimalDAO;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		tipoAnimalDAO=new TipoAnimalDAO();
		guarderiaDAO=new GuarderiaDAO();
		prioridadDAO=new PrioridadDAO();
		animalDAO=new AnimalDAO();
		estadoAnimalDAO=new EstadoAnimalDAO();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String estoy = path.replace("/admin", "");
		
		if(request.getSession().getAttribute("usuario")==null || request.getSession().getAttribute("tipoUsuario")==null || !request.getSession().getAttribute("tipoUsuario").equals("admin") ) {
			response.sendRedirect(request.getContextPath()+"/Usuario/Login");
			return;
		}
		
		if (path.equals("/admin")) {
			request.getRequestDispatcher("/inicioAdmin.jsp").include(request, response);
		} else if (estoy.contains("/animal")) {
			String ubicacion = estoy.replace("/animal", "");
			animales(request, response, ubicacion);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void animales(HttpServletRequest request, HttpServletResponse response, String estoy)
			throws ServletException, IOException {
		switch (estoy) {
		case "/historial":
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/historial-clinico.jsp").forward(request, response);
			break;
		case "/listar":
			showViewListar(request, response);
			break;
		case "/agregar":
			showViewAgregar(request, response);
			break;
		case "/agregar/enviar":
			registrarAnimal(request, response);
			break;
		default:
			// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
			request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
			break;
		}
		
		
	}
	
	protected void registrarAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo=request.getParameter("codigo");
		String nombre=request.getParameter("nombre");
		String tipo=request.getParameter("tipo");
		String fecha=request.getParameter("fecha");
		String sexo=request.getParameter("sexo");
		String raza=request.getParameter("raza");
		String edad=request.getParameter("edad");
		String peso=request.getParameter("peso");
		String color=request.getParameter("color");
		String guarderia=request.getParameter("guarderia");
		String prioridad=request.getParameter("prioridad");
		String descripcion=request.getParameter("descripcion");
		String foto=request.getParameter("archivo");
		System.out.println(fecha);
		if(codigo==null || nombre==null || tipo==null || fecha==null || sexo==null || raza==null ||
				edad==null || peso==null || color==null ||guarderia==null || prioridad==null ||descripcion==null || foto==null
			) {
			//ERROR FALTA DATO;
			//return;
		}
		int idTipo= Integer.parseInt(tipo);
		int idPrioridad=Integer.parseInt(prioridad);
		if(animalDAO.find(codigo)!=null) {
			//ERROR YA EXISTE;
			//return;
		}		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngreso=null;
		try {
			fechaIngreso = sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Animal animal =new Animal(codigo, color, descripcion, Integer.valueOf(edad), fechaIngreso, foto, nombre, peso, raza, sexo);
		animal.setTipoAnimal(tipoAnimalDAO.find(idTipo));
		animal.setPrioridad(prioridadDAO.find(idPrioridad));
		animal.setGuarderia(guarderiaDAO.find(guarderia));
		animal.setEstadoAnimalBean(estadoAnimalDAO.find(3));
		animal.iniciarHistoria();
		animalDAO.insert(animal);
		response.sendRedirect(request.getContextPath()+"/admin/animal/listar");
	}
	
	protected void showViewAgregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TipoAnimal>tipoAnimales=tipoAnimalDAO.list();
		List<Prioridad>prioridades=prioridadDAO.list();
		List<Guarderia>guarderias=guarderiaDAO.list();
		request.setAttribute("tipos", tipoAnimales);
		request.setAttribute("prioridades", prioridades);
		request.setAttribute("guarderias", guarderias);
		request.getRequestDispatcher("/formulario-animal.jsp").include(request, response);
		
	}
	
	protected void showViewListar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			List<Animal>animales = animalDAO.list();
			request.setAttribute("animales", animales);
		// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
					request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
		
	}

}
