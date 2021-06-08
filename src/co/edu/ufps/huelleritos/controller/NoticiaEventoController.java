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

import co.edu.ufps.huelleritos.dao.NoticiaEventoDAO;
import co.edu.ufps.huelleritos.entities.NoticiaEvento;
import co.edu.ufps.huelleritos.entities.NoticiaEvidencia;

/**
 * Servlet implementation class NoticiaEventoController
 */
@WebServlet("/NoticiaEventoController")
public class NoticiaEventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticiaEventoDAO noticiaEventoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiaEventoController() {
        super();
        noticiaEventoDAO = new NoticiaEventoDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println("Servlet Noticia Evento");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WebContent/administrador/noticia.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Integer id = noticiaEventoDAO.getMaxId();

		NoticiaEvento nev = new NoticiaEvento(id + 1, request.getParameter("titulo"),
				request.getParameter("descripcion"), request.getParameter("imagen"), );
		noticiaEventoDAO.insert(nev);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("../WebContent/administrador/noticia-.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WebContent/administrador/noticia.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WebContent/vistas/NoticiasEvidencias.jsp");
		List<NoticiaEvento> list = noticiaEventoDAO.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvento nev = noticiaEventoDAO.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("noticiaEvidencia", nev);

		RequestDispatcher dispatcher = request.getRequestDispatcher("../WebContent/administrador/noticia.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvento nev = new NoticiaEvento(Integer.parseInt(request.getParameter("id")),
				request.getParameter("titulo"), request.getParameter("descripcion"), );
		noticiaEventoDAO.update(nev);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		NoticiaEvento nev = noticiaEventoDAO.find(Integer.parseInt(request.getParameter("id")));
		noticiaEventoDAO.delete(nev);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../WebContent/vistas/noticia.jsp");
		dispatcher.forward(request, response);

	}

}
