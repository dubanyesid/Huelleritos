<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Solicitud Adoptante</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">

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
				
				
				<h3><img src="assets/img/Huelleritos.png"></h3>
				
				
				<ul class="list-unstyled menu-elements" >
					<li>
						<a  href="inicioAdmin.jsp">Inicio</a>
					</li>
					<li>
						<a  href="lista-animales.jsp">Animales</a>
					</li>
					<li>
						<a href="donaciones.jsp">Donaciones</a>
					</li>
					<li>
						<a href="seguimiento-animal.jsp">Seguimiento</a>
					</li>
					<li>
						<a href="solicitud-adoptante.jsp">Solicitudes Adopcion</a>
					</li>
					<li>
						<a  href="solicitud-hogar-paso.jsp">Solicitudes Hogares de Paso</a>
					</li>
					<li>
						<a  href="noticia.jsp">Noticias y Eventos</a>
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
						SOLICITUD #
					</h1>
				</div>
						<form>
					        <div class="form-row">
					        
					        <div class="form-group col-md-3">            
					                <label for="nombre">Nombre</label>
					                <input type="text" name="nombre" class="form-control">
					            </div>
					            
					            <div class="form-group col-md-3">
					                <label for="apellido">Apellido</label>
					                <input type="text" name="apellido" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="fecha">Fecha</label>
					                <input type="text" name="fecha" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="cedula">No.Cédula</label>
					                <input type="text" name="cedula" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="correo">Correo</label>
					                <input type="email" name="correo" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="fecha-nacimiento">Fecha de nacimiento</label>
					                <input type="date" name="fecha-nacimiento" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="barrio">Barrio de residencia</label>
					                <input type="number" name="barrio" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="direccion">Dirección</label>
					                <input type="text" name="direccion" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
		                			<label for="telefono">Teléfono</label>
		                			<input type="number" class="form-control" name="telefono"></input>
		            			</div>
		            			<div class="form-group col-md-3">
		                			<label for="trabajo-actual">Trabajo actual</label>
		                			<input type="text" class="form-control" name="trabajo-actual"></input>
		            			</div>
		            			<div class="form-group col-md-3">
					                <label for="numero-adultos">¿Cuántos adultos viven en tu casa?</label>
					                <input type="number" name="numero-adultos" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="numero-niños">¿Cuántos niños viven en tu casa?</label>
					                <input type="number" name="numero-niños" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="edad-ninos">¿Qué edad tienen los niños?</label>
					                <input type="text" name="edad-ninos" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="animal-interesado">Nombre del animal interesado</label>
					                <input type="text" name="animal-interesado" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="tipo-animal">Tipo de animal</label>
					                <input type="text" name="tipo-animal" class="form-control">
					            </div>
					            <div class="form-group col-md-3">
					                <label for="tenido-animal">¿Haz tenido un animal antes?</label>
					                <select name="tenido-animal" id="tasking" class="form-control">
					                    <option value="si">SI</option>
					                    <option value="no" selected>NO</option>
					                </select>
					            </div>
					            <div class="form-group col-md-4">
					                <label for="descripcion">¿Por qué quieres adoptar un animal?</label>
					                <textarea class="form-control" id="descripcion" rows="3"></textarea>
					            </div>
					            <div class="form-group col-md-3">
					                <label for="estado">Estado</label>
					                <select name="estado" id="tasking" class="form-control">
					                    <option value="si">SI</option>
					                    <option value="no" selected>NO</option>
					                </select>
					            </div>
					        </div> <!-- cierre de form-row -->
					        <!-- dejo fuera a submit -->
					        <div class="form-group">
					            <input type="submit" value="Guardar" class="btn btn-dark">
					        </div>
					    </form>
			</div>
			<div class="container">
				<div>
					<h1>
						SOLICITUD #
					</h1>
				</div>
						<form>
							<h2>Datos Familiares y de Vivienda</h2>
					        <form>

							  <!-- <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">Número de personas que viven en el hogar</label>
							    <div class="col-sm-5">
							      <input type="number" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <div class="col-sm-2">¿Tiene niños en casa?</div>
							    <div class="col-sm-2">
							      <select name="nino" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      Edad <input class="col-sm-4 col-form-label" type="number"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="inputEmail3" class="col-sm-7 col-form-label">¿Todos están de acuerdo en la tenencia de la mascota?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿La vivienda es propia?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="inputEmail3" class="col-sm-7 col-form-label">En caso de ser arrendada ¿Los arrendatarios están de acuerdo en la tenencia de la mascota?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div> -->
							   <div class="form-row">
					        
					        <div class="form-group col-md-3">            
					                <label for="nombre">Nombre</label>
					                <input type="text" name="nombre" class="form-control">
					            </div>
</div>

							  <h2>Sobre las mascotas del hogar</h2>
					        <form>

							  <div class="form-group row">
							    <div class="col-sm-2">
							    	¿Tienes mascotas?
							    </div>
							    <div class="col-sm-2">
							      <select name="mascota" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      Cuantas <input class="col-sm-4 col-form-label" type="number"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Conviven con mas animales?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Dónde duermen las mascotas?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Cómo reprendes a los animales con su mal comportamiento?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	¿Tienes las vacunas al día?
								</label>
							    <div class="col-sm-5">
							      <select name="sexo" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	¿Están bien de salud? En caso de estar enfermos ¿Qué padecen?
								</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
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
			<div class="container">
				<div>
					<h1>
						SOLICITUD #
					</h1>
				</div>
						<form>
							<h2>Datos Familiares y de Vivienda</h2>
					        <form>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">Número de personas que viven en el hogar</label>
							    <div class="col-sm-5">
							      <input type="number" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <div class="col-sm-2">¿Tiene niños en casa?</div>
							    <div class="col-sm-2">
							      <select name="nino" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      Edad <input class="col-sm-4 col-form-label" type="number"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="inputEmail3" class="col-sm-7 col-form-label">¿Todos están de acuerdo en la tenencia de la mascota?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿La vivienda es propia?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="inputEmail3" class="col-sm-7 col-form-label">En caso de ser arrendada ¿Los arrendatarios están de acuerdo en la tenencia de la mascota?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>


							  <h2>Sobre las mascotas del hogar</h2>
					        <form>

							  <div class="form-group row">
							    <div class="col-sm-2">
							    	¿Tienes mascotas?
							    </div>
							    <div class="col-sm-2">
							      <select name="mascota" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      Cuantas <input class="col-sm-4 col-form-label" type="number"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Conviven con mas animales?</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Dónde duermen las mascotas?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">¿Cómo reprendes a los animales con su mal comportamiento?</label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	¿Tienes las vacunas al día?
								</label>
							    <div class="col-sm-5">
							      <select name="sexo" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	¿Están bien de salud? En caso de estar enfermos ¿Qué padecen?
								</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
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
		<script src="assets/js/jquery-3.3.1.min.js"></script>
		<script src="assets/js/jquery-migrate-3.0.0.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/jquery.waypoints.min.js"></script>
        <script src="assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>