package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.SeguimientoAnimalDAO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.SeguimientoAnimal;

/**
 * Servlet implementation class PerfilHuellerito
 */
@WebServlet({ "/PerfilHuellerito", "/Seguimiento", "/Seguimiento/Enviar" })
public class PerfilHuellerito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SeguimientoAnimalDAO seguimientoDAO;
	private AnimalDAO animalDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilHuellerito() {
		super();
		animalDAO = new AnimalDAO();
		seguimientoDAO = new SeguimientoAnimalDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String path = request.getServletPath();
System.out.println(path);System.out.println("sasaasano");
		if (path.contains("/Perfil")) {
			System.out.println("aS");
			String codigo = request.getParameter("codigo");
			if (codigo == null) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			} else {
				mostrarPerfil(request, response, codigo);
			}
		}else if(path.equals("/Seguimiento")) {
			validarMostrarSeguimiento(request, response);
		}else {
			insertarSeguimiento(request, response);
		}
	}

	private void validarMostrarSeguimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") == null
				|| request.getSession().getAttribute("tipoUsuario") == null) {
			request.setAttribute("mensaje", "Datos incorrectos");
			request.getRequestDispatcher("/Usuario/Login").forward(request, response);
			// response.sendRedirect(request.getContextPath() + "/Usuario/Login");
			return;
		}
		irASeguimiento(request,response);
	}
	
	private boolean validarImagen(String archivo) {
		return archivo.endsWith(".jpg") || archivo.endsWith(".jpeg") || archivo.endsWith(".png")
				|| archivo.endsWith(".svg") || archivo.endsWith(".jiff");
	}

	private boolean validarVideo(String archivo) {
		return archivo.endsWith(".mp4") || archivo.endsWith(".mkv") || archivo.endsWith(".mov")
				|| archivo.endsWith(".wmv") || archivo.endsWith(".avi") || archivo.endsWith(".flv");
	}

	protected void mostrarPerfil(HttpServletRequest request, HttpServletResponse response, String codigo)
			throws ServletException, IOException {
		AnimalDAO animalDAO = new AnimalDAO();
		Animal animalBuscado = animalDAO.find(codigo);
		if (animalBuscado == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.setAttribute("perfilAnimal", animalBuscado);
		request.getRequestDispatcher("/html/Huelleritos_Adultos_gallery/Huellerito1.jsp").include(request, response);
	}

	protected void irASeguimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idAnimalSeg");
		String nombre = request.getParameter("nombreAnimal");
		System.out.println(id);
		System.out.println(nombre);
		if (id != null && nombre != null) {
			request.setAttribute("idAnimalSeg", id);
			request.setAttribute("nombreAnimal", nombre);
			request.getRequestDispatcher("/html/SeguimientoAnimal.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("mensaje", "Parametros del animal no válidos");
			request.getRequestDispatcher("/Error").forward(request, response);
			return;
		}
	}
	
	protected void insertarSeguimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("idAnimalSeg");
		String nombre=request.getParameter("nombreAnimal");
		System.out.println(id);
		System.out.println(nombre);
		if(id!=null && nombre !=null) {
			Animal a =animalDAO.find(id);
			SeguimientoAnimal sa= new SeguimientoAnimal();
			String observacion =request.getParameter("observacion");
			String archivo = request.getParameter("archivo");

			if(validarImagen(archivo)){
				sa.setVideo("/");
				sa.setFoto(archivo);
			}else if(validarVideo(archivo)) {
				sa.setVideo(archivo);
				sa.setFoto("/");
			}
			sa.setObservacion(observacion);
			sa.setFecha(new java.util.Date());
			String uuid = java.util.UUID.randomUUID().toString();
			sa.setCodigoSeguimiento(uuid.split("-")[0]);
			a.addSeguimientoAnimal(sa);
			animalDAO.update(a);
			request.getRequestDispatcher(request.getContextPath()+"/index/Huelleritos").forward(request, response);
		}else {
			request.setAttribute("mensaje", "Parametros del animal no válidos");
			request.getRequestDispatcher("/Error").forward(request, response);
			return;
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

}
