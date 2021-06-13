<%@page import="co.edu.ufps.huelleritos.entities.Animal"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Huelleritos</title>
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
								<a href="index.html"> <img src="img/Huelleritos.png" alt="">
								</a>
							</div>
						</div>
						<div class="col-xl-10 col-lg-10">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a href="index.html">Inicio</a></li>
										<li><a href="html/Huelleritos.html">Huelleritos</a></li>
										<li><a href="html/Adopta.html">Adopta</a></li>
										<li><a href="html/Apadrinar.html">Apadrina</a></li>
										<li><a href="html/Hogar_Paso.html">Hogar de paso</a></li>
										<li><a href="html/La_Fundacion.html">La fundación</a></li>
										<li><a href="html/Noticias.html">Noticias</a></li>
										<a href="html/Dona_aqui.html"
											class="genric-btn primary circle">Dona Aqui</a>
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
								<span>Huelleritos</span> <br> Cúcuta
							</h3>
							<p>¡Ayudanos a ayudar! Comprometidos con el cuidado animal.</p>
							<a href="html/Contacto.html" class="boxed-btn4">Contactanos</a>
						</div>
					</div>
				</div>
			</div>
			<div class="dog_thumb d-none d-lg-block">
				<img src="img/banner/dog.png" alt="">
			</div>
		</div>
	</div>
	<!-- slider_area_end -->
<%!private String itemCaruselAnimalHtml(Animal a) {
		String html = "";
		if (a != null) {
			html = "<div class='col-sm-4'>";
			html += "  <div class='card centro'>";
			html += " <img class='card-img-top' src='"+a.getImagenAnimal()+"' alt='Card image cap'>";
			html += " <div class='card-body'>";
			html += " <h5 class='card-title'>Edad : " + a.getEdad() + " años</h5>";
			html += " <h4>" + a.getNombreAnimal() + "</h4>";
			html += " <p class='card-text'>" + a.getDescripcion() + "</p>";
			html += " <a href='PerfilHuellerito?codigo="+a.getCodigoAnimal()+"' class='genric-btn primary circle'>Conoce Mas</a>";
			html += "</div></div></div>";
		}

		return html;
	}
	
private String caruselAnimalHtml(List<Animal>animales){
	String items = "";
	if (animales != null && animales.size() > 0) {
		
		for (Integer i = 0; i < animales.size(); i += 3) {
			String activo = i == 0 ? "active" : "";
			items += "<div class='carousel-item " + activo + "'><div class='row'>";
			for (Integer j = i; j < i + 3; j++) {
		Animal uno = j<animales.size()? animales.get(j):null;

		items += itemCaruselAnimalHtml(uno);

			}
			items += "</div></div>";
			
		}

	}
	return items.equals("") ? "<h1 class='text-center pb-5'>Sin registros</h1>":items;
}
	
	%>
<br>
	<br>
	<br>
	
	<h1 class="centro">
		Huelleritos prioritarios
		<hr>
	</h1>
<br>
<div class="container">
		<div id="carouselPrio" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				
				<%
				List<Animal> animales = (List<Animal>) request.getAttribute("animalesPrioridad");
				out.append(caruselAnimalHtml(animales));
				
				%>
				
			</div>

			<a class="carousel-control-prev" href="#carouselPrio"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<!-- Huelleritos en Adopcion -->
	<br>
	<br>
	<br>
	<h1 class="centro">
		Huelleritos en adopcion
		<hr>
	</h1>
	<br>

	<div class="container">
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				
				<%
				List<Animal> animalesAdopcion = (List<Animal>) request.getAttribute("animalesAdopcion");
				out.append(caruselAnimalHtml(animalesAdopcion));
				%>
				<!-- 
                <div class="carousel-item active">                   

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.sommelierdecafe.com/2019/wp-content/uploads/2019/03/Perro-de-frente-800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/04/03/04-australian-shepherd_af05aa09_800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/06/18/_3a525832_800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                
-->
			</div>

			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<br>
	<!-- Huelleritos en Adopcion / final -->

<!-- Huelleritos Adoptados -->
	<br>
	<br>
	<br>
	<h1 class="centro">
		Huelleritos felizmente Adoptados
		<hr>
	</h1>
	<br>

	<div class="container">
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				
				<%
				List<Animal> animalesAdoptados = (List<Animal>) request.getAttribute("animalesAdoptados");
				out.append(caruselAnimalHtml(animalesAdoptados));
				%>
				
				
				<!-- 
                <div class="carousel-item active">                   

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.sommelierdecafe.com/2019/wp-content/uploads/2019/03/Perro-de-frente-800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/04/03/04-australian-shepherd_af05aa09_800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="card centro">
                                <img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/06/18/_3a525832_800x800.jpg" alt="Card image cap">
                                <div class="card-body">
                                    <h5 class="card-title">Edad del animal</h5>
                                    <h4>Nombre del animal</h4>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" class="genric-btn primary circle">Conoce Mas</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                
-->
			</div>

			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<br>
	<!-- Huelleritos Adoptados / final -->
	<!-- Noticias -->
	<h1 class="centro">
		Noticias
		<hr>
	</h1>
	<br>

	<div class="container">
		<div id="carouselExampleControl" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">

				<div class="carousel-item active">

					<div class="row">
						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="carousel-item">

					<div class="row">
						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="carousel-item">

					<div class="row">
						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="card centro">
								<img class="card-img-top"
									src="https://thumbs.dreamstime.com/b/breaking-news-live-abstract-red-blue-banner-white-text-dark-background-technology-business-tv-vector-illustration-105537370.jpg"
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Titulo de la Noticia</h5>
								</div>
							</div>
						</div>
					</div>
				</div>

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
	<!-- Instagram -->
	<h1 class="centro">
		Nuestro Instagram
		<hr>
	</h1>
	<br>
	<div class="container">
		<div>
			<script src="https://apps.elfsight.com/p/platform.js" defer></script>
			<div class="elfsight-app-c41bab9c-88c6-4408-a5a6-62b7283c0e80"></div>
		</div>
	</div>
	<!-- Noticias / Final -->


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
							<a href="html/Contacto.html" class="boxed-btn4">Contactanos</a>
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
	</ body>
</html>