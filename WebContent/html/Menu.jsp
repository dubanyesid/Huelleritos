<nav>
	<ul id="navigation">
		<li><a href="<%=request.getContextPath()%>/index.jsp">Inicio</a></li>
		<li><a href="<%=request.getContextPath()%>/index/Huelleritos">Huelleritos</a></li>
		<li><a href="<%=request.getContextPath()%>/index/Adopta">Adopta</a></li>

		<li><a href="<%=request.getContextPath()%>/index/HogarDePaso">Hogar
				de paso</a></li>
		<li><a href="<%=request.getContextPath()%>/index/Fundacion">La
				fundación</a></li>
		<li><a href="<%=request.getContextPath()%>/Noticias">Noticias</a></li>
		<li><a href="<%=request.getContextPath()%>/NoticiasEvidencias">Noticias
				Evidencias</a></li>
		<a href="<%=request.getContextPath()%>/html/Dona_aqui.jsp"
			class="genric-btn primary circle">Dona Aqui</a>

		<%
			if (request.getSession().getAttribute("usuario") != null) {
		%>
		<a href="<%=request.getContextPath()%>/logout"
			class="genric-btn primary circle">Cerrar sesion</a>
		<%
			} else {
		%>
		<a href="<%=request.getContextPath()%>/Usuario/Login"
			class="genric-btn primary circle">Ingresar</a>
		<%
			}
		%>
	</ul>
</nav>
