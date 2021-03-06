<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Datos Familiares</title>

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
			<jsp:include page="menuAdmin.jsp" />
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
							<h2>Datos familiares</h2>
					        <form>

							  <div class="form-group row">
							    <div class="col-sm-2">
							    	?Haz tenido mascotas anteriormente?
								</div>
							    <div class="col-sm-2">
							      <select name="mascota-anterior" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      ?Cu?les? <input class="col-sm-4 col-form-label" type="text"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="inputEmail3" class="col-sm-7 col-form-label">
							    	?Qu? pas? con ellos?
								</label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" >
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?D?nde duermen/dormian las mascotas?
								</label>
							    <div class="col-sm-5">
							      <input type="number" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?C?mo reprendes a los animales cuando tienen malos comportamientos?
							    </label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?Tienen/ten?an las vacunas al d?a?
							    </label>
							    <div class="col-sm-5">
							      <select name="vacuna" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							  </div>


							  <h2>Sobre la adopci?n</h2>
							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?Qu? mascota deseas adoptar?
							    </label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	En caso de ser arrendada?Cu?nto tiempo pasar? sola la mascota?
							    </label>
							    <div class="col-sm-5">
							      <input type="email" class="form-control" id="inputEmail3">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?Por qu? deseas adoptar?
							    </label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <div class="col-sm-2">
							    	?Estas dispuesto a cuidar del la mascota cuando esta envejezca?
								</div>
							    <div class="col-sm-2">
							      <select name="cuidar" id="tasking" class="form-control">
					                    <option value="" selected>Selecione</option>
					                    <option value="value1">SI</option>
					                    <option value="value1">NO</option>
					               </select>
							    </div>
							    <div class="col-sm-8">
							      <div class="form-check">
								    <label class="form-check-label">
								      ?Por qu?? <input class="col-sm-4 col-form-label" type="text"> 
								    </label>
							      </div>
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?D?nde dormir? la mascota?
							    </label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?Cuanto tiempo pasar? sola la mascota?
							    </label>
							    <div class="col-sm-5">
							      <input type="text" class="form-control" id="">
							    </div>
							  </div>

							  <div class="form-group row">
							    <label for="" class="col-sm-7 col-form-label">
							    	?Qui?n cubrir? los gastos de la mascota?
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