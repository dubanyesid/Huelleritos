<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

		<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Datos Animal</title>

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
						DATOS DEL ANIMAL
					</h1>
				</div>
						<form>
		        <div class="form-row">
		            <div class="form-group col-md-4">
		                <label for="nombre">Nombre</label>
		                <input type="text" name="nombre" class="form-control">
		            </div>
		            <div class="form-group col-md-4">            
		                <label for="tipo-animal">Tipo Animal</label>
		                <input type="text" name="tipo-animal" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="fecha">Fecha de ingreso</label>
		                <input type="date" name="fecha" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="sexo">Sexo</label>
		                <select name="sexo" id="tasking" class="form-control">
		                    <option value="" selected>Selecione</option>
		                    <option value="value1">Masculino</option>
		                    <option value="value1">Femenino</option>
		                </select>
		            </div>
		            <div class="form-group col-md-4">
		                <label for="raza">Raza</label>
		                <input type="text" name="raza" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="edad">Edad</label>
		                <input type="number" name="edad" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="peso">Peso</label>
		                <input type="number" name="peso" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="color">Color</label>
		                <input type="text" name="color" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="estado">Estado</label>
		                <input type="text" name="estado" class="form-control">
		            </div>
		            <div class="form-group col-md-4">
		                <label for="descripcion">Descripci?n</label>
		                <textarea class="form-control" id="descripcion" rows="3"></textarea>
		            </div>
		            <div class="form-group col-md-4">
		            	<label for="imagen">Imagen</label>
		            	<button type="button" class="btn btn-dark form-control">Subir imagen</button>
		            </div>
		        </div> <!-- cierre de form-row -->
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