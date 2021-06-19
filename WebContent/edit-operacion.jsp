<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.edu.ufps.huelleritos.entities.OperacionesAnimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Historial Clinico</title>

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
			<jsp:include page="menuAdmin.jsp" />
			<!-- End sidebar -->
			
			<!-- Dark overlay -->
    		

			<!-- Content -->
			
			
				<!-- open sidebar menu -->
				<a class="btn btn-primary btn-customized open-menu" href="#" role="button">
                    <i class="fas fa-align-left"></i> <span>Menu</span>
                </a>
                <%
                OperacionesAnimal operacion = (OperacionesAnimal) request.getAttribute("operacion");
                if(operacion==null){
                	
                	response.sendRedirect(request.getContextPath()+"");
                	return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                %>
               		   <h2><strong>EDITAR OPERACION</strong></h2> <br>
                        <h3><strong>ID ANIMAL #<%=operacion.getHistorialAnimal().getAnimal().getCodigoAnimal() %></strong></h3>
                    <div class="container">

        
        <div class="row">
            <div class="col-md-12">
                <form method="post" action="editOperacion/enviar">
                 <input name="idOperacion" hidden value="<%=operacion.getIdOperacionesAnimal()%>">
                    <ul class="contact-form">
                        <li>
                           

                            <div><h6>NOMBRE OPERACION</h6>
                                <input maxlength="45" value="<%=operacion.getNombreOperacion() %>" name="nombre" placeholder="Escribir Nombre" required="required" size="8" type="text" />
                            </div>
                        </li>

                        <li>
                       
                            <div ><h6>FECHA OPERACION</h6>
                                <input value="<%=sdf.format(operacion.getFechaOperacion()) %>" name="fechaInicio" placeholder="Escribe la Fecha" required="required" size="8" type="date" />
                            </div>
                            <div ><h6>FECHA RECUPERACION</h6>
                                <input value="<%=sdf.format(operacion.getFechaRecuperacion())%>" name="fechaFin" placeholder="Escribe la Fecha" required="required" size="8" type="date" />
                            </div>
                            <div ><h6>OBSERVACIONES</h6>
                                <textarea name="observacion" placeholder="Escribe Observaciones" required="required" size="8" type="date" ><%=operacion.getObservaciones() %></textarea>
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