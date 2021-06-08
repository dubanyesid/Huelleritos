<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Lista Animales</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="../assets/css/jquery.mCustomScrollbar.min.css">
        <link rel="stylesheet" href="../assets/css/animate.css">
        <link rel="stylesheet" href="../assets/css/style.css">
        <link rel="stylesheet" href="../assets/css/media-queries.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

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
				
				
					<h3><a href="index.html"> Logo</a></h3>
				
				
				<ul class="list-unstyled menu-elements" >
					<li class="active">
						<a class="scroll-link" href="#top-content"></i>Inicio</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-1"></i>Animales</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-2"></i>Donaciones</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-5"></i>Seguimiento</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-6"></i>Solicitudes Adopcion</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-6"></i>Solicitudes Hogares de Paso</a>
					</li>
					<li>
						<a class="scroll-link" href="#section-6"></i>Noticias y Eventos</a>
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
					<div class="col-md-4 m-2">
						<h1>Lista de Animales</h1>
						<button type="button" class="btn btn-dark">Agregar Animal</button>
					</div>
					
					<div class="row justify-content-center justify-content-md-start">
					<table class="table table-bordered">
						<thead class="table-dark">
							<tr>
								<th scope="col">ID</th>
								<th scope="col">NOMBRE</th>
								<th scope="col">TIPO ANIMAL</th>
								<th scope="col">EDAD</th>
								<th scope="col">ESTADO</th>
								<th scope="col">HISTORIA CLINICA</th>
								<th scope="col">INFORMACI�N</th>
								<th scope="col">ACCIONES</th>
							</tr>
						</thead>
						<tbody >
							<tr>
								<th scope="row">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>value</td>
								<td>value</td>
								<td><button type="button" class="btn btn-dark">Historial</button></td>
								<td><button type="button" class="btn btn-dark">Editar</button></td>
								<td><button type="button" class="btn btn-dark">Eliminar</button></td>
							</tr>
							
						</tbody>
					</table>
				</div>
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
		<script src="../assets/js/jquery-3.3.1.min.js"></script>
		<script src="../assets/js/jquery-migrate-3.0.0.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="../assets/js/jquery.backstretch.min.js"></script>
        <script src="../assets/js/wow.min.js"></script>
        <script src="../assets/js/jquery.waypoints.min.js"></script>
        <script src="../assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="../assets/js/scripts.js"></script>

    </body>

</html>