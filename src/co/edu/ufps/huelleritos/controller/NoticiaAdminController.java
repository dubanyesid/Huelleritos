package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.NoticiaDAO;
import co.edu.ufps.huelleritos.dao.TipoNoticiaDAO;
import co.edu.ufps.huelleritos.dao.UsuarioDAO;
import co.edu.ufps.huelleritos.entities.Noticia;
import co.edu.ufps.huelleritos.entities.TipoNoticia;
import co.edu.ufps.huelleritos.entities.Usuario;

/**
 * Servlet implementation class NoticiaAdminController
 */
@WebServlet({"/admin/Noticia","/admin/Noticia/agregar","/admin/Noticia/agregar/enviar","/admin/Noticia/eliminar"})
public class NoticiaAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	private NoticiaDAO noticiaDAO;
	private TipoNoticiaDAO tipoNoticiaDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiaAdminController() {
        super();
        // TODO Auto-generated constructor stub
      
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		  noticiaDAO= new NoticiaDAO();
		  tipoNoticiaDAO=new TipoNoticiaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro a "+request.getServletPath());
		String ubicacion = request.getServletPath().replace("/admin/Noticia", "");
		if (request.getSession().getAttribute("usuario") == null
				|| request.getSession().getAttribute("tipoUsuario") == null
				|| !request.getSession().getAttribute("tipoUsuario").equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/Usuario/Login");
			return;
		}
		
		
		switch(ubicacion) {
		case "/agregar":
			request.setAttribute("tipos", tipoNoticiaDAO.list());
			request.getRequestDispatcher("/noticia.jsp").forward(request, response);
			break;
		case "/agregar/enviar":
			
			registrarNoticia(request, response);
			break;
		case "/eliminar":
			eliminarNoticia(request, response);
			break;
		default:
			request.setAttribute("noticias", noticiaDAO.list());
			request.getRequestDispatcher("/lista-noticia.jsp").forward(request, response);
			break;
		}
		
		
	}

	protected void eliminarNoticia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticia = request.getParameter("idNoticia");
	    Noticia noticiaBuscada = noticiaDAO.find(Integer.parseInt(noticia));
	    
	    noticiaDAO.deleteClearCache(noticiaBuscada);
	    response.sendRedirect(request.getContextPath()+"/admin/Noticia");
	}
	
	protected void registrarNoticia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo =request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");
		String imagen=request.getParameter("imagen");
		String tipo=request.getParameter("tipo");
		UsuarioDAO uDao=new UsuarioDAO();
		String usuario = (String)request.getSession().getAttribute("usuario");
		Usuario ingresar= uDao.find(usuario);
		
		Noticia noticia=new Noticia();
		TipoNoticia tipoNoticia=tipoNoticiaDAO.find(Integer.parseInt(tipo));
		noticia.setDescripcion(descripcion);
		noticia.setTipoNoticia(tipoNoticia);
		noticia.setImagen(imagen);
		noticia.setTitulo(titulo);
		noticia.setAdministrador(ingresar.getAdministradors().get(0));
		noticiaDAO.insert(noticia);
		 response.sendRedirect(request.getContextPath()+"/admin/Noticia");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
