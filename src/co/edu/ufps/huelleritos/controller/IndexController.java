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
@WebServlet({"/admin","/admin/login","/admin/animal","/admin/animal/listar","/admin/animal/"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String estoy = path.replace("/admin","");
		
		System.out.println(path+" "+path.length());
		System.out.println(estoy);
		if(estoy.contains("/animal")) {
			String ubicacion= estoy.replace("/animal", "");
			animales(request,response,ubicacion);
		}else if(estoy.contains("")) {
			request.getRequestDispatcher("/inicio.jsp").include(request, response);
		}
		else {
			System.out.println(request.getContextPath()+"/admin");
			response.sendRedirect(request.getContextPath()+"/admin");
			//request.getRequestDispatcher("/inicio.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	protected void animales(HttpServletRequest request, HttpServletResponse response,String estoy) throws ServletException, IOException {
		switch(estoy) {
		case "/listar":
			//response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
			request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
			break;
			default:
				//response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
				request.getRequestDispatcher("/lista-animales.jsp").include(request, response);
				break;
		}
	}
}
