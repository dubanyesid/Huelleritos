package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.ufps.huelleritos.dao.NoticiaEvidenciaDAO;
import co.edu.ufps.huelleritos.entities.NoticiaEvidencia;

/**
 * Servlet implementation class AdministradorServlet
 */
@WebServlet(description = "Crud de noticia evidencias", urlPatterns = { "/AdministradorServlet" })
public class NoticiaEvidenciaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private NoticiaEvidenciaDAO noticiaEvidenciaDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiaEvidenciaServlet() {
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
			showNewNoticiaEvidencia(request, response);
			break;
		case "/insert":
			insertNoticiaEvidencia(request, response);
			break;
		case "/delete":
			deleteNoticiaEvidencia(request, response);
			break;
		case "/edit":
			showEditNoticiaEvidencia(request, response);
		case "/update":
			updateNoticiaEvidencia(request, response);
			break;
		default:
			listNoticiaEvidencia(request, response);
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

	private void showNewNoticiaEvidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/html/NoticiaEvidencias.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void updateNoticiaEvidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idNoticiaEvidencia = Integer.parseInt(request.getParameter("idNoticiaEvidencia"));
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String titulo = request.getParameter("titulo");

		NoticiaEvidencia newNoticiaEvidencia = new NoticiaEvidencia(idNoticiaEvidencia, descripcion, imagen, titulo);
		noticiaEvidenciaDAO.update(newNoticiaEvidencia);
		try {
			response.sendRedirect("vistas/html/NoticiaEvidencias.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void insertNoticiaEvidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idNoticiaEvidencia = Integer.parseInt(request.getParameter("idNoticiaEvidencia"));
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String titulo = request.getParameter("titulo");

		NoticiaEvidencia newNoticiaEvidencia = new NoticiaEvidencia(idNoticiaEvidencia, descripcion, imagen, titulo);
		noticiaEvidenciaDAO.insert(newNoticiaEvidencia);
		try {
			response.sendRedirect("vistas/html/NoticiaEvidencias.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void listNoticiaEvidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<NoticiaEvidencia> ListNoticiaEvidencia = noticiaEvidenciaDAO.list();
		request.setAttribute("vistas/html/NoticiaEvidencias.jsp", ListNoticiaEvidencia);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/html/NoticiaEvidencias.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void showEditNoticiaEvidencia (HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("idNoticiaEvidencia"));
		NoticiaEvidencia existingNoticia = noticiaEvidenciaDAO.find(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/html/NoticiaEvidencias.jsp");
		request.setAttribute("idNoticiaEvidencia", existingNoticia);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deleteNoticiaEvidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("idNoticiaEvidencia"));
		NoticiaEvidencia ne = noticiaEvidenciaDAO.find(id);
		if (ne != null) {
			noticiaEvidenciaDAO.delete(ne);
		} else {
			System.out.print("La noticia no existe");
		}
		try {
			response.sendRedirect("vistas/html/NoticiaEvidencias.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
