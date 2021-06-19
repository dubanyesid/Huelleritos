<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Lista Animales</title>

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
	<div class="wrapper">

		<!-- Sidebar -->
		<jsp:include page="menuAdmin.jsp" />
		<!-- End sidebar -->

		<!-- Dark overlay -->
		<div class="overlay"></div>

		<!-- Content -->
		<div class="content mt-5">

			<!-- open sidebar menu -->
			<a class="btn btn-primary btn-customized open-menu" href="#"
				role="button"> <i class="fas fa-align-left"></i> <span>Menu</span>
			</a>
			<div class="container">
				<div class="col-md-4 m-2">
					<h1>
						Lista de
						<%=request.getAttribute("tipo")%></h1>
				</div>
       <% 
			String mensaje=String.valueOf(request.getAttribute("mensaje"));
            if(request.getAttribute("mensaje")!=null) 
            { 
            	%>          
                <p style="text-align: center;color:green"><%=mensaje %></p>
        <%
            }
%><div class="col-md-5 m-2 input-group">
						
						<label >Buscar:</label>
						<input type="text" align="right" class="form-control pull-right" style="width:30%" id="search" placeholder="Buscar:">

					</div>
					<div class="col-xs-12 col-md-3">
				<div class="row justify-content-center justify-content-md-start">
					<table class="table table-bordered" id="mytable">
						<thead class="table-dark">
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Apellido</th>
								<th scope="col">Correo</th>
								<th scope="col">Celular</th>
								<th scope="col">Fecha</th>
								<th scope="col">Puntaje</th>
								<th colspan="2" scope="col">Usuario registrado</th>
								<th colspan="2" scope="col">ACCIONES</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="puntaje" items="${puntajes}">

								<tr>
									<td><c:out value="${puntaje.formulario.nombre}" /></td>
									<td><c:out value="${puntaje.formulario.apellido}" /></td>
									<td><c:out value="${puntaje.formulario.correo}" /></td>
									<td><c:out value="${puntaje.formulario.celular}" /></td>
									<td><c:out value="${puntaje.formulario.fecha}" /></td>
									<td><c:out value="${puntaje.puntaje}" /></td>
									<c:if test="${puntaje.formulario.usuarioBean !=null}">
										<td><svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor"
												class="bi bi-person-check-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
													d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
  <path
													d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
</svg></td>
									</c:if>
									<c:if test="${puntaje.formulario.usuarioBean ==null}">
										<td><svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-person-x-fill"
												viewBox="0 0 16 16">
  <path fill-rule="evenodd"
													d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6.146-2.854a.5.5 0 0 1 .708 0L14 6.293l1.146-1.147a.5.5 0 0 1 .708.708L14.707 7l1.147 1.146a.5.5 0 0 1-.708.708L14 7.707l-1.146 1.147a.5.5 0 0 1-.708-.708L13.293 7l-1.147-1.146a.5.5 0 0 1 0-.708z" />
</svg></td>
									</c:if>
									<td><a
										href="<%=request.getContextPath()%>/Solicitud?id=<c:out value="${puntaje.formulario.idFormulario}"/>&tipo=<%=request.getAttribute("tipo") %>"
										class="btn btn-dark">Respuestas</a></td>
									<td><a
										href="<%=request.getContextPath()%>/Solicitud?id=<c:out value="${puntaje.formulario.idFormulario}"/>&tipo=<%=request.getAttribute("tipo") %>"
										class="btn btn-dark">Eliminar</a></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
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

		</div>
		<!-- End content -->

	</div>
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
<script>
 // Write on keyup event of keyword input element
 $(document).ready(function(){
 $("#search").keyup(function(){
 _this = this;
 // Show only matching TR, hide rest of them
 $.each($("#mytable tbody tr"), function() {
 if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
 $(this).hide();
 else
 $(this).show();
 });
 });
});
</script>
</body>

</html>