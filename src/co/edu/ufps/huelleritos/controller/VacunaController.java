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
import co.edu.ufps.huelleritos.dao.VacunaDAO;
import co.edu.ufps.huelleritos.dao.VacunaHistorialDAO;
import co.edu.ufps.huelleritos.dto.VacunaDTO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.HistorialAnimal;
import co.edu.ufps.huelleritos.entities.Vacuna;
import co.edu.ufps.huelleritos.entities.VacunaHistorial;

/**
 * Servlet implementation class VacunaController
 */
@WebServlet({"/admin/animal/addVacuna", "/admin/animal/addVacuna/enviar", "/admin/animal/editVacuna",
	"/admin/animal/editVacuna/enviar", "/admin/animal/deleteVacuna",})
public class VacunaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VacunaHistorialDAO vacunaHistorialDAO;
	private AnimalDAO animalDAO;
	private VacunaDAO vacunaDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacunaController() {
        super();
        vacunaHistorialDAO= new VacunaHistorialDAO();
        animalDAO = new AnimalDAO();
        vacunaDAO = new VacunaDAO();
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
			AnimalVacunas(request, response, ubicacion);
		}
	}

	protected void AnimalVacunas(HttpServletRequest request, HttpServletResponse response, String estoy)
			throws ServletException, IOException {
		switch (estoy) {
		case "/deleteVacuna":
			EliminarVacuna(request, response);
			break;
		case "/addVacuna/enviar":
			registrarVacuna(request, response);
			break;
		case "/addVacuna":
			showViewVacunaAgregar(request, response);
			break;
		case "/editVacuna":
			showViewVacunaEditar(request, response);
			break;
		case "/editVacuna/enviar":
			editarVacuna(request, response);
			break;
		case "/historial/vacuna":
			consultarVacuna(request, response);
			break;
		}
	}

	protected void EliminarVacuna(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVacuna = request.getParameter("vacuna");

		if (idVacuna == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		
		VacunaHistorial vacunaHistorial = vacunaHistorialDAO.find(Integer.parseInt(idVacuna));
		if (vacunaHistorial == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		String codigoAnimal = vacunaHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal();
		vacunaHistorialDAO.deleteClearCache(vacunaHistorial);
		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigoAnimal);

	}

	protected void registrarVacuna(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigoAnimal");
		String fecha = request.getParameter("fecha");
		String vacuna = request.getParameter("vacuna");

		if (codigo == null || fecha == null || vacuna == vacuna) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		if (codigo.equals("") || fecha.equals("") || vacuna.equals("")) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Animal animalBuscado = animalDAO.find(codigo);
		Vacuna vacunaBuscada = vacunaDAO.find(vacuna);
		HistorialAnimal historial = animalBuscado.getHistorialAnimals().get(0);
		VacunaHistorial vacunaHistorial = new VacunaHistorial();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaVacuna = null;

		try {
			fechaVacuna = sdf.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		vacunaHistorial.setFechaVacunacion(fechaVacuna);
		vacunaHistorial.setHistorialAnimal(historial);
		vacunaHistorial.setVacuna(vacunaBuscada);

		historial.addVacunaHistorial(vacunaHistorial);

		vacunaHistorialDAO.insert(vacunaHistorial);
		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal=" + codigo);

	}

	protected void showViewVacunaAgregar(HttpServletRequest request, HttpServletResponse response)
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
		List<Vacuna> vacunas = vacunaDAO.list();
		request.setAttribute("codigo", codigoAnimal);
		request.setAttribute("vacunas", vacunas);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/agg-vacuna.jsp").forward(request, response);

	}

	protected void showViewVacunaEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVacuna = request.getParameter("vacuna");
		if (idVacuna == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		VacunaHistorial vacunaHistorial = vacunaHistorialDAO.find(Integer.parseInt(idVacuna));
		if (vacunaHistorial == null) {
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		List<Vacuna> vacunas = vacunaDAO.list();
		request.setAttribute("vacunas", vacunas);
		request.setAttribute("vacuna", vacunaHistorial);
		ServletContext sc = request.getServletContext();
		sc.getRequestDispatcher("/edit-vacuna.jsp").forward(request, response);

	}

	protected void editarVacuna(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVacuna = request.getParameter("idVacuna");
		String fecha = request.getParameter("fecha");
		String vacuna = request.getParameter("vacuna");
		if (idVacuna == null || fecha == null || vacuna == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		VacunaHistorial vacunaHistorial = vacunaHistorialDAO.find(Integer.parseInt(idVacuna));
		if (vacunaHistorial == null) {
			request.setAttribute("mensaje", "No existe el recurso");
			response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
			return;
		}
		Vacuna vacunaBuscada = vacunaDAO.find(vacuna);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaUno = null;
		try {
			fechaUno = sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vacunaHistorial.setFechaVacunacion(fechaUno);
		vacunaHistorial.setVacuna(vacunaBuscada);

		vacunaHistorialDAO.update(vacunaHistorial);

		response.sendRedirect(request.getContextPath() + "/admin/animal/historial?animal="
				+ vacunaHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal());

	}

	protected void consultarVacuna(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String idHistorialVacuna = request.getParameter("vacuna");
		if (idHistorialVacuna.equals("") || idHistorialVacuna.contains("registra")) {
			response.getWriter().append("{'descripcion':' '}");
			return;
		}
		VacunaHistorial vacunaHistorial = vacunaHistorialDAO.find(Integer.parseInt(idHistorialVacuna));
		VacunaDTO vacuna = new VacunaDTO();
		vacuna.setDescripcion(vacunaHistorial.getVacuna().getDescripcion());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		vacuna.setFecha(sdf.format(vacunaHistorial.getFechaVacunacion()));
		ObjectMapper obj = new ObjectMapper();
		String aux = obj.writeValueAsString(vacuna);
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
