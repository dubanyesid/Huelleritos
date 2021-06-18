package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.entities.Animal;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({ "/index", "/Huelleritos/Adultos", "/Huelleritos/Cachorros", "/Huelleritos/Adoptados",
		"/index/Huelleritos", "/index/Apadrina", "/index/Adopta", "/index/HogarDePaso", "/index/Fundacion" })
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnimalDAO animalDAO;
	private List<Animal> adopcion;
	private List<Animal> prioridad;
	private List<Animal> adoptados;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
		animalDAO = new AnimalDAO();
		adopcion = animalDAO.listAdopcion();
		prioridad = animalDAO.listPrioridad();
		adoptados = animalDAO.listAdoptado();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getServletPath();
System.out.println(path);
		if (path.equals("/index")) {
			request.setAttribute("animalesAdopcion", adopcion);
			request.setAttribute("animalesPrioridad", prioridad);
			request.setAttribute("animalesAdoptados", adoptados);
			request.getRequestDispatcher("inicio.jsp").forward(request, response);
		} else if (path.contains("/index/")) {
			verIndex(request, response, path);
			return;
		} else if (path.contains("/Huelleritos")) {
			verHuelleritos(request, response, path);
			return;
		}

	}

	protected void verIndex(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		path = path.replace("/index/", "");
		System.out.println("fsd"+path);
		switch (path) {
		case "Adopta":
			request.setAttribute("listAdoptados", adoptados);
			request.getRequestDispatcher("/html/Adopta.jsp").forward(request, response);
			break;
		case "Huelleritos":
			request.setAttribute("listAdultos", animalDAO.listAdultos());
			request.setAttribute("listCachorros", animalDAO.listCachorros());
			request.setAttribute("listAdoptados", adoptados);
			request.getRequestDispatcher("/html/Huelleritos.jsp").forward(request, response);
			break;
		case "Apadrina":
			request.getRequestDispatcher("/html/Apadrinar.jsp").forward(request, response);
			break;
		case "HogarDePaso":
			request.getRequestDispatcher("/html/Hogar_Paso.jsp").forward(request, response);
			break;
		case "Fundacion":
			request.getRequestDispatcher("/html/La_Fundacion.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/index").forward(request, response);
			break;

		}
	}

	protected void verHuelleritos(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		path = path.replace("/Huelleritos/", "");
		System.out.println("sd"+path);
		switch (path) {
		case "Adultos":
			System.out.println("adultos");
			request.setAttribute("listAdultos", animalDAO.listAdultos());
			System.out.println(animalDAO.listAdultos());
			request.getRequestDispatcher("/html/Huelleritos_Adultos.jsp").forward(request, response);
			break;
		case "Cachorros":
			System.out.println("cachorros");
			request.setAttribute("listCachorros", animalDAO.listCachorros());
			request.getRequestDispatcher("/html/Huelleritos_Cachorros.jsp").forward(request, response);
			break;
		case "Adoptados":
			System.out.println("adoptad");
			request.setAttribute("listAdoptados", adoptados);
			request.getRequestDispatcher("/html/Huelleritos_Adoptados.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/index/Huelleritos").forward(request, response);
			break;

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
