package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.SeguimientoAnimalDAO;
import co.edu.ufps.huelleritos.dao.UsuarioDAO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.SeguimientoAnimal;
import co.edu.ufps.huelleritos.entities.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet({"/Usuario","/Usuario/Evidencia/Enviar","/Usuario/Evidencia","/Usuario/Login","/Usuario/Login/Log","/logout"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    AnimalDAO animalDAO;
    SeguimientoAnimalDAO seguimientoAnimalDAO;
    UsuarioDAO usuarioDAO;
    @Override
    public void init() throws ServletException {
    	super.init();
    	animalDAO=new AnimalDAO();
    	seguimientoAnimalDAO=new SeguimientoAnimalDAO();
    	usuarioDAO = new UsuarioDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ubicacion = request.getServletPath();
		System.out.println(ubicacion);
		
		if(ubicacion.contains("Evidencia")) {
			showFormEvidencia(request, response, ubicacion);
		}else if(ubicacion.contains("Login")) {
			showFormLogin(request, response, ubicacion.replace("/Login",""));
		}else if(ubicacion.contains("logout")) {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/Usuario/Login");
		}
		
	}
	
	protected void showFormEvidencia(HttpServletRequest request, HttpServletResponse response,String ubicacion) throws ServletException, IOException {
		if(ubicacion.contains("Enviar")) {
			registrarEvidencia(request, response);
		}else {
			mostrarEvidencia(request, response);;
		}
	}
	
	protected void showFormLogin(HttpServletRequest request, HttpServletResponse response,String ubicacion) throws ServletException, IOException {
		System.out.println(isLog(request) +" "+ request.getSession().getAttribute("usuario"));
		if(isLog(request)) {
			System.out.println(request.getSession().getAttribute("usuario"));
			enviarInicio(request, response, (String)request.getSession().getAttribute("tipoUsuario"));
			return;
		}
		
		if(ubicacion.contains("Log")) {
			String usuario= request.getParameter("usuario");
			String contrasenia=request.getParameter("password");
			String tipo = request.getParameter("tipo");			
			if(usuario== null || contrasenia==null || tipo== null) {
				//ERROR
				//return;
			}			
			Usuario usuarioEntity=new Usuario();
			usuarioEntity.setUsuario(usuario);
			usuarioEntity.setContraseña(contrasenia);
			switch(tipo) {
			case "admin":
				usuarioEntity.IniciarAdministradors();
				break;
			case "hogar":
				usuarioEntity.IniciarHogar();				
				break;
			case "adoptante":
				usuarioEntity.IniciarAdoptante();
				break;
			}
			logear(request, response, usuarioEntity,tipo);			

		}else {
			mostrarLogin(request, response);;
		}
	}
	
	protected Boolean isLog(HttpServletRequest request) throws ServletException, IOException {	
		return  request.getSession().getAttribute("usuario")!=null;
	}
	
	protected void enviarInicio(HttpServletRequest request, HttpServletResponse response,String tipo) throws ServletException, IOException {
	
		switch(tipo) {
		case "admin":
			response.sendRedirect(request.getContextPath()+"/admin");
			break;
		default:
			response.sendRedirect(request.getContextPath());
			break;
		}
		
	}
	protected void logear(HttpServletRequest request, HttpServletResponse response,Usuario usuario,String tipo) throws ServletException, IOException {
		
		if(usuarioDAO.logear(usuario)) {
			request.getSession().setAttribute("usuario", usuario.getUsuario());
			request.getSession().setAttribute("tipoUsuario",tipo);
			enviarInicio(request, response, tipo);
		}else {
			//REENVIE E IMPRIMA ERROR
			System.out.println("no existe");
			response.sendRedirect(request.getContextPath()+"/Usuario/Login");
		}
		
		
	}
	
	protected void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/administrador/login.jsp").forward(request, response);
	
	}
	
	
	protected void mostrarEvidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Animal>animales = animalDAO.listAnimalesByUsuario("danielito");
		request.setAttribute("animales", animales);
		request.getRequestDispatcher("/seguimiento-animal.jsp").forward(request, response);
	
	}
	
	protected void registrarEvidencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		String evidencia = request.getParameter("archivo");
		String codigoAnimal = request.getParameter("animal");
		Animal animalBuscado = animalDAO.find(codigoAnimal);
		SeguimientoAnimal seguimientoAnimalBuscado= seguimientoAnimalDAO.findByAnimal(codigoAnimal);
		
		if(seguimientoAnimalBuscado != null ) {
			seguimientoAnimalBuscado.setObservacion(descripcion);
			seguimientoAnimalBuscado.setFoto(evidencia);
			seguimientoAnimalBuscado.setVideo(evidencia);
			seguimientoAnimalBuscado.setFecha(new Date());
			seguimientoAnimalDAO.update(seguimientoAnimalBuscado);
		}else if(animalBuscado !=null) {
			SeguimientoAnimal seguimientoAnimal = new SeguimientoAnimal();	
			seguimientoAnimal.setObservacion(descripcion);
			seguimientoAnimal.setFoto(evidencia);
			seguimientoAnimal.setVideo(evidencia);
			seguimientoAnimal.setFecha(new Date());
			seguimientoAnimal.setAnimal(animalBuscado);
			seguimientoAnimal.setCodigoSeguimiento("11"+codigoAnimal);			
		}
		
		response.sendRedirect(request.getContextPath()+"/Usuario/Evidencia");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
