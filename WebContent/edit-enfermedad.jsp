<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.edu.ufps.huelleritos.entities.EnfermedadHistorial"%>
<%@page import="co.edu.ufps.huelleritos.entities.Enfermedad"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head> 

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Agregar Enfermedad</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/jquery.mCustomScrollbar.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/media-queries.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
    	<div>
			<!--Navbar-->
			<nav class="navbar navbar-dark  bg-dark">
			  <a class="form-inline my-2 my-lg-0 ml-auto">
			  	Usuario
			  </a>
			</nav>
			<!--/.Navbar-->
    	</div>    	

		<!-- Wrapper -->
    	

			<!-- Sidebar -->
			<nav class="sidebar">
				
				<!-- close sidebar menu -->
				<div class="dismiss">
					<i class="fas fa-arrow-left"></i>
				</div>
				
				
					<h3><img src="<%=request.getContextPath()%>/assets/img/Huelleritos.png"></h3>
				
				
				<ul class="list-unstyled menu-elements" >
					<li>
						<a  href="<%=request.getContextPath()%>/admin/inicio">Inicio</a>
					</li>
					<li>
						<a  href="<%=request.getContextPath()%>/admin/animal/listar">Animales</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/donaciones.jsp">Donaciones</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/seguimiento-animal.jsp">Seguimiento</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/Solicitudes/Adopcion">Solicitudes Adopcion</a>
					</li>
					<li>
						<a  href="<%=request.getContextPath()%>/Solicitudes/HogarDePaso">Solicitudes Hogares de Paso</a>
					</li>
					<li>
						<a  href="<%=request.getContextPath()%>/Noticias">Noticias y Eventos</a>
					</li>
					<li>
						<a  href="<%=request.getContextPath()%>/NoticiasEvidencias">Noticias y Evidencias</a>
					</li>
					<li>
						<a  href="<%=request.getContextPath()%>/logout">Cerrar sesion</a>
					</li>
				</ul>
				
				<div class="dark-light-buttons">
					<a class="btn btn-primary btn-customized-4 btn-customized-dark" href="#" role="button">Dark</a>
					<a class="btn btn-primary btn-customized-4 btn-customized-light" href="#" role="button">Light</a>
				</div>
			
			</nav>
			<!-- End sidebar -->
			
			<!-- Dark overlay -->
    		

			<!-- Content -->
			
			<%
                EnfermedadHistorial enfermedad = (EnfermedadHistorial) request.getAttribute("enfermedad");
				List<Enfermedad> enfermedades = (List<Enfermedad>) request.getAttribute("enfermedades");
                if(enfermedad==null || enfermedades==null){
                	
                	response.sendRedirect(request.getContextPath()+"");
                	return;
                }
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                %>
			
			
			
				<!-- open sidebar menu -->
				<a class="btn btn-primary btn-customized open-menu" href="#" role="button">
                    <i class="fas fa-align-left"></i> <span>Menu</span>
                </a>
               			<h2><strong>EDITAR ENFERMEDAD</strong></h2> <br>
		        		<h3><strong>ID ANIMAL #<%=enfermedad.getHistorialAnimal().getAnimal().getCodigoAnimal() %></strong></h3>
		        	<div class="container">

        
        <div class="row">
            <div class="col-md-12">
                <form method="post" action="editEnfermedad/enviar">
                 <input name="idEnfermedad" hidden value="<%=enfermedad.getIdEnfermedadHistorial()%>">
                    <ul class="contact-form">
                        <li>
                            <div ><h6>NOMBRE ENFERMEDAD</h6>
                            	<select name="enfermedad">
  								<%
  								for(Enfermedad enfermedadG : enfermedades){
  								%>
  								<option <%=enfermedadG.getCodigoEnfermedad().equals(enfermedad.getEnfermedad().getCodigoEnfermedad())?"selected":"" %> value="<%=enfermedadG.getCodigoEnfermedad()%>"><%=enfermedadG.getNombreEnfermedad() %></option>
  								<%
  								}
  								%>
								</select>
                              
                            </div>

                            
                        </li>

                        <li>
                            <div ><h6>FECHA INICIO</h6>
                                <input name="fechaInicio" value="<%=sdf.format(enfermedad.getFechaInicio()) %>" placeholder="Escribe la Fecha" required="required" size="8" type="date" />
                            </div>
                            <div ><h6>FECHA FINAL</h6>
                                <input name="fechaFin"  value="<%=sdf.format(enfermedad.getFechaFin()) %>" placeholder="Escribe la Fecha" required="required" size="8" type="date" />
                            </div>
   <li>
                            <div class="col-md-12">
                                <button type="submit">
                    LIMPIAR
                    <span
                      class="glyphicon glyphicon-arrow-right"
                      aria-hidden="true"
                    ></span>
                  </button>
                            </div>
                        </li>	
                            
                        <li>
                            <div class="col-md-12">
                                <button type="submit">
                    EDITAR
                    <span
                      class="glyphicon glyphicon-arrow-right"
                      aria-hidden="true"
                    ></span>
                  </button>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div><br><br><br>
         

    </div>

		        <!-- Footer -->
		        <footer class="footer-container">
		
			        <div class="container">
			        	<div class="row">
		
		                    <div class="col">
		                    	&copy; Huelleritos todos los derechos reservados.
		                    </div>
		
		                </div>
			        </div>
		
		        </footer>
	        
	        
	        <!-- End content -->
        
        
        <!-- End wrapper -->

        <!-- Javascript -->
		<script src="<%=request.getContextPath()%>/assets/js/jquery-3.3.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery-migrate-3.0.0.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/assets/js/jquery.backstretch.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/jquery.waypoints.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/scripts.js"></script>

    </body>

</html>