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

/**
 * Servlet implementation class NoticiaEvidenciaController
 */
@WebServlet(description = "Controlador de las noticias evidencias", urlPatterns = { "/NoticiaEvidenciaController" })
public class NoticiaEvidenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticiaEvidenciaDAO noticiaEvidenciaDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiaEvidenciaController() {
        super();
         noticiaEvidenciaDAO = new NoticiaEvidenciaDAO();
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
		System.out.println("Servlet Candidato");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Integer eleccion = Integer.parseInt(request.getParameter("eleccion").split(" - ")[0]);
		Integer id = candidatoDao.buscarIDUltimo();
		
		Candidato c = new Candidato(id+1, request.getParameter("documento"), request.getParameter("nombre"), 
				request.getParameter("apellido"), eleccion, Integer.parseInt(request.getParameter("numero")));
				candidatoDao.insertar(c);
				RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
				dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/mostrar.jsp");
		List<Candidato> list = candidatoDao.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c= candidatoDao.buscar(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("candidato", c);

		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = new Candidato(Integer.parseInt(request.getParameter("id")), request.getParameter("documento"), request.getParameter("nombre"), 
				request.getParameter("apellido"), Integer.parseInt(request.getParameter("eleccion")), Integer.parseInt(request.getParameter("numero")));
		candidatoDao.actualizar(c);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = candidatoDao.buscar(Integer.parseInt(request.getParameter("id")));
		candidatoDao.eliminar(c.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);

	}

	
}
