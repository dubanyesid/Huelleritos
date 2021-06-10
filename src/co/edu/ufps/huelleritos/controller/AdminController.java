package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({ "/admin", "/admin/login", "/admin/animal", "/admin/animal/listar", "/admin/animal/" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String estoy = path.replace("/admin", "");

		System.out.println(path + " " + path.length());
		System.out.println(estoy);
		if (path.equals("/admin")) {
			request.getRequestDispatcher("/inicioAdmin.jsp").include(request, response);
		} else if (estoy.contains("/animal")) {
			String ubicacion = estoy.replace("/animal", "");
			animales(request, response, ubicacion);
		} else if(estoy.contains("/login")) {
			login(request,response);
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
		case "/listar":
			// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
			request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
			break;
		default:
			// response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
			request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
			break;
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("MUESTRA LOGIN DE ADMIN");
	}
}
