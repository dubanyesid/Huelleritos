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

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.EnfermedadDAO;
import co.edu.ufps.huelleritos.dao.EnfermedadHistorialDAO;
import co.edu.ufps.huelleritos.dto.EnfermedadDTO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.Enfermedad;
import co.edu.ufps.huelleritos.entities.EnfermedadHistorial;
import co.edu.ufps.huelleritos.entities.HistorialAnimal;

/**
 * Servlet implementation class EnfermedadController
 */
@WebServlet({"/admin/animal/historial/enfermedad",
	 "/admin/animal/addEnfermedad",
	"/admin/animal/addEnfermedad/enviar", "/admin/animal/editEnfermedad", "/admin/animal/editEnfermedad/enviar",
	"/admin/animal/deleteEnfermedad" })
public class EnfermedadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnfermedadHistorialDAO enfermedadHistorialDAO;
	private EnfermedadDAO enfermedadDAO;
	private AnimalDAO animalDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnfermedadController() {
        super();
        enfermedadHistorialDAO = new EnfermedadHistorialDAO();
        enfermedadDAO = new EnfermedadDAO();
        animalDAO = new AnimalDAO();
        
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
			AnimalEnfermedad(request, response, ubicacion);
		}
	}

	protected void AnimalEnfermedad(HttpServletRequest request, HttpServletResponse response, String estoy)
			throws ServletException, IOException {
		switch (estoy) {
		case "/deleteEnfermedad":
			EliminarEnfermedad(request, response);
			break;
		case "/addEnfermedad/enviar":
			registrarEnfermedad(request, response);
			break;
		case "/addEnfermedad":
			showViewEnfermedadAgregar(request, response);
			break;
		case "/editEnfermedad":
			showViewEnfermedadEditar(request, response);
			break;
		case "/editEnfermedad/enviar":
			editarEnfermedad(request, response);
			break;
		case "/historial/enfermedad":
			consultarEnfermedad(request, response);
			break;
		}
	}

	protected void EliminarEnfermedad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVacuna = request.getParameter("enfermedad");

		if (idVacuna == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		EnfermedadHistorial historialEnfermedad = enfermedadHistorialDAO.find(Integer.parseInt(idVacuna));
		if (historialEnfermedad == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		String codigoAnimal = historialEnfermedad.getHistorialAnimal().getAnimal().getCodigoAnimal();
		enfermedadHistorialDAO.deleteClearCache(historialEnfermedad);
		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigoAnimal);

	}

	protected void registrarEnfermedad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigoAnimal");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String enfermedad = request.getParameter("enfermedad");
		if (codigo == null || fechaInicio == null || fechaFin == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		if (codigo.equals("") || fechaInicio.equals("") || fechaFin.equals("")) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animalBuscado = animalDAO.find(codigo);
		Enfermedad enfermedadBuscada = enfermedadDAO.find(enfermedad);
		HistorialAnimal historial = animalBuscado.getHistorialAnimals().get(0);
		EnfermedadHistorial enfermedadHistorial = new EnfermedadHistorial();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaUno = null;
		Date fechaDos = null;
		try {
			fechaUno = sdf.parse(fechaInicio);
			fechaDos = sdf.parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		enfermedadHistorial.setEnfermedad(enfermedadBuscada);
		enfermedadHistorial.setHistorialAnimal(historial);
		enfermedadHistorial.setFechaFin(fechaDos);
		enfermedadHistorial.setFechaInicio(fechaUno);

		historial.addEnfermedadHistorial(enfermedadHistorial);

		enfermedadHistorialDAO.insert(enfermedadHistorial);
		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigo);
	}

	protected void showViewEnfermedadAgregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoAnimal = request.getParameter("animal");
		if (codigoAnimal == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animal = animalDAO.find(codigoAnimal);
		if (animal == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		List<Enfermedad> enfermedades = enfermedadDAO.list();
		request.setAttribute("codigo", codigoAnimal);
		request.setAttribute("enfermedades", enfermedades);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/agg-enfermedad.jsp").forward(request, response);
	}

	protected void showViewEnfermedadEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idEnfermedad = request.getParameter("enfermedad");
		if (idEnfermedad == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		EnfermedadHistorial enfermedadHistorial = enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedad));
		if (enfermedadHistorial == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		List<Enfermedad> enfermedades = enfermedadDAO.list();
		request.setAttribute("enfermedades", enfermedades);
		request.setAttribute("enfermedad", enfermedadHistorial);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/edit-enfermedad.jsp").forward(request, response);

	}

	protected void editarEnfermedad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idEnfermedad = request.getParameter("idEnfermedad");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String enfermedad = request.getParameter("enfermedad");

		if (idEnfermedad == null || fechaInicio == null || fechaFin == null || enfermedad == null) {
			request.getRequestDispatcher("/admin/inicio").forward(request, response);
			return;
		}
		EnfermedadHistorial enfermedadHistorial = enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedad));
		if (enfermedadHistorial == null) {
			request.getRequestDispatcher("/admin/inicio").forward(request, response);
			return;
		}
		Enfermedad enfermedadBuscada = enfermedadDAO.find(enfermedad);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaUno = null;
		Date fechaDos = null;
		try {
			fechaUno = sdf.parse(fechaInicio);
			fechaDos = sdf.parse(fechaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		enfermedadHistorial.setFechaInicio(fechaUno);
		enfermedadHistorial.setFechaFin(fechaDos);
		enfermedadHistorial.setEnfermedad(enfermedadBuscada);
		enfermedadHistorialDAO.update(enfermedadHistorial);

		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal="
				+ enfermedadHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal());

	}

	protected void consultarEnfermedad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String idEnfermedadHistorial = request.getParameter("enfermedad");
		if (idEnfermedadHistorial.equals("") || idEnfermedadHistorial.contains("registra")) {
			response.getWriter().append("{'tratamiento':' '}");
			return;
		}
		EnfermedadHistorial enfermedadHistorial = enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedadHistorial));
		EnfermedadDTO enfermedadDTO = new EnfermedadDTO();
		enfermedadDTO.setTratamiento(enfermedadHistorial.getEnfermedad().getTratamientoEnfermedad());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		enfermedadDTO.setFechaInicio(sdf.format(enfermedadHistorial.getFechaInicio()));
		enfermedadDTO.setFechaFin(sdf.format(enfermedadHistorial.getFechaFin()));
		ObjectMapper obj = new ObjectMapper();
		String aux = obj.writeValueAsString(enfermedadDTO);
		response.getWriter().append(aux);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
