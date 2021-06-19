package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.OperacionesAnimalDAO;
import co.edu.ufps.huelleritos.dto.OperacionDTO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.HistorialAnimal;
import co.edu.ufps.huelleritos.entities.OperacionesAnimal;

/**
 * Servlet implementation class ObservacionController
 */
@WebServlet({"/admin/animal/historial/operacion", "/admin/animal/addOperacion", "/admin/animal/addOperacion/enviar",
	"/admin/animal/editOperacion", "/admin/animal/editOperacion/enviar", "/admin/animal/deleteOperacion"})
public class OperacionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OperacionesAnimalDAO operacionAnimalDAO;
	private AnimalDAO animalDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacionesController() {
        super();
        operacionAnimalDAO = new OperacionesAnimalDAO();
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
			AnimalOperaciones(request, response, ubicacion);
		}
	}
	
	
	protected void AnimalOperaciones(HttpServletRequest request, HttpServletResponse response, String estoy)
			throws ServletException, IOException {
		switch (estoy) {
		case "/deleteOperacion":
			EliminarOperacion(request, response);
			break;
		case "/addOperacion/enviar":
			registrarOperacion(request, response);
			break;
		case "/addOperacion":
			showViewOperacionAgregar(request, response);
			break;
		case "/editOperacion":
			showViewOperacionEditar(request, response);
			break;
		case "/editOperacion/enviar":
			editarOperacion(request, response);
			break;
		case "/historial/operacion":
			consultarOperacion(request, response);
			break;
		}
	}

	protected void EliminarOperacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idOperacion = request.getParameter("operacion");

		if (idOperacion == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		OperacionesAnimal operacion = operacionAnimalDAO.find(Integer.parseInt(idOperacion));
		if (operacion == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		String codigoAnimal = operacion.getHistorialAnimal().getAnimal().getCodigoAnimal();
		operacionAnimalDAO.deleteClearCache(operacion);
		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigoAnimal);

	}

	protected void registrarOperacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigoAnimal");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String nombre = request.getParameter("nombre");
		String observacion = request.getParameter("observacion");

		if (codigo == null || fechaInicio == null || fechaFin == null || nombre == null || observacion == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animalBuscado = animalDAO.find(codigo);

		HistorialAnimal historial = animalBuscado.getHistorialAnimals().get(0);
		OperacionesAnimal operacion = new OperacionesAnimal();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaUno = null;
		Date fechaDos = null;
		try {
			fechaUno = sdf.parse(fechaInicio);
			fechaDos = sdf.parse(fechaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		operacion.setFechaRecuperacion(fechaDos);
		operacion.setFechaOperacion(fechaUno);
		operacion.setObservaciones(observacion);
		operacion.setNombreOperacion(nombre);
		operacion.setHistorialAnimal(historial);
		historial.addOperacionesAnimal(operacion);

		operacionAnimalDAO.insert(operacion);

		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigo);

	}

	protected void showViewOperacionAgregar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoAnimal = request.getParameter("animal");
		if (codigoAnimal == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animal = animalDAO.find(codigoAnimal);
		if (animal == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		request.setAttribute("codigo", codigoAnimal);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/agg-operacion.jsp").forward(request, response);

	}

	protected void showViewOperacionEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idOperacion = request.getParameter("operacion");
		if (idOperacion == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		OperacionesAnimal operacionAnimal = operacionAnimalDAO.find(Integer.parseInt(idOperacion));
		if (operacionAnimal == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		request.setAttribute("operacion", operacionAnimal);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/edit-operacion.jsp").forward(request, response);

	}

	protected void editarOperacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idOperacion = request.getParameter("idOperacion");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String nombre = request.getParameter("nombre");
		String observacion = request.getParameter("observacion");

		if (idOperacion == null || fechaInicio == null || fechaFin == null || nombre == null || observacion == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		OperacionesAnimal operacion = operacionAnimalDAO.find(Integer.parseInt(idOperacion));
		if (operacion == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaUno = null;
		Date fechaDos = null;
		try {
			fechaUno = sdf.parse(fechaInicio);
			fechaDos = sdf.parse(fechaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		operacion.setFechaRecuperacion(fechaDos);
		operacion.setFechaOperacion(fechaUno);
		operacion.setObservaciones(observacion);
		operacion.setNombreOperacion(nombre);
		operacionAnimalDAO.update(operacion);

		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal="
				+ operacion.getHistorialAnimal().getAnimal().getCodigoAnimal());

	}

	protected void consultarOperacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String idOperacion = request.getParameter("operacion");
		if (idOperacion.equals("") || idOperacion.contains("registra")) {
			response.getWriter().append("{'observacion':' '}");
			return;
		}
		OperacionesAnimal operacionAnimal = operacionAnimalDAO.find(Integer.parseInt(idOperacion));
		OperacionDTO operacionDTO = new OperacionDTO();
		operacionDTO.setObservacion(operacionAnimal.getObservaciones());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

		operacionDTO.setFechaOperacion(sd.format(operacionAnimal.getFechaOperacion()));
		operacionDTO.setFechaRecuperacion(sd.format(operacionAnimal.getFechaRecuperacion()));
		ObjectMapper obj = new ObjectMapper();
		String aux = obj.writeValueAsString(operacionDTO);
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
