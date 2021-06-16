package co.edu.ufps.huelleritos.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UsuarioDAO usuarioDAO;


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		usuarioDAO = new UsuarioDAO();

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
		response.sendRedirect(request.getContextPath() + "/admin/generarUsuario");

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
				System.out.println("oe");
				us.setAdoptante(new Adoptante(usuario,"Espera",us));
				break;			
			case "Hogar":
				System.out.println("io");
				us.setHogarDePaso(new HogarDePaso(usuario,us));
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/Error");
				return;
			}
			usuarioDAO.insert(us);
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

	/*
	 * protected void animales(HttpServletRequest request, HttpServletResponse
	 * response, String estoy) throws ServletException, IOException { switch (estoy)
	 * { case "/historial": showViewHistorial(request, response); break; case
	 * "/listar": showViewListar(request, response); break; case "/agregar":
	 * showViewAgregar(request, response); break; case "/editar":
	 * showViewEditar(request, response); break; case "/eliminar":
	 * eliminarAnimal(request, response); break; case "/agregar/enviar":
	 * registrarAnimal(request, response); break; case "/editar/enviar":
	 * editarAnimal(request, response); break; default: //
	 * response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
	 * 
	 * if (estoy.contains("/deleteOperacion") ||
	 * estoy.contains("/addOperacion/enviar") || estoy.contains("/addOperacion") ||
	 * estoy.contains("/editOperacion") || estoy.contains("/editOperacion/enviar")
	 * || estoy.contains("/historial/operacion")) { AnimalOperaciones(request,
	 * response, estoy); return; }
	 * 
	 * 
	 * if (estoy.contains("/deleteVacuna") || estoy.contains("/addVacuna/enviar") ||
	 * estoy.contains("/addVacuna") || estoy.contains("/editVacuna") ||
	 * estoy.contains("/editVacuna/enviar") || estoy.contains("/historial/vacuna"))
	 * { AnimalVacunas(request, response, estoy); return; }
	 * 
	 * 
	 * if (estoy.contains("/deleteEnfermedad") ||
	 * estoy.contains("/addEnfermedad/enviar") || estoy.contains("/addEnfermedad")
	 * || estoy.contains("/editEnfermedad") ||
	 * estoy.contains("/editEnfermedad/enviar") ||
	 * estoy.contains("/historial/enfermedad")) { AnimalEnfermedad(request,
	 * response, estoy); return; }
	 * 
	 * 
	 * request.getRequestDispatcher("/lista-animales.jsp").include(request,
	 * response); break; }
	 * 
	 * }
	 * 
	 * protected void showViewHistorial(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * String codigoAnimal = request.getParameter("animal"); if (codigoAnimal ==
	 * null) { // ERROR // return; }
	 * 
	 * Animal animalBuscado = animalDAO.find(codigoAnimal);
	 * 
	 * request.setAttribute("historial",
	 * animalBuscado.getHistorialAnimals().get(0)); ServletContext sc =
	 * getServletContext();
	 * sc.getRequestDispatcher("/historial-clinico.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void showViewListar(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * List<Animal> animales = animalDAO.list(); request.setAttribute("animales",
	 * animales); //
	 * response.sendRedirect(request.getContextPath()+"/lista-animales.jsp");
	 * request.getRequestDispatcher("/lista-animales.jsp").include(request,
	 * response);
	 * 
	 * }
	 * 
	 * protected void showViewAgregar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * List<TipoAnimal> tipoAnimales = tipoAnimalDAO.list(); List<Prioridad>
	 * prioridades = prioridadDAO.list(); List<Guarderia> guarderias =
	 * guarderiaDAO.list(); request.setAttribute("tipos", tipoAnimales);
	 * request.setAttribute("prioridades", prioridades);
	 * request.setAttribute("guarderias", guarderias);
	 * request.getRequestDispatcher("/formulario-animal.jsp").include(request,
	 * response);
	 * 
	 * }
	 * 
	 * protected void showViewEditar(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String codigoAnimal =
	 * request.getParameter("animal"); if (codigoAnimal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } Animal animalBuscado = animalDAO.find(codigoAnimal);
	 * List<TipoAnimal> tipoAnimales = tipoAnimalDAO.list(); List<Prioridad>
	 * prioridades = prioridadDAO.list(); List<Guarderia> guarderias =
	 * guarderiaDAO.list(); request.setAttribute("tipos", tipoAnimales);
	 * request.setAttribute("prioridades", prioridades);
	 * request.setAttribute("guarderias", guarderias);
	 * request.setAttribute("animal", animalBuscado);
	 * request.getRequestDispatcher("/editar-animal.jsp").include(request,
	 * response);
	 * 
	 * }
	 * 
	 * protected void eliminarAnimal(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String codigoanimal =
	 * request.getParameter("animal");
	 * 
	 * if (codigoanimal == null) { // ERROR response.sendredired(); // return; }
	 * Animal animal = animalDAO.find(codigoanimal); if (animal == null) { // ERROR
	 * // return; } animalDAO.deleteClearCache(animal);
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * 
	 * }
	 * 
	 * protected void registrarAnimal(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigo = request.getParameter("codigo"), nombre =
	 * request.getParameter("nombre"), tipo = request.getParameter("tipo"), fecha =
	 * request.getParameter("fecha"), sexo = request.getParameter("sexo"), raza =
	 * request.getParameter("raza"), edad = request.getParameter("edad"), peso =
	 * request.getParameter("peso"), color = request.getParameter("color"),
	 * guarderia = request.getParameter("guarderia"), prioridad =
	 * request.getParameter("prioridad"), descripcion =
	 * request.getParameter("descripcion"), foto = request.getParameter("archivo");
	 * System.out.println(fecha); boolean validos = validarParametros(request,
	 * response, codigo, nombre, tipo, fecha, sexo, raza, edad, peso, color,
	 * guarderia, prioridad, descripcion, foto);
	 * 
	 * if (validos) { registroAnimal(request, response, codigo, nombre, tipo, fecha,
	 * sexo, raza, edad, peso, color, guarderia, prioridad, descripcion, foto); } }
	 * 
	 * private void registroAnimal(HttpServletRequest request, HttpServletResponse
	 * response,String codigo, String nombre, String tipo, String fecha, String
	 * sexo, String raza, String edad, String peso, String color, String guarderia,
	 * String prioridad, String descripcion, String foto) throws ServletException,
	 * IOException {
	 * 
	 * if (animalDAO.find(codigo) != null) { request.setAttribute("mensaje",
	 * "Ya existe el animal");
	 * request.getRequestDispatcher("/Error").forward(request, response); return; }
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); Date fechaIngreso
	 * = null; try { fechaIngreso = sdf.parse(fecha); } catch (ParseException e) {
	 * e.printStackTrace(); }
	 * 
	 * Animal animal = new Animal(codigo, color, descripcion, Integer.valueOf(edad),
	 * fechaIngreso, foto, nombre, peso, raza, sexo); int idTipo =
	 * Integer.parseInt(tipo); int idPrioridad = Integer.parseInt(prioridad);
	 * setAnimal(request,response,animal,idTipo, idPrioridad,guarderia);
	 * 
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar"); }
	 * 
	 * private void setAnimal(HttpServletRequest request, HttpServletResponse
	 * response, Animal animal, int idTipo, int idPrioridad, String guarderia)
	 * throws ServletException, IOException {
	 * animal.setTipoAnimal(tipoAnimalDAO.find(idTipo));
	 * animal.setPrioridad(prioridadDAO.find(idPrioridad));
	 * animal.setGuarderia(guarderiaDAO.find(guarderia));
	 * animal.setEstadoAnimalBean(estadoAnimalDAO.find(3));
	 * animal.iniciarHistoria(); animalDAO.insert(animal); }
	 * 
	 * private boolean validarParametros(HttpServletRequest request,
	 * HttpServletResponse response, String codigo, String nombre, String tipo,
	 * String fecha, String sexo, String raza, String edad, String peso, String
	 * color, String guarderia, String prioridad, String descripcion, String foto)
	 * throws ServletException, IOException { if (codigo == null || nombre == null
	 * || tipo == null || fecha == null || sexo == null || raza == null || edad ==
	 * null || peso == null || color == null || guarderia == null || prioridad ==
	 * null || descripcion == null || foto == null) {
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/agregar?error=faltaAlgo"); return false; } if
	 * (codigo.equals("") || nombre.equals("") || tipo.equals("") ||
	 * fecha.equals("") || sexo.equals("") || raza.equals("") || edad.equals("") ||
	 * peso.equals("") || color.equals("") || guarderia.equals("") ||
	 * prioridad.equals("") || descripcion.equals("") || foto.equals("")) {
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/agregar?error=faltaAlgo"); return false; } return true; }
	 * 
	 * protected void editarAnimal(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String codigo =
	 * request.getParameter("codigo"), nombre = request.getParameter("nombre"), tipo
	 * = request.getParameter("tipo"), fecha = request.getParameter("fecha"), sexo =
	 * request.getParameter("sexo"), raza = request.getParameter("raza"), edad =
	 * request.getParameter("edad"), peso = request.getParameter("peso"), color =
	 * request.getParameter("color"), guarderia = request.getParameter("guarderia"),
	 * prioridad = request.getParameter("prioridad"), descripcion =
	 * request.getParameter("descripcion"), foto = request.getParameter("archivo");
	 * System.out.println(fecha); boolean validos = validarParametros(request,
	 * response, codigo, nombre, tipo, fecha, sexo, raza, edad, peso, color,
	 * guarderia, prioridad, descripcion, foto);
	 * 
	 * if (validos) { int idTipo = Integer.parseInt(tipo); int idPrioridad =
	 * Integer.parseInt(prioridad); if (animalDAO.find(codigo) != null) { // ERROR
	 * YA EXISTE; // return; } SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date fechaIngreso = null; try { fechaIngreso
	 * = sdf.parse(fecha); } catch (ParseException e) { e.printStackTrace(); }
	 * 
	 * Animal animal = animalDAO.find(codigo); animal.setColor(color);
	 * animal.setDescripcion(descripcion); animal.setEdad(Integer.valueOf(edad));
	 * animal.setFechaIngreso(fechaIngreso); animal.setImagenAnimal(foto);
	 * animal.setNombreAnimal(nombre); animal.setPeso(peso); animal.setRaza(raza);
	 * animal.setSexo(sexo); animal.setTipoAnimal(tipoAnimalDAO.find(idTipo));
	 * animal.setPrioridad(prioridadDAO.find(idPrioridad));
	 * animal.setGuarderia(guarderiaDAO.find(guarderia)); animalDAO.update(animal);
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar"); } }
	 */

	/*
	 * protected void AnimalOperaciones(HttpServletRequest request,
	 * HttpServletResponse response, String estoy) throws ServletException,
	 * IOException { switch (estoy) { case "/deleteOperacion":
	 * EliminarOperacion(request, response); break; case "/addOperacion/enviar":
	 * registrarOperacion(request, response); break; case "/addOperacion":
	 * showViewOperacionAgregar(request, response); break; case "/editOperacion":
	 * showViewOperacionEditar(request, response); break; case
	 * "/editOperacion/enviar": editarOperacion(request, response); break; case
	 * "/historial/operacion": consultarOperacion(request, response); break; } }
	 * 
	 * protected void EliminarOperacion(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idOperacion = request.getParameter("operacion");
	 * 
	 * if (idOperacion == null) { // ERROR response.sendredired(); // return; }
	 * OperacionesAnimal operacion =
	 * operacionAnimalDAO.find(Integer.parseInt(idOperacion)); if (operacion ==
	 * null) { // ERROR // return; } String codigoAnimal =
	 * operacion.getHistorialAnimal().getAnimal().getCodigoAnimal();
	 * operacionAnimalDAO.deleteClearCache(operacion);
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigoAnimal);
	 * 
	 * }
	 * 
	 * protected void registrarOperacion(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigo = request.getParameter("codigoAnimal"); String fechaInicio =
	 * request.getParameter("fechaInicio"); String fechaFin =
	 * request.getParameter("fechaFin"); String nombre =
	 * request.getParameter("nombre"); String observacion =
	 * request.getParameter("observacion");
	 * 
	 * if (codigo == null || fechaInicio == null || fechaFin == null || nombre ==
	 * null || observacion == null) { // ERROR response.sendredired(); // return; }
	 * Animal animalBuscado = animalDAO.find(codigo);
	 * 
	 * HistorialAnimal historial = animalBuscado.getHistorialAnimals().get(0);
	 * OperacionesAnimal operacion = new OperacionesAnimal(); SimpleDateFormat sdf =
	 * new SimpleDateFormat("yyyy-MM-dd"); Date fechaUno = null; Date fechaDos =
	 * null; try { fechaUno = sdf.parse(fechaInicio); fechaDos =
	 * sdf.parse(fechaFin); } catch (ParseException e) { e.printStackTrace(); }
	 * operacion.setFechaRecuperacion(fechaDos);
	 * operacion.setFechaOperacion(fechaUno);
	 * operacion.setObservaciones(observacion);
	 * operacion.setNombreOperacion(nombre);
	 * operacion.setHistorialAnimal(historial);
	 * historial.addOperacionesAnimal(operacion);
	 * 
	 * operacionAnimalDAO.insert(operacion);
	 * 
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigo);
	 * 
	 * }
	 * 
	 * protected void showViewOperacionAgregar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigoAnimal = request.getParameter("animal"); if (codigoAnimal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } Animal animal = animalDAO.find(codigoAnimal); if (animal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } request.setAttribute("codigo", codigoAnimal); ServletContext sc =
	 * request.getServletContext();
	 * sc.getRequestDispatcher("/agg-operacion.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void showViewOperacionEditar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idOperacion = request.getParameter("operacion"); if (idOperacion == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } OperacionesAnimal operacionAnimal =
	 * operacionAnimalDAO.find(Integer.parseInt(idOperacion)); if (operacionAnimal
	 * == null) { response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/listar"); return; } request.setAttribute("operacion",
	 * operacionAnimal); ServletContext sc = request.getServletContext();
	 * sc.getRequestDispatcher("/edit-operacion.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void editarOperacion(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idOperacion = request.getParameter("idOperacion"); String fechaInicio =
	 * request.getParameter("fechaInicio"); String fechaFin =
	 * request.getParameter("fechaFin"); String nombre =
	 * request.getParameter("nombre"); String observacion =
	 * request.getParameter("observacion");
	 * 
	 * if (idOperacion == null || fechaInicio == null || fechaFin == null || nombre
	 * == null || observacion == null) { // ERROR response.sendredired(); // return;
	 * } OperacionesAnimal operacion =
	 * operacionAnimalDAO.find(Integer.parseInt(idOperacion)); if (operacion ==
	 * null) { // ERROR // return; } SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date fechaUno = null; Date fechaDos = null;
	 * try { fechaUno = sdf.parse(fechaInicio); fechaDos = sdf.parse(fechaFin); }
	 * catch (ParseException e) { e.printStackTrace(); }
	 * operacion.setFechaRecuperacion(fechaDos);
	 * operacion.setFechaOperacion(fechaUno);
	 * operacion.setObservaciones(observacion);
	 * operacion.setNombreOperacion(nombre); operacionAnimalDAO.update(operacion);
	 * 
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" +
	 * operacion.getHistorialAnimal().getAnimal().getCodigoAnimal());
	 * 
	 * }
	 * 
	 * protected void consultarOperacion(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * response.setContentType("application/json"); String idOperacion =
	 * request.getParameter("operacion"); if (idOperacion.equals("") ||
	 * idOperacion.contains("registra")) {
	 * response.getWriter().append("{'observacion':' '}"); return; }
	 * OperacionesAnimal operacionAnimal =
	 * operacionAnimalDAO.find(Integer.parseInt(idOperacion)); OperacionDTO
	 * operacionDTO = new OperacionDTO();
	 * operacionDTO.setObservacion(operacionAnimal.getObservaciones());
	 * SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * operacionDTO.setFechaOperacion(sd.format(operacionAnimal.getFechaOperacion())
	 * ); operacionDTO.setFechaRecuperacion(sd.format(operacionAnimal.
	 * getFechaRecuperacion())); ObjectMapper obj = new ObjectMapper(); String aux =
	 * obj.writeValueAsString(operacionDTO); response.getWriter().append(aux); }
	 */

	/*
	 * protected void AnimalVacunas(HttpServletRequest request, HttpServletResponse
	 * response, String estoy) throws ServletException, IOException { switch (estoy)
	 * { case "/deleteVacuna": EliminarVacuna(request, response); break; case
	 * "/addVacuna/enviar": registrarVacuna(request, response); break; case
	 * "/addVacuna": showViewVacunaAgregar(request, response); break; case
	 * "/editVacuna": showViewVacunaEditar(request, response); break; case
	 * "/editVacuna/enviar": editarVacuna(request, response); break; case
	 * "/historial/vacuna": consultarVacuna(request, response); break; } }
	 * 
	 * protected void EliminarVacuna(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String idVacuna =
	 * request.getParameter("vacuna");
	 * 
	 * if (idVacuna == null) { // ERROR response.sendredired(); // return; }
	 * VacunaHistorial vacunaHistorial =
	 * vacunaHistorialDAO.find(Integer.parseInt(idVacuna)); if (vacunaHistorial ==
	 * null) { // ERROR // return; } String codigoAnimal =
	 * vacunaHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal();
	 * vacunaHistorialDAO.deleteClearCache(vacunaHistorial);
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigoAnimal);
	 * 
	 * }
	 * 
	 * protected void registrarVacuna(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigo = request.getParameter("codigoAnimal"); String fecha =
	 * request.getParameter("fecha"); String vacuna =
	 * request.getParameter("vacuna");
	 * 
	 * if (codigo == null || fecha == null || vacuna == vacuna) { // ERROR
	 * response.sendredired(); // return; } if (codigo.equals("") ||
	 * fecha.equals("") || vacuna.equals("")) { // ERROR response.sendredired(); //
	 * return; } Animal animalBuscado = animalDAO.find(codigo); Vacuna vacunaBuscada
	 * = vacunaDAO.find(vacuna); HistorialAnimal historial =
	 * animalBuscado.getHistorialAnimals().get(0); VacunaHistorial vacunaHistorial =
	 * new VacunaHistorial(); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date fechaVacuna = null;
	 * 
	 * try { fechaVacuna = sdf.parse(fecha); } catch (ParseException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * vacunaHistorial.setFechaVacunacion(fechaVacuna);
	 * vacunaHistorial.setHistorialAnimal(historial);
	 * vacunaHistorial.setVacuna(vacunaBuscada);
	 * 
	 * historial.addVacunaHistorial(vacunaHistorial);
	 * 
	 * vacunaHistorialDAO.insert(vacunaHistorial);
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigo);
	 * 
	 * }
	 * 
	 * protected void showViewVacunaAgregar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigoAnimal = request.getParameter("animal"); if (codigoAnimal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } Animal animal = animalDAO.find(codigoAnimal); if (animal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } List<Vacuna> vacunas = vacunaDAO.list();
	 * request.setAttribute("codigo", codigoAnimal); request.setAttribute("vacunas",
	 * vacunas); ServletContext sc = request.getServletContext();
	 * sc.getRequestDispatcher("/agg-vacuna.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void showViewVacunaEditar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idVacuna = request.getParameter("vacuna"); if (idVacuna == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } VacunaHistorial vacunaHistorial =
	 * vacunaHistorialDAO.find(Integer.parseInt(idVacuna)); if (vacunaHistorial ==
	 * null) { response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/listar"); return; } List<Vacuna> vacunas = vacunaDAO.list();
	 * request.setAttribute("vacunas", vacunas); request.setAttribute("vacuna",
	 * vacunaHistorial); ServletContext sc = request.getServletContext();
	 * sc.getRequestDispatcher("/edit-vacuna.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void editarVacuna(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String idVacuna =
	 * request.getParameter("idVacuna"); String fecha =
	 * request.getParameter("fecha"); String vacuna =
	 * request.getParameter("vacuna"); if (idVacuna == null || fecha == null ||
	 * vacuna == null) { // ERROR response.sendredired(); // return; }
	 * VacunaHistorial vacunaHistorial =
	 * vacunaHistorialDAO.find(Integer.parseInt(idVacuna)); if (vacunaHistorial ==
	 * null) { // ERROR // return; } Vacuna vacunaBuscada = vacunaDAO.find(vacuna);
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); Date fechaUno =
	 * null; try { fechaUno = sdf.parse(fecha); } catch (ParseException e) {
	 * e.printStackTrace(); } vacunaHistorial.setFechaVacunacion(fechaUno);
	 * vacunaHistorial.setVacuna(vacunaBuscada);
	 * 
	 * vacunaHistorialDAO.update(vacunaHistorial);
	 * 
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" +
	 * vacunaHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal());
	 * 
	 * }
	 * 
	 * protected void consultarVacuna(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * response.setContentType("application/json"); String idHistorialVacuna =
	 * request.getParameter("vacuna"); if (idHistorialVacuna.equals("") ||
	 * idHistorialVacuna.contains("registra")) {
	 * response.getWriter().append("{'descripcion':' '}"); return; } VacunaHistorial
	 * vacunaHistorial =
	 * vacunaHistorialDAO.find(Integer.parseInt(idHistorialVacuna)); VacunaDTO
	 * vacuna = new VacunaDTO();
	 * vacuna.setDescripcion(vacunaHistorial.getVacuna().getDescripcion());
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * vacuna.setFecha(sdf.format(vacunaHistorial.getFechaVacunacion()));
	 * ObjectMapper obj = new ObjectMapper(); String aux =
	 * obj.writeValueAsString(vacuna); response.getWriter().append(aux); }
	 */

	/*
	 * protected void AnimalEnfermedad(HttpServletRequest request,
	 * HttpServletResponse response, String estoy) throws ServletException,
	 * IOException { switch (estoy) { case "/deleteEnfermedad":
	 * EliminarEnfermedad(request, response); break; case "/addEnfermedad/enviar":
	 * registrarEnfermedad(request, response); break; case "/addEnfermedad":
	 * showViewEnfermedadAgregar(request, response); break; case "/editEnfermedad":
	 * showViewEnfermedadEditar(request, response); break; case
	 * "/editEnfermedad/enviar": editarEnfermedad(request, response); break; case
	 * "/historial/enfermedad": consultarEnfermedad(request, response); break; } }
	 * 
	 * protected void EliminarEnfermedad(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idVacuna = request.getParameter("enfermedad");
	 * 
	 * if (idVacuna == null) { // ERROR response.sendredired(); // return; }
	 * EnfermedadHistorial historialEnfermedad =
	 * enfermedadHistorialDAO.find(Integer.parseInt(idVacuna)); if
	 * (historialEnfermedad == null) { // ERROR // return; } String codigoAnimal =
	 * historialEnfermedad.getHistorialAnimal().getAnimal().getCodigoAnimal();
	 * enfermedadHistorialDAO.deleteClearCache(historialEnfermedad);
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigoAnimal);
	 * 
	 * }
	 * 
	 * protected void registrarEnfermedad(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigo = request.getParameter("codigoAnimal"); String fechaInicio =
	 * request.getParameter("fechaInicio"); String fechaFin =
	 * request.getParameter("fechaFin"); String enfermedad =
	 * request.getParameter("enfermedad"); if (codigo == null || fechaInicio == null
	 * || fechaFin == null) { // ERROR response.sendredired(); // return; } if
	 * (codigo.equals("") || fechaInicio.equals("") || fechaFin.equals("")) { //
	 * ERROR response.sendredired(); // return; } Animal animalBuscado =
	 * animalDAO.find(codigo); Enfermedad enfermedadBuscada =
	 * enfermedadDAO.find(enfermedad); HistorialAnimal historial =
	 * animalBuscado.getHistorialAnimals().get(0); EnfermedadHistorial
	 * enfermedadHistorial = new EnfermedadHistorial(); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date fechaUno = null; Date fechaDos = null;
	 * try { fechaUno = sdf.parse(fechaInicio); fechaDos = sdf.parse(fechaFin); }
	 * catch (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * enfermedadHistorial.setEnfermedad(enfermedadBuscada);
	 * enfermedadHistorial.setHistorialAnimal(historial);
	 * enfermedadHistorial.setFechaFin(fechaDos);
	 * enfermedadHistorial.setFechaInicio(fechaUno);
	 * 
	 * historial.addEnfermedadHistorial(enfermedadHistorial);
	 * 
	 * enfermedadHistorialDAO.insert(enfermedadHistorial);
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" + codigo); }
	 * 
	 * protected void showViewEnfermedadAgregar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * codigoAnimal = request.getParameter("animal"); if (codigoAnimal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } Animal animal = animalDAO.find(codigoAnimal); if (animal == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } List<Enfermedad> enfermedades = enfermedadDAO.list();
	 * request.setAttribute("codigo", codigoAnimal);
	 * request.setAttribute("enfermedades", enfermedades); ServletContext sc =
	 * request.getServletContext();
	 * sc.getRequestDispatcher("/agg-enfermedad.jsp").forward(request, response); }
	 * 
	 * protected void showViewEnfermedadEditar(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idEnfermedad = request.getParameter("enfermedad"); if (idEnfermedad == null)
	 * { response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } EnfermedadHistorial enfermedadHistorial =
	 * enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedad)); if
	 * (enfermedadHistorial == null) {
	 * response.sendRedirect(request.getContextPath() + "/admin/animal/listar");
	 * return; } List<Enfermedad> enfermedades = enfermedadDAO.list();
	 * request.setAttribute("enfermedades", enfermedades);
	 * request.setAttribute("enfermedad", enfermedadHistorial); ServletContext sc =
	 * request.getServletContext();
	 * sc.getRequestDispatcher("/edit-enfermedad.jsp").forward(request, response);
	 * 
	 * }
	 * 
	 * protected void editarEnfermedad(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { String
	 * idEnfermedad = request.getParameter("idEnfermedad"); String fechaInicio =
	 * request.getParameter("fechaInicio"); String fechaFin =
	 * request.getParameter("fechaFin"); String enfermedad =
	 * request.getParameter("enfermedad");
	 * 
	 * if (idEnfermedad == null || fechaInicio == null || fechaFin == null ||
	 * enfermedad == null) { // ERROR response.sendredired(); // return; }
	 * EnfermedadHistorial enfermedadHistorial =
	 * enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedad)); if
	 * (enfermedadHistorial == null) { // ERROR // return; } Enfermedad
	 * enfermedadBuscada = enfermedadDAO.find(enfermedad); SimpleDateFormat sdf =
	 * new SimpleDateFormat("yyyy-MM-dd"); Date fechaUno = null; Date fechaDos =
	 * null; try { fechaUno = sdf.parse(fechaInicio); fechaDos =
	 * sdf.parse(fechaFin); } catch (ParseException e) { e.printStackTrace(); }
	 * enfermedadHistorial.setFechaInicio(fechaUno);
	 * enfermedadHistorial.setFechaFin(fechaDos);
	 * enfermedadHistorial.setEnfermedad(enfermedadBuscada);
	 * enfermedadHistorialDAO.update(enfermedadHistorial);
	 * 
	 * response.sendRedirect(request.getContextPath() +
	 * "/admin/animal/historial?animal=" +
	 * enfermedadHistorial.getHistorialAnimal().getAnimal().getCodigoAnimal());
	 * 
	 * }
	 * 
	 * protected void consultarEnfermedad(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * response.setContentType("application/json"); String idEnfermedadHistorial =
	 * request.getParameter("enfermedad"); if (idEnfermedadHistorial.equals("") ||
	 * idEnfermedadHistorial.contains("registra")) {
	 * response.getWriter().append("{'tratamiento':' '}"); return; }
	 * EnfermedadHistorial enfermedadHistorial =
	 * enfermedadHistorialDAO.find(Integer.parseInt(idEnfermedadHistorial));
	 * EnfermedadDTO enfermedadDTO = new EnfermedadDTO();
	 * enfermedadDTO.setTratamiento(enfermedadHistorial.getEnfermedad().
	 * getTratamientoEnfermedad()); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd");
	 * enfermedadDTO.setFechaInicio(sdf.format(enfermedadHistorial.getFechaInicio())
	 * ); enfermedadDTO.setFechaFin(sdf.format(enfermedadHistorial.getFechaFin()));
	 * ObjectMapper obj = new ObjectMapper(); String aux =
	 * obj.writeValueAsString(enfermedadDTO); response.getWriter().append(aux); }
	 */

}
