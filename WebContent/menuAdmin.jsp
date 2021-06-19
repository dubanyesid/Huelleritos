
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
		<li><a href="<%=request.getContextPath()%>/Solicitudes/Adopcion">Solicitudes
				Adopcion</a></li>
		<li><a
			href="<%=request.getContextPath()%>/Solicitudes/HogarDePaso">Solicitudes
				Hogares de Paso</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/Noticia">Noticias
				y Eventos</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/Noticia">Noticias
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
