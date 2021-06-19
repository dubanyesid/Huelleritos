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
       
	private NoticiaDAO noticiaDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Noticias() {
        super();
        noticiaDAO = new NoticiaDAO();
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
		List<Noticia> noticias =null;
		switch(direccion) {
		case "/Noticias":
			noticias=noticiaDAO.listEventos();
			request.setAttribute("noticias", noticias);
			request.setAttribute("titulo", "Nuevos Eventos");
			
			request.getRequestDispatcher("/html/Noticias.jsp").forward(request, response);
			
			break;
		case "/NoticiasEvidencias":
			noticias = noticiaDAO.listEvidencias();
			request.setAttribute("noticias", noticias);
			request.setAttribute("titulo", "Nuevos Evidencias");
			
			request.getRequestDispatcher("/html/Noticias.jsp").forward(request, response);
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
