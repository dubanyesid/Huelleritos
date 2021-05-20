package co.edu.ufps.huelleritos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.NoticiaEventoDAO;
import co.edu.ufps.huelleritos.dao.NoticiaEvidenciaDAO;
import co.edu.ufps.huelleritos.entities.NoticiaEvidencia;

/**
 * Servlet implementation class AdministradorServlet
 */
@WebServlet(description = "Crud de noticia evidencias", urlPatterns = { "/AdministradorServlet" })
public class AdministradorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private NoticiaEvidenciaDAO noticiaEvidenciaDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorServlet() {
        super();
        noticiaEvidenciaDAO = new NoticiaEvidenciaDAO(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		switch (action) {
		case "/new":
			showNewNoticia(request, response);
			break;
		case "/insert":
			insertNoticia(request, response);
			break;
		case "/delete":
			deleteNoticia(request, response);
			break;
		case "/update":
			updateNoticia(request, response);
			break;
		default:
			listUser(request, response);
			break;
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("NoticiaEvidencias.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void updateNoticia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteNoticia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertNoticia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idNoticiaEvidencia = Integer.parseInt(request.getParameter("idNoticiaEvidencia"));
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String titulo = request.getParameter("titulo");
		
		NoticiaEvidencia newNoticiaEvidencia = new NoticiaEvidencia(idNoticiaEvidencia,descripcion, imagen, titulo);
		//response.sendRedirect("list");
	}

	private void showNewNoticia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
