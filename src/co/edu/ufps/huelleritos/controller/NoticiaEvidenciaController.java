package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.NoticiaEvidenciaDAO;
import co.edu.ufps.huelleritos.entities.NoticiaEvidencia;

/**
 * Servlet implementation class NoticiaEvidenciaController
 */
@WebServlet("/NoticiaEvidenciaController")
public class NoticiaEvidenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticiaEvidenciaDAO noticiaEvidenciaDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticiaEvidenciaController() {
		super();
		// TODO Auto-generated constructor stub
		noticiaEvidenciaDAO = new NoticiaEvidenciaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "mostrar":
				System.out.println("Ingreso metodo mostrar");
				mostrar(request, response);
				break;
			case "showedit":
				showEditor(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Noticia Evidencia");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("administrador/noticia-evidencia.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Integer id = noticiaEvidenciaDAO.getMaxId();

		NoticiaEvidencia ne = new NoticiaEvidencia(id + 1, request.getParameter("titulo"),
				request.getParameter("descripcion"), request.getParameter("imagen"));
		noticiaEvidenciaDAO.insert(ne);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("administrador/noticia-evidencia.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("administrador/noticia-evidencia.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/NoticiasEvidencias.jsp");
		List<NoticiaEvidencia> list = noticiaEvidenciaDAO.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvidencia ne = noticiaEvidenciaDAO.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("noticiaEvidencia", ne);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("administrador/noticia-evidencia.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvidencia ne = new NoticiaEvidencia(Integer.parseInt(request.getParameter("id")),
				request.getParameter("titulo"), request.getParameter("descripcion"), request.getParameter("imagen"));
		noticiaEvidenciaDAO.update(ne);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvidencia ne = noticiaEvidenciaDAO.find(Integer.parseInt(request.getParameter("id")));
		noticiaEvidenciaDAO.delete(ne);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/NoticiasEvidencias.jsp");
		dispatcher.forward(request, response);

	}

}
