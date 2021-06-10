package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.NoticiaDAO;
import co.edu.ufps.huelleritos.entities.Noticia;

/**
 * Servlet implementation class Noticias
 */
@WebServlet({"/Noticias","/NoticiasEvidencias"})
public class Noticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Noticias() {
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
		// TODO Auto-generated method stub
		String direccion = request.getServletPath();
		
		switch(direccion) {
		case "/Noticias":
			NoticiaDAO noticiaDAO =new NoticiaDAO();
			List<Noticia> noticias = noticiaDAO.list();
			request.setAttribute("noticias", noticias);
			request.setAttribute("titulo", new String("Nuevos Eventos"));
			
			request.getRequestDispatcher("/html/Noticias.jsp").forward(request, response);
			
			break;
		case "/NoticiasEvidencias":
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
