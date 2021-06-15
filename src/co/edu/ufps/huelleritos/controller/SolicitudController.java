package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.FormularioDAO;
import co.edu.ufps.huelleritos.dao.UsuarioDAO;
import co.edu.ufps.huelleritos.entities.*;
import co.edu.ufps.huelleritos.negocio.Puntaje;

/**
 * Servlet implementation class SolicitudController
 */
@WebServlet({ "/Solicitud", "/Solicitudes/Adopcion", "/Solicitudes/HogarDePaso" })
public class SolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;
	private FormularioDAO formularioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolicitudController() {
		super();
		usuarioDAO = new UsuarioDAO();
		formularioDAO = new FormularioDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		List<Puntaje> puntajes = null;

		if (path.contains("Adopcion")) {
			puntajes = formularioDAO.listAdopcion();
			request.setAttribute("tipo", "Adopcion");
		} else if (path.contains("HogarDePaso")) {
			puntajes = formularioDAO.listHogar();
			request.setAttribute("tipo", "Hogar de Paso");
		} else {
			String id = request.getParameter("id");
			if (id != null) {
				Formulario f = formularioDAO.find(Integer.parseInt(id));
				request.setAttribute("formulario", f);
				request.getRequestDispatcher("/solicitud-adoptante.jsp").forward(request, response);
				return;
			}
			request.setAttribute("mensaje", "La petici�n enviada es inv�lida");
			request.getRequestDispatcher("/lista-solicitudes.jsp").include(request, response);
			return;
		}
		
		request.setAttribute("puntajes", puntajes);
		request.getRequestDispatcher("/lista-solicitudes.jsp").include(request, response);
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

	protected void calcularPuntajes(HttpServletRequest request, HttpServletResponse response, List<Formulario> lista)
			throws ServletException, IOException {
		List<Puntaje> puntajes = new ArrayList<Puntaje>();
		Integer puntaje = 0;
		for (Formulario f : lista) {
			puntaje = 0;
			Puntaje p = new Puntaje();
			for (FormularioPregunta fp : f.getFormularioPreguntas()) {
				puntaje += fp.getOpcion().getPeso();
			}
			p.setFormulario(f);
			p.setPuntaje(puntaje);
			puntajes.add(p);
			System.out.println(puntaje);
		}
		ordenarPuntajes(request,response,puntajes);
		request.setAttribute("puntajes", puntajes);
	}

	protected void ordenarPuntajes(HttpServletRequest request, HttpServletResponse response, List<Puntaje> puntajes)
			throws ServletException, IOException {
		Collections.sort(puntajes, new Comparator<Puntaje>() {
			@Override
			public int compare(Puntaje p1, Puntaje p2) {
				return p1.getPuntaje().compareTo(p2.getPuntaje());
			}
		});
	}
}