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

import co.edu.ufps.huelleritos.dao.UsuarioDAO;
import co.edu.ufps.huelleritos.entities.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() throws SQLException {
		super();
		usuarioDAO= new UsuarioDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servlet Usuario");
		String action = request.getParameter("action");
		System.out.println("action");

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Usuario");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexUsuarios.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {		
		//Usuario cl = new Usuario(dni, nombre, apellido, contraseña, correo, telefono);
		//usuarioDAO.insert(cl);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexUsuarios.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaUsuarios/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaUsuarios/mostrar.jsp");
		List<Usuario> list = usuarioDAO.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		//Usuario cl = usuarioDAO.buscar(Integer.parseInt(request.getParameter("id")));
		//request.setAttribute("usuario", cl);

		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaUsuarios/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		//Usuario cl = new Usuario(dni, nombre, apellido, contraseña, correo, telefono);
		//usuarioDAO.actualizar(cl);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		//Usuario cl = usuarioDAO.find(Integer.parseInt(request.getParameter("id")));
		//usuarioDAO.eliminar(cl.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexUsuarios.jsp");
		dispatcher.forward(request, response);

	}
}
