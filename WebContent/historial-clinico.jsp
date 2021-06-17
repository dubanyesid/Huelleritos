<%@page import="co.edu.ufps.huelleritos.entities.EnfermedadHistorial"%>
<%@page import="co.edu.ufps.huelleritos.entities.OperacionesAnimal"%>
<%@page import="co.edu.ufps.huelleritos.entities.VacunaHistorial"%>
<%@page import="co.edu.ufps.huelleritos.entities.Vacuna"%>
<%@page import="co.edu.ufps.huelleritos.entities.HistorialAnimal"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.huelleritos.entities.Animal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>Historial Clinico</title>

<!-- CSS -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/jquery.mCustomScrollbar.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/estilos.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/media-queries.css">


<!-- Favicon and touch icons -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<div>
		<!--Navbar-->
		<nav class="navbar navbar-dark  bg-dark">
			<a class="form-inline my-2 my-lg-0 ml-auto"> Usuario </a>
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


		<h3>
			<img src="<%=request.getContextPath()%>/assets/img/Huelleritos.png">
		</h3>


		<ul class="list-unstyled menu-elements">
			<li><a href="<%=request.getContextPath()%>/admin/inicio">Inicio</a>
			</li>
			<li><a href="<%=request.getContextPath()%>/admin/animal/listar">Animales</a>
			</li>
			<li><a href="<%=request.getContextPath()%>/donaciones.jsp">Donaciones</a>
			</li>
			<li><a
				href="<%=request.getContextPath()%>/seguimiento-animal.jsp">Seguimiento</a>
			</li>
			<li><a href="<%=request.getContextPath()%>/Solicitudes/Adopcion">Solicitudes
					Adopcion</a></li>
			<li><a
				href="<%=request.getContextPath()%>/Solicitudes/HogarDePaso">Solicitudes
					Hogares de Paso</a></li>
			<li><a href="<%=request.getContextPath()%>/Noticias">Noticias
					y Eventos</a></li>
			<li><a href="<%=request.getContextPath()%>/NoticiasEvidencias">Noticias
					y Evidencias</a></li>
			<li><a href="<%=request.getContextPath()%>/logout">Cerrar
					sesion</a></li>
		</ul>

		<div class="dark-light-buttons">
			<a class="btn btn-primary btn-customized-4 btn-customized-dark"
				href="#" role="button">Dark</a> <a
				class="btn btn-primary btn-customized-4 btn-customized-light"
				href="#" role="button">Light</a>
		</div>

	</nav>
	<!-- End sidebar -->

	<!-- Dark overlay -->


	<!-- Content -->


	<!-- open sidebar menu -->
	<a class="btn btn-primary btn-customized open-menu" href="#"
		role="button"> <i class="fas fa-align-left"></i> <span>Menu</span>
	</a>
	<%
		HistorialAnimal historial = (HistorialAnimal) request.getAttribute("historial");
	%>
	<h1>
		<strong>HISTORIAL CLINICO #<%=historial.getIdHistorialAnimal()%></strong>
	</h1>
	<h3>
		<strong>CODIGO ANIMAL #<%=historial.getAnimal().getCodigoAnimal()%></strong>
	</h3>
	<div class="container">

		<h1 class="text-left" style="">
			<strong>VACUNACIÓN</strong>
		</h1>
		<br>
		<div class="row">
			<div class="col-md-12">
				<form method="post" action="#">
					<ul class="contact-form">
						<li>
							<div>
								<h6>NOMBRE</h6>
								<select id='vacunas' name="">
									<%
										if (historial != null) {
										List<VacunaHistorial> vacunas = historial.getVacunaHistorials();
										if (vacunas != null && vacunas.size() != 0) {
											for (VacunaHistorial vacuna : vacunas) {
									%>

									<option value="<%=vacuna.getIdVacunaHistorial()%>"><%=vacuna.getVacuna().getNombreVacuna()%></option>
									<%
										}
									} else {
									out.append("<option>No registra vacunas</option>");
									}

									}
									%>
								</select>

							</div>

							<div>
								<h6>DESCIPCION</h6>
								<input id="inputDescripcionVacuna" disabled name="descripcion"
									placeholder="Escribe Descripcion" required="required" size="8"
									type="text" />
							</div>
						</li>

						<li>
							<div>
								<h6>FECHA</h6>
								<input id="inputFechaVacuna" disabled name="date"
									placeholder="Escribe la Fecha" required="required" size="8"
									type="date" />
							</div>
						<li>

							<div class="col-md-12">
								<button id="btnDeleteVacuna" type="button">
									ELIMINAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>

						<li>
							<div class="col-md-12">
								<button type="button" id="btnEditVacuna">
									EDITAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
							<div class="col-md-12">
								<button type="button"
									onclick="location.href='addVacuna?animal=<%=historial.getAnimal().getCodigoAnimal()%>'">
									AGREGAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</div>
		<br> <br> <br>
		<h1 class="text-left" style="">
			<strong>OPERACIONES</strong>
		</h1>
		<br>
		<div class="row">
			<div class="col-md-12">
				<form method="post" action="#">
					<ul class="contact-form">
						<li>
							<div>
								<h6>NOMBRE</h6>
								<select id="operaciones">
									<%
										if (historial != null) {
										List<OperacionesAnimal> operaciones = historial.getOperacionesAnimals();
										if (operaciones != null && operaciones.size() != 0) {
											for (OperacionesAnimal operacion : operaciones) {
									%>

									<option value="<%=operacion.getIdOperacionesAnimal()%>"><%=operacion.getNombreOperacion()%></option>
									<%
										}
									} else {
									%><option>No registra operaciones</option>
									<%
										}
									}
									%>
								</select>
							</div>


						</li>

						<li>
							<div>
								<h6>FECHA DE OPERACION</h6>
								<input id="inputfo" name="date"
									placeholder="Escribe Fecha Operacion" disabled
									required="required" size="8" type="date" />
							</div>
							<div>
								<h6>FECHA DE RECUPERACION</h6>
								<input id="inputfr" name="date"
									placeholder="Escribe Fecha Recuperacion" disabled
									required="required" size="8" type="date" />
							</div>
							<div>
								<h6>OBSERVACIONES</h6>
								<textarea id="inputobservaciono" name="date"
									placeholder="Escribe Observaciones" disabled
									required="required" size="8" type="date"></textarea>
							</div>
						<li>
							<div class="col-md-12">
								<button id="btnDeleteOperacion" type="button">
									ELIMINAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>

						<li>
							<div class="col-md-12">
								<button id="btnEditOperacion" type="button">
									EDITAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
							<div class="col-md-12">
								<button type="button"
									onclick="location.href='addOperacion?animal=<%=historial.getAnimal().getCodigoAnimal()%>'">
									AGREGAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</div>
		<br> <br> <br>
		<h1 class="text-left" style="">
			<strong>ENFERMEDADES</strong>
		</h1>
		<br>
		<div class="row">
			<div class="col-md-12">
				<form method="post" action="#">
					<ul class="contact-form">
						<li>
							<div>
								<h6>NOMBRE</h6>
								<select id="enfermedades">
									<%
										if (historial != null) {
										List<EnfermedadHistorial> enfermedades = historial.getEnfermedadHistorials();
										if (enfermedades != null && enfermedades.size() != 0) {
											for (EnfermedadHistorial enfermedad : enfermedades) {
									%>

									<option value="<%=enfermedad.getIdEnfermedadHistorial()%>"><%=enfermedad.getEnfermedad().getNombreEnfermedad()%></option>
									<%
										}
									} else {
									%><option>No registra enfermedades</option>
									<%
										}

									}
									request.setAttribute("historial", null);
									%>
								</select>

							</div>


						</li>

						<li>
							<div>
								<h6>TRATAMIENTO</h6>
								<input id="inputTratamientoEnfermedad" disabled name="date"
									placeholder="Escribe El tratamiento" required="required"
									size="8" type="text" />
							</div>
							<div>
								<h6>FECHA DE INICIO</h6>
								<input id="inputFechaInicioEnfermedad" disabled name="date"
									placeholder="Escribe Fecha Inicio	" required="required"
									size="8" type="date" />
							</div>
							<div>
								<h6>FECHA DE RECUPERACION</h6>
								<input id="inputFechaFinEnfermedad" disabled name="date"
									placeholder="Escribe Fecha Recuperacion	" required="required"
									size="8" type="date" />
							</div>
						<li>
							<div class="col-md-12">
								<button id="btnDeleteEnfermedad" type="button">
									ELIMINAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>

						<li>
							<div class="col-md-12">
								<button type="button" id="btnEditEnfermedad">
									EDITAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
							<div class="col-md-12">
								<button type="button"
									onclick="location.href='addEnfermedad?animal=<%=historial.getAnimal().getCodigoAnimal()%>'">
									AGREGAR <span class="glyphicon glyphicon-arrow-right"
										aria-hidden="true"></span>
								</button>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</div>

	</div>

	<!-- Footer -->
	<footer class="footer-container">

		<div class="container">
			<div class="row">

				<div class="col">&copy; Huelleritos todos los derechos
					reservados.</div>

			</div>
		</div>

	</footer>


	<!-- End content -->


	<!-- End wrapper -->

	<!-- Javascript -->
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery-3.3.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery-migrate-3.0.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.backstretch.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/scripts.js"></script>
	<script type="text/javascript">
const traerVacuna = ()=>{
	const idVacuna=$("select[id=vacunas]").val();
	 $.get("historial/vacuna",{vacuna:idVacuna},(e)=>{
	$("#inputDescripcionVacuna").val(e.descripcion);
	
	$("#inputFechaVacuna").val(e.fecha);
	$("#btnDeleteVacuna").off("click")
 	$("#btnDeleteVacuna").on("click",()=>{
 		
 		location.href="deleteVacuna?vacuna="+idVacuna;
 	});
	$("#btnEditVacuna").off("click")
	$("#btnEditVacuna").on("click",()=>{
 		
 		location.href="editVacuna?vacuna="+idVacuna;
 	})
	 });
	
}
const traerEnfermedad= ()=>{
	const idEnfermedad = $("select[id=enfermedades]").val();
	console.log(idEnfermedad)
	 $.get("historial/enfermedad",{enfermedad:idEnfermedad},(e)=>{					
				 $("#inputTratamientoEnfermedad").val(e.tratamiento)
				 $("#inputFechaInicioEnfermedad").val(e.fechaInicio.substring(0,10))
				 $("#inputFechaFinEnfermedad").val(e.fechaFin.substring(0,10))
				 
				  $("#btnDeleteEnfermedad").off("click")
	 	$("#btnDeleteEnfermedad").on("click",()=>{
	 		
	 		location.href="deleteEnfermedad?enfermedad="+idEnfermedad;
	 	});
				 $("#btnEditEnfermedad").off("off");
					$("#btnEditEnfermedad").on("click",()=>{
						console.log("asdasd")
				 		location.href="editEnfermedad?enfermedad="+idEnfermedad;
				 	})
				 
			 });
	 
	 
	
		
	 
	 
}

const traerOperacion=()=>{
	const idOperacion=$("select[id=operaciones]").val();
	 $.get("historial/operacion",{operacion:idOperacion},(e)=>{
		 
		 	$("#inputobservaciono").val(e.observacion)
		 	$("#inputfo").val(e.fechaOperacion)
		 	$("#inputfr").val(e.fechaRecuperacion)
		 	$("#btnEditOperacion").off("click")
		 	$("#btnEditOperacion").on("click",()=>{
		 		
		 		location.href="editOperacion?operacion="+idOperacion;
		 	})
		 	$("#btnDeleteOperacion").off("click")
		 	$("#btnDeleteOperacion").on("click",()=>{
		 		
		 		location.href="deleteOperacion?operacion="+idOperacion;
		 	})
			 });
	
}

$(()=>{
	traerVacuna();
	traerEnfermedad();
	traerOperacion();
});

$("#operaciones").on("change",(e)=>{
	traerOperacion();
	
})
$("#vacunas").on("change",(e)=>{
	traerVacuna();
	
})
$("#enfermedades").on("change",(e)=>{
	traerEnfermedad();
})
</script>
</body>

</html>