package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.entities.Animal;

/**
 * Servlet implementation class PerfilHuellerito
 */
@WebServlet("/PerfilHuellerito")
public class PerfilHuellerito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilHuellerito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String codigo = request.getParameter("codigo");
		System.out.println(codigo);
		if(codigo==null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		AnimalDAO animalDAO = new AnimalDAO();		
		Animal animalBuscado = animalDAO.find(codigo);
		if(animalBuscado==null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.setAttribute("perfilAnimal", animalBuscado);
		request.getRequestDispatcher("/html/Huelleritos_Adultos_gallery/Huellerito1.jsp").include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
