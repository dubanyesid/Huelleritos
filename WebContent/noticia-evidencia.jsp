<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="co.edu.ufps.huelleritos.entities.*" %>
<%@ page import ="co.edu.ufps.huelleritos.dao.*" %>

<!DOCTYPE html>
<html lang="es">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Noticia Evidencia</title>

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
    	<div class="wrapper">

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
    		<div class="overlay"></div>

			<!-- Content -->
			<div class="content mt-5">
			
				<!-- open sidebar menu -->
				<a class="btn btn-primary btn-customized open-menu" href="#" role="button">
                    <i class="fas fa-align-left"></i> <span>Menu</span>
                </a>
			<div class="container">
				<div>
					<h1>
						Nueva Noticia
					</h1>
				</div>
						<form>
							
					        <form>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">Titulo</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  
							    <div class="form-group row">
					                <label for="descripcion" class="col-sm-7 col-form-label">Descripción</label>
					                <div class="col-sm-5">
					                	<textarea class="form-control" id="descripcion" rows="3"></textarea>
					            	</div>
					            </div>
							  </div>

							  <div class="form-group row">
							   	<div class="container mt-5">
									  <h3 class="text-center">Subir imagen</h3>
									  <div class="col-sm-12 col-lg-4 mr-auto ml-auto border p-4">
									  <form method="post" enctype="multipart/form-data">
									    <div class="form-group">
									      <label><strong>Subir</strong></label>
									      <div class="custom-file">
									        <input type="file" name="files[]" multiple class="custom-file-input form-control" id="customFile">
									        <label class="custom-file-label" for="customFile">Elegir archivo</label>
									      </div>
									    </div>
									    <div class="form-group">
									      <button type="button" name="upload" value="upload" id="upload" class="btn btn-block btn-dark"><i class="fa fa-fw fa-upload"></i> Subir</button>
									    </div>
									  </form>
									</div>
							   		</div>
								</div>
							  

							  
							</form>
					        <!-- cierre de form-row -->
					        <!-- dejo fuera a submit -->
					        <div class="form-group">
					            <input type="submit" value="Guardar" class="btn btn-dark">
					        </div>
					    </form>
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
	        
	        </div>
	        <!-- End content -->
        
        </div>
        <!-- End wrapper -->

        <!-- Javascript -->

        <!--Javascriptbotonimagen-->
        <script>
        	$(document).ready(function() {
			  $('input[type="file"]').on("change", function() {
			    let filenames = [];
			    let files = this.files;
			    if (files.length > 1) {
			      filenames.push("Total Files (" + files.length + ")");
			    } else {
			      for (let i in files) {
			        if (files.hasOwnProperty(i)) {
			          filenames.push(files[i].name);
			        }
			      }
			    }
			    $(this)
			      .next(".custom-file-label")
			      .html(filenames.join(","));
				  });
				});	
        </script>

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