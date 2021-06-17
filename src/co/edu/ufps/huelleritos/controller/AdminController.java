package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.correo.EnviarCorreoUsuario;
import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.EnfermedadDAO;
import co.edu.ufps.huelleritos.dao.EnfermedadHistorialDAO;
import co.edu.ufps.huelleritos.dao.EstadoAnimalDAO;
import co.edu.ufps.huelleritos.dao.FormularioDAO;
import co.edu.ufps.huelleritos.dao.GuarderiaDAO;
import co.edu.ufps.huelleritos.dao.OperacionesAnimalDAO;
import co.edu.ufps.huelleritos.dao.PrioridadDAO;
import co.edu.ufps.huelleritos.dao.TipoAnimalDAO;
import co.edu.ufps.huelleritos.dao.UsuarioDAO;
import co.edu.ufps.huelleritos.dao.VacunaDAO;
import co.edu.ufps.huelleritos.dao.VacunaHistorialDAO;
import co.edu.ufps.huelleritos.entities.Adoptante;
import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.HogarDePaso;
import co.edu.ufps.huelleritos.entities.Usuario;


/**
 * Servlet implementation class IndexController
 */
@WebServlet({ "/admin","/admin/generarUsuario" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EnviarCorreoUsuario ec;
	private UsuarioDAO usuarioDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		usuarioDAO = new UsuarioDAO();
		ec= new EnviarCorreoUsuario();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		if (request.getSession().getAttribute("usuario") == null
				|| request.getSession().getAttribute("tipoUsuario") == null
				|| !request.getSession().getAttribute("tipoUsuario").equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/Usuario/Login");
			return;
		}

		if(path.contains("generarUsuario")) {
			generarUsuario(request,response);
			System.out.println("sa");
			return;
		}
		
		
		// request.getRequestDispatcher("/inicioAdmin.jsp").include(request, response);
		//response.sendRedirect(request.getContextPath() + "/admin/generarUsuario");

	}

	protected void generarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("formularioID"));
		Formulario f = new FormularioDAO().find(Integer.parseInt(request.getParameter("formularioID")));
		
		if(f!=null) {
			UUID uuid = UUID.randomUUID();
			System.out.println("si");
			String usuario=f.getCorreo().split("@")[0];
			String uuid2=uuid.toString().split("-")[1].substring(0,4);
			usuario=usuario.length()>6? usuario.substring(0,6)+uuid2:usuario+uuid2;
			String pass=uuid.toString().split("-")[0];
			
			insertarUsuario(request,response,usuario,pass,f);
		}
		
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response, String usuario, String pass, Formulario f)
			throws ServletException, IOException {
		Usuario us =usuarioDAO.find(usuario);
		String tipo = String.valueOf(request.getParameter("tipo"));
		System.out.println(tipo);
		if(us==null) {
			us= new Usuario(usuario,pass);
			us.iniciarFormularios();
			us.addFormulario(f);
			
			switch(tipo) {
			case "Adoptante":
				us.setAdoptante(new Adoptante(usuario,"Espera",us));
				//enviarCorreo();
				break;			
			case "Hogar":
				us.setHogarDePaso(new HogarDePaso(usuario,us));
				tipo="Hogar de paso";
				//enviarCorreo();
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/Error");
				return;
			}
			usuarioDAO.insert(us);
			ec.enviarCorreo("informacionHuelleritos.pdf", tipo,us, f);
		}else {
			request.setAttribute("mensaje", "Usuario ya existe");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected boolean enviarCorreo(HttpServletRequest request, HttpServletResponse response,
			String nombreArchivo, String rol ,Usuario us, Formulario formulario)
			throws ServletException, IOException {
		
		
		
		return false;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
