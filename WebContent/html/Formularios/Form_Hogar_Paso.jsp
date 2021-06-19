<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="co.edu.ufps.huelleritos.entities.*"%>
<%@page import="co.edu.ufps.huelleritos.dao.*"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Formulario Hogar de Paso</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/themify-icons.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/gijgo.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/slicknav.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cssdenosotros.css">
<link rel="stylesheet" href="css/huelleritos.css">

<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<header>
		<div class="header-area ">
			<div class="header-top_area">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-8">
							<div class="short_contact_list">
								<ul>
									<li><a href="#">+57 3177636650 - +57 3135707240</a></li>

								</ul>
							</div>
						</div>
						<div class="col-lg-6 col-md-4 ">
							<div class="social_media_links">
								<a href="https://www.facebook.com/huelleritoscucuta"> <i
									class="fa fa-facebook"></i>
								</a> <a href="https://www.instagram.com/huelleritoscucuta/"> <i
									class="fa fa-instagram"></i>
								</a> <a href="https://www.instagram.com/huelleritoscucuta/"> <i
									class="fa fa-twitter"></i>
								</a>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="sticky-header" class="main-header-area">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-xl-2 col-lg-2">
							<div class="logo">
								<a href="index.html"> <img
									src="img/Huelleritos.png" alt="">
								</a>
							</div>
						</div>
						<div class="col-xl-10 col-lg-10">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
                                       <li><a  href="<%=request.getContextPath()%>/index">Inicio</a></li>
                                        <li><a href="<%=request.getContextPath()%>/index/Huelleritos">Huelleritos</a></li>
                                        <li><a href="<%=request.getContextPath()%>/index/Adopta">Adopta</a></li>
                                        
                                        <li><a href="<%=request.getContextPath()%>/index/HogarDePaso">Hogar de paso</a></li>                            
                                        <li><a href="<%=request.getContextPath()%>/index/Fundacion">La fundación</a></li>
                                        <li><a href="<%=request.getContextPath()%>/Noticias">Noticias</a></li>
                                        <a href="<%=request.getContextPath()%>/html/Dona_aqui.jsp" class="genric-btn primary circle">Dona Aqui</a>
                                       <a href="<%=request.getContextPath()%>/Usuario/Login" class="genric-btn primary circle">Ingresar</a>
                                    </ul>
								</nav>
							</div>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- slider_area_start -->
	<div class="slider_area">
		<div class="single_slider slider_bg_1 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-lg-5 col-md-6">
						<div class="slider_text">
							<h3>
								<span>Formulario</span> <br>Hogar De Paso
							</h3>
							<p>¡Ayudanos a ayudar! Comprometidos con el cuidado animal.</p>

						</div>
					</div>
				</div>
			</div>
			<div class="dog_thumb d-none d-lg-block">
				<img src="img/banner/dog5.png" alt="">
			</div>
		</div>
	</div>
	<!-- slider_area_end -->

	<!-- Cuerpo formulario Hogar de Paso aqui -->
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h2 class="centro">
					DILIGENCIAR FORMULARIO
					<hr class="potaxio">
				</h2>
				<form method="post" action="<%=request.getContextPath()%>/HogarDePaso/Enviar">
					<h3 class="titulos">Datos personales:</h3>

					<div class="form-group">
                            <label for="formGroupExampleInput2">Nombre</label>
                            <input name="nombre" type="text" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su Nombre">
                        </div>

                        <div class="form-group">
                            <label for="formGroupExampleInput">Apellido</label>
                            <input name="apellido" type="text" required class="form-control" id="formGroupExampleInput" placeholder="Ingrese su Apellido">
                        </div>

                        <div class="form-group">
                            <label for="formGroupExampleInput2">Ocupacion</label>
                            <input name="ocupacion" type="text" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su Ocupacion">
                        </div> 

                        <div class="form-group">
                            <label for="formGroupExampleInput2">Direccion de Residencia</label>
                            <input name="direccion" type="text" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su direccion">
                        </div>

                        <div class="form-group">
                            <label for="formGroupExampleInput2">Email</label>
                            <input name="correo" type="email" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su correo electrónico">
                        </div>

                        <div class="form-group">
                            <label for="formGroupExampleInput2">Teléfono</label>
                            <input name="telefono" type="number" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su Telefono">
                        </div>

                        <div class="form-group">
                            <label for="formGroupExampleInput2">Celular</label>
                            <input name="celular" type="number" required class="form-control" id="formGroupExampleInput2" placeholder="Ingrese su Celular">
                        </div>                       

                        <div class="form-group">
                            <label for="formGroupExampleInput">Cédula</label>
                            <input name="cedula"  type="number" required class="form-control" id="formGroupExampleInput" placeholder="Ingrese su cédula">
                        </div> 

					<!-- Datos familiares y de Vivienda-->
					<br>

					<h3 class="titulos">Datos familiares y de Vivienda:</h3>

					<%
						List<Pregunta> preguntas = (ArrayList<Pregunta>) new PreguntaDAO().listarFormHogarPaso();
					Pregunta[] p = (Pregunta[]) preguntas.toArray(new Pregunta[preguntas.size()]);
					List<Animal> animales = (ArrayList<Animal>) new AnimalDAO().list();
					for (int i = 0; i < 6; i++) {
					%>
					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[i].getTexto()%></label>

						<div class="default-select" id="default-select">
							<select name="preguntas">
								<%
									for (Opcion o : p[i].getOpcions()) {
								%>
								<option
									value="<%=p[i].getIdPregunta() + "-" + o.getIdOpcion()%>"><%=o.getTexto()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<%
						}
					%>

					<!-- Sobre Mascotas del hogar -->

					<br> <br>

					<h3 class="titulos">Sobre Mascotas del hogar</h3>

					<%
						for (int i = 6; i < 14; i++) {
						if (i == 7 || i == 9) {
					%>
					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[i].getTexto()%></label> <br>

						
							<%
								for (Opcion o : p[i].getOpcions()) {
							%>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="radio<%=p[i].getIdPregunta()%>"
									id="radio-<%=o.getIdOpcion()%>"
									value="<%=p[i].getIdPregunta() + "-" + o.getIdOpcion()%>">
								<label class="form-check-label"
									for="radio-<%=o.getIdOpcion()%>"><%=o.getTexto()%></label>
							</div>
							
							<br>
							<%
								}
							%>

						<br>
					</div>
					<%
						} else {
					%>
					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[i].getTexto()%></label>
						<div class="default-select" id="default-select">
							<select name="preguntas">
								<%
									for (Opcion o : p[i].getOpcions()) {
								%>
								<option
									value="<%=p[i].getIdPregunta() + "-" + o.getIdOpcion()%>"><%=o.getTexto()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<%
						}
					%>
					<%
						}
					%>

					<br> <br>

					<!-- Sobre el Hogar de paso -->

					<h3 class="titulos">Sobre el Hogar de paso</h3>

					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[14].getTexto()%></label>
						<br>

						<div class="default-select" id="default-select">
							<select name="animal">
								<!-- <input type="text" required class="form-control" name="animal"  placeholder="Ingrese el nombre del peludito"> -->
								<%
									
								%>
								<%
									for (Animal a : animales) {
								%>
								<option value="<%=a.getCodigoAnimal()%>"><%=a.getNombreAnimal()%></option>
								<%
									}
								%>
								<%
									
								%>
							</select> <br>
						</div>
					</div>

					<%
						for (int i = 15; i < 21; i++) {
						if (i == 7 || i == 20) {
					%>
					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[i].getTexto()%></label> <br>
						<div class="container">
							<%
								for (Opcion o : p[i].getOpcions()) {
							%>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio"
									name="radio<%=p[i].getIdPregunta()%>"
									id="radio-<%=o.getIdOpcion()%>"
									value="<%=p[i].getIdPregunta() + "-" + o.getIdOpcion()%>">
								<label class="form-check-label"
									for="radio-<%=o.getIdOpcion()%>"><%=o.getTexto()%></label>
							</div>
							<br>
							<%
								}
							%>
							<br>

						</div>
					</div>
					<%
						} else {
					%>
					<div class="single-element-widget mt-30">
						<label for="formGroupExampleInput2"><%=p[i].getTexto()%></label>
						<div class="default-select" id="default-select">
							<select name="preguntas">
								<%
									for (Opcion o : p[i].getOpcions()) {
								%>
								<option
									value="<%=p[i].getIdPregunta() + "-" + o.getIdOpcion()%>"><%=o.getTexto()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<%
						}
					%>
					<%
						}
					%>

					<br> <br>
					<button class="btn btn-dark" type="submit">Enviar</button>
				</form>
				<br>
			</div>

			<div class="col-sm-6 centro">
				<h2>
					CONTACTO
					<hr class="potaxio">
				</h2>
				<div class="row centro">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<img src="img/logocontacto.png" width="70" height="70"
							alt="">
					</div>
					<div class="col-sm-2">
						<p>3177636650</p>
						<p>3135707240</p>
					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>

	</div>
	<!-- Cuerpo formulario Hogar de Paso / Final -->

	<div class="contact_anipat anipat_bg_1">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="contact_text text-center">
						<div class="section_title text-center">
							<h3>Por Que ir con Huelleritos</h3>
							<p>Dale una segunda oportunidad a esos peluditos que no
								tienen hogar</p>
						</div>
						<div
							class="contact_btn d-flex align-items-center justify-content-center">
							<a href="<%=request.getContextPath()%>/Contacto" class="boxed-btn4">Contactanos</a>
							<p>
								Or <a href="#">+57 3177636650</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer_Inicio  -->
	<footer class="footer">
		<div class="footer_top">
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">Contacto</h3>
							<ul class="address_line">
								<li>+57 3177636650</li>
								<li>+57 3135707240</li>
								<li><a href="#">Huelleritos@gmail.com</a></li>
								<li>Cucuta, Norte de Santander, Colombia</li>
							</ul>
						</div>
					</div>
					<div class="col-xl-3  col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">Servicios</h3>
							<ul class="links">
								<li><a href="#">Adopta</a></li>
								<li><a href="#">Apadrina</a></li>
								<li><a href="#">Hogar de Paso</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-3  col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">Enlaces</h3>
							<ul class="links">
								<li><a href="#">About Us</a></li>
								<li><a href="#">Privacy Policy</a></li>
								<li><a href="#">Terms of Service</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-3 col-md-6 col-lg-3 ">
						<div class="footer_widget">
							<div class="footer_logo">
								<a href="#"> <img src="img/Huelleritos.png" alt="">
								</a>
							</div>
							<p class="address_text"></p>
							<div class="socail_links">
								<ul>
									<li><a href="https://www.facebook.com/huelleritoscucuta">
											<i class="ti-facebook"></i>
									</a></li>
									<li><a href="https://www.instagram.com/huelleritoscucuta/">
											<i class="ti-instagram"></i>
									</a></li>
									<li><a href="https://www.instagram.com/huelleritoscucuta/">
											<i class="fa fa-twitter"></i>
									</a></li>

								</ul>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copy-right_text">

			<div class="container">
				<div class="bordered_1px"></div>
				<div class="row">
					<div class="col-xl-12">
						<p class="copy_right text-center">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | Huelleritos Cucuta <i class="ti-heart"
								aria-hidden="true"></i> 2021
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- footer_Final  -->


	<!-- JS here -->
	<script src="js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<script src="js/scrollIt.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/nice-select.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/gijgo.min.js"></script>
	<!--contact js-->
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>


	<script src="js/main.js"></script>
	<script>
		$('#datepicker').datepicker({
			iconsLibrary : 'fontawesome',
			disableDaysOfWeek : [ 0, 0 ],
		//     icons: {
		//      rightIcon: '<span class="fa fa-caret-down"></span>'
		//  }
		});
		$('#datepicker2').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}
		});
		var timepicker = $('#timepicker').timepicker({
			format : 'HH.MM'
		});
	</script>
</body>

</html>