<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.huelleritos.entities.Noticia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Noticias</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/img/favicon.png">

    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/magnific-popup.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/themify-icons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/nice-select.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/gijgo.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/slicknav.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cssdenosotros.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/huelleritos.css">


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
								<a href="index.jsp"> <img src="img/Huelleritos.png"
									alt="">
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
								<span>Noticias y Eventos</span>
							</h3>
							<p>Enterate de las nuevas noticias y eventos de nuestra
								fundacion.</p>

						</div>
					</div>
				</div>
			</div>
			<div class="dog_thumb d-none d-lg-block">
				<img src="img/banner/dog7.png" alt="">
			</div>
		</div>
	</div>
	<!-- slider_area_end -->
	<%!private String itemCaruselNoticiaHtml(Noticia n) {
		String html = "";
		if (n != null) {
			html += "<div class='col-sm-4'>";
			html += "<div class='card centro'>";
			html += "<img class='card-img-top' src='"+n.getImagen()+"' alt='Card image cap'>";
			html += "<div class='card-body'>";
			html += "<h5 class='card-title'>" + n.getTitulo() + "</h5>";
			html += "<p>" + n.getDescripcion() + "</p>";
			html += "</div></div></div>";

		}

		return html;
	}

	private String caruselNoticiaHtml(List<Noticia> noticias) {
		String items = "";
		if (noticias != null && noticias.size() > 0) {

			for (Integer i = 0; i < noticias.size(); i += 3) {
				String activo = i == 0 ? "active" : "";
				items += "<div class='carousel-item " + activo + "'><div class='row'>";
				for (Integer j = i; j < i + 3; j++) {
					Noticia uno = j < noticias.size() ? noticias.get(j) : null;

					items += itemCaruselNoticiaHtml(uno);

				}
				items += "</div></div>";

			}

		}
		return items;
	}%>
	<!-- Cuerpo Noticias aqui -->
	<br>
	<br>
	<br>

	<div class="container">
		<h1 class="centro">
			<%String titulo =  String.valueOf(request.getAttribute("titulo"));
			
			out.append(titulo);
			%>
			<hr>
		</h1>
		<div id="carouselExampleControl" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">

				<%
				List<Noticia> noticias = (List<Noticia>) request.getAttribute("noticias");
				String noticiasHtml=caruselNoticiaHtml(noticias);
				
				out.append(noticiasHtml.equals("")? "<h1 class='text-center'>No existen noticias registradas</h1>":noticiasHtml);
				%>

			</div>

			<a class="carousel-control-prev" href="#carouselExampleControl"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControl"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<br>
	<br>
	<!-- Cuerpo Noticias / Final -->

	<div class="contact_anipat anipat_bg_1">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="contact_text text-center">
						<div class="section_title text-center">
							<h3>¿Por Que ir con Huelleritos?</h3>
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
	 <script src="<%=request.getContextPath()%>/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/ajax-form.js"></script>
    <script src="<%=request.getContextPath()%>/js/waypoints.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.counterup.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/imagesloaded.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/scrollIt.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.scrollUp.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/wow.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/nice-select.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.slicknav.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.magnific-popup.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins.js"></script>
    <script src="<%=request.getContextPath()%>/js/gijgo.min.js"></script>
    <!--contact js-->
    <script src="<%=request.getContextPath()%>/js/contact.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.ajaxchimp.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/mail-script.js"></script>
    <script src="<%=request.getContextPath()%>/js/javascript.js"></script>


    <script src="<%=request.getContextPath()%>/js/main.js"></script>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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