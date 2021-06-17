package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.huelleritos.dao.AnimalDAO;
import co.edu.ufps.huelleritos.dao.FormularioAnimalDAO;
import co.edu.ufps.huelleritos.dao.FormularioDAO;
import co.edu.ufps.huelleritos.dao.FormularioPreguntaDAO;
import co.edu.ufps.huelleritos.dao.OpcionDAO;
import co.edu.ufps.huelleritos.dao.PreguntaDAO;
import co.edu.ufps.huelleritos.entities.Animal;
import co.edu.ufps.huelleritos.entities.Formulario;
import co.edu.ufps.huelleritos.entities.FormularioAnimal;
import co.edu.ufps.huelleritos.entities.FormularioPregunta;
import co.edu.ufps.huelleritos.entities.Opcion;
import co.edu.ufps.huelleritos.entities.Pregunta;

/**
 * Servlet implementation class AdopcionController
 */
@WebServlet({ "/Adoptar", "/HogarDePaso","/Adoptar/Enviar","/HogarDePaso/Enviar" })
public class AdopcionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdopcionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	FormularioDAO formularioDAO;
	FormularioPreguntaDAO formularioPreguntaDAO;
	PreguntaDAO preguntaDAO;
	OpcionDAO opcionDAO;
	AnimalDAO animalDAO;
	FormularioAnimalDAO formularioAnimalDAO;
	public void init(ServletConfig config) throws ServletException {
		formularioDAO = new FormularioDAO();
		formularioPreguntaDAO = new FormularioPreguntaDAO();
		preguntaDAO=new PreguntaDAO();
		opcionDAO=new OpcionDAO();
		animalDAO=new AnimalDAO();
		formularioAnimalDAO = new FormularioAnimalDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ubicacion = request.getServletPath();
		System.out.println(ubicacion);

		if (ubicacion.contains("Adoptar")) {
			this.showFormAdopta(request, response,ubicacion.replace("/Adoptar", ""));
		} else if (ubicacion.contains("HogarDePaso")) {
			this.showFormHogar(request, response, ubicacion.replace("/HogarDePaso", ""));
		}
	}

	protected void insertAdopta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("insert adoptar");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String ocupacion = request.getParameter("ocupacion");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String celular = request.getParameter("celular");
		String cedula = request.getParameter("cedula");	
		String animal= request.getParameter("animal");
		Date date = new Date();		
		String[]preguntas = request.getParameterValues("preguntas"); 
		Enumeration<String>preguntasParametersNames =  request.getParameterNames();
		if(nombre==null || apellido==null ||ocupacion==null ||direccion==null ||correo==null ||telefono==null || celular==null || cedula==null
				|| preguntasParametersNames==null || preguntas==null || animal==null) {
			//ENVIE A UN ERROR
			//return;
		}
		
		Formulario formulario = new Formulario(apellido,cedula,celular,correo,date,nombre,telefono);		
		llenarFormularioPreguntaRadio(preguntasParametersNames, formulario, request);
		llenarFormularioPreguntaSelect(preguntas, formulario);
		llenarFormularioAnimal(animal, formulario);
		formularioDAO.insert(formulario);	
		
		response.sendRedirect(request.getContextPath()+"/HogarDePaso");
	}
	
	protected void insertarHogar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String ocupacion = request.getParameter("ocupacion");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String celular = request.getParameter("celular");
		String cedula = request.getParameter("cedula");	
		String animal= request.getParameter("animal");
		Date date = new Date();		
		String[]preguntas = request.getParameterValues("preguntas"); 
		Enumeration<String>preguntasParametersNames =  request.getParameterNames();
		if(nombre==null || apellido==null ||ocupacion==null ||direccion==null ||correo==null ||telefono==null || celular==null || cedula==null
				|| preguntasParametersNames==null || preguntas==null || animal==null) {
			//ENVIE A UN ERROR
			//return;
		}
		
		Formulario formulario = new Formulario(apellido,cedula,celular,correo,date,nombre,telefono);		
		llenarFormularioPreguntaRadio(preguntasParametersNames, formulario, request);
		llenarFormularioPreguntaSelect(preguntas, formulario);
		llenarFormularioAnimal(animal, formulario);
		formularioDAO.insert(formulario);	
		
		response.sendRedirect(request.getContextPath()+"/HogarDePaso");
	}
	
	
	protected void llenarFormularioAnimal(String animal,Formulario formulario) {
		Animal animalBuscado = animalDAO.find(animal);
		FormularioAnimal formularioAnimal = new FormularioAnimal();
		formularioAnimal.setAnimal(animalBuscado);
		formulario.addFormularioAnimal(formularioAnimal);
		//formularioAnimalDAO.insert(formularioAnimal);
		System.out.println("final 3");
	}
	
	protected void llenarFormularioPreguntaSelect(String[]preguntas,Formulario formulario) {
		System.out.println("entro aqui 3");
		for (String pregunta : preguntas) {			
			llenarFormularioPregunta(pregunta, formulario);
		}
		System.out.println("final 2");
	}
	
   protected void llenarFormularioPreguntaRadio(Enumeration<String> preguntasParametersNames,Formulario formulario, HttpServletRequest request) {
	   System.out.println("entro aqui 2");
	   while(preguntasParametersNames.hasMoreElements()) {
			Pregunta p = new Pregunta();
			FormularioPregunta fp=new  FormularioPregunta();
			String name = preguntasParametersNames.nextElement();
			if(name.contains("radio") ) {
				String pregunta = request.getParameter(name);				
				llenarFormularioPregunta(pregunta, formulario);
			}
			
		}
	   System.out.println("final 1");
}
   
   protected void llenarFormularioPregunta(String pregunta,Formulario formulario) {
	   System.out.println("entro aqui");
	   String split[]=pregunta.split("-");
	   Integer idPregunta = Integer.parseInt(split[0]);
		Integer idOpcion= Integer.parseInt(split[1]);
		Pregunta preguntaBuscada = preguntaDAO.find(idPregunta);
		Opcion opcionBuscado = opcionDAO.find(idOpcion);
		
		FormularioPregunta formularioPregunta=new FormularioPregunta();
		formularioPregunta.setOpcion(opcionBuscado);
		formularioPregunta.setPregunta(preguntaBuscada);
		formulario.addFormularioPregunta(formularioPregunta);
		//formularioPreguntaDAO.insert(formularioPregunta);
		
   }
	
   protected void mostrarFormHogar(HttpServletRequest request,HttpServletResponse response)
		   throws ServletException, IOException{
	   List<Pregunta>preguntas=preguntaDAO.listarFormHogarPaso();
	   List<Animal>animales = animalDAO.list();	   
	   request.setAttribute("animales", animales);	   
	   request.setAttribute("preguntas", preguntas);
	   
	   request.getRequestDispatcher("html/Formularios/Form_Hogar_Paso.jsp").forward(request, response);
	   
   }
   
   protected void mostrarFormAdopta(HttpServletRequest request,HttpServletResponse response)
		   throws ServletException, IOException{
	   List<Pregunta>preguntas=preguntaDAO.listarFormAdopta();
	   List<Animal>animales = animalDAO.list();	   
	   request.setAttribute("animales", animales);	   
	   request.setAttribute("preguntas", preguntas);
	   
	   request.getRequestDispatcher("html/Formularios/Form_Adopta.jsp").forward(request, response);
	   
   }
   
	protected void showFormHogar(HttpServletRequest request, HttpServletResponse response,String ubicacion)
			throws ServletException, IOException {		
		switch(ubicacion) {
		case "/Enviar":
			insertarHogar(request, response);
			break;
		default:
			mostrarFormHogar(request,response);
			break;
		}
		
	}
	
	protected void showFormAdopta(HttpServletRequest request, HttpServletResponse response,String ubicacion)
			throws ServletException, IOException {		
		switch(ubicacion) {
		case "/Enviar":
			insertAdopta(request, response);
			break;
		default:
			mostrarFormAdopta(request,response);
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
