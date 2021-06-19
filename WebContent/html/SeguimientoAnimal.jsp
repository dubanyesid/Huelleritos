<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="co.edu.ufps.huelleritos.entities.*"%>
<%@ page import="co.edu.ufps.huelleritos.dao.*"%>
<%@ page import="java.util.List"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Formulario Adopta</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/img/logocontacto.png">

<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/magnific-popup.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/nice-select.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/gijgo.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/slicknav.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/cssdenosotros.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/huelleritos.css">

<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/responsive.css"> -->
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
                                <a href="<%=request.getContextPath()%>/index.jsp">
                                    <img src="<%=request.getContextPath()%>/img/Huelleritos.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10">
                            <div class="main-menu  d-none d-lg-block">
                               <jsp:include page="Menu.jsp" />
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
								<span>Seguimiento</span> <br>Animal
							</h3>
							<p>�Ayudanos a ayudar! Comprometidos con el cuidado animal.</p>

						</div>
					</div>
				</div>
			</div>
			<div class="dog_thumb d-none d-lg-block">
				<img src="<%=request.getContextPath()%>/img/banner/dog2.png" alt="">
			</div>
		</div>
	</div>
	<!-- slider_area_end -->

	<!-- Cuerpo formulario Adoptar aqui -->
	<br>
	<br>
	<br>

	<div class="container">
		<div>
			<h1>Seguimiento Animal</h1>
		</div>
		<form method="post" action="<%=request.getContextPath()%>/Seguimiento/Enviar">
			<div class="col-sm-6">
				<h2 class="centro">
					DILIGENCIAR SEGUIMIENTO
					<hr class="potaxio">
				</h2>

				<h3 class="titulos">Datos personales:</h3>

				<input type="hidden" name="idAnimal" value="<%=request.getParameter("idAnimalSeg")%>">
				<input type="hidden" name="nombreAnimal" value="<%=request.getParameter("nombreAnimal")%>">
				<div class="form-group">
					<label for="formGroupExampleInput2">Nombre</label> <input
						name="nombre" type="text" required class="form-control"
						id="formGroupExampleInput2" placeholder="<%=request.getParameter("nombreAnimal")%>" disabled>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput2">Observaci�n</label>
					<textarea name="ocupacion" required class="form-control"
						id="formGroupExampleInput2" placeholder=""></textarea>
				</div>

			</div>
			<div class="form-group row">
				<div class="container mt-5">
					<h3 class="text-center">Subir evidencia</h3>
					<div class="col-sm-12 col-lg-4 mr-auto ml-auto border p-4">

						<div class="form-group">
							<label><strong>Subir</strong></label>
							<div class="custom-file">
								<input name='archivo' id="in-url" hidden="true" value=""
									required="required"> <input placeholder="asdasd"
									type="file" name="files[]" multiple
									class="custom-file-input form-control" id="img-uploader">
								<label class="custom-file-label" for="" id="lblArchivo">Elegir
									archivo</label>
							</div>
						</div>
						<progress id="img-upload-bar" value="0" max="100"
							style="width: 100%"></progress>

						<div class="form-group">
							<button type="button" name="upload" value="upload" id="upload"
								class="btn btn-block btn-dark">
								<i class="fa fa-fw fa-upload"></i> Subir
							</button>
						</div>
						<div class="form-group">
							<input type="submit" value="Guardar" class="btn btn-dark">
						</div>
					</div>

				</div>
			</div>

		</form>

	</div>


	<!-- Cuerpo formulario Adoptar / Final -->

	<div class="contact_anipat anipat_bg_1">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="contact_text text-center">
						<div class="section_title text-center">
							<h3>�Por Que ir con Huelleritos?</h3>
							<p>Dale una segunda oportunidad a esos peluditos que no
								tienen hogar</p>
						</div>
						<div
							class="contact_btn d-flex align-items-center justify-content-center">
							<a href="<%=request.getContextPath()%>/Contacto"
								class="boxed-btn4">Contactanos</a>
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
								<a href="#"> <img
									src="<%=request.getContextPath()%>/img/Huelleritos.png" alt="">
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

<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js"></script>
	<!-- JS here -->
	<script
		src="<%=request.getContextPath()%>/js/vendor/modernizr-3.5.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/vendor/jquery-1.12.4.min.js"></script>
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
	<script
		src="<%=request.getContextPath()%>/js/jquery.magnific-popup.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/plugins.js"></script>
	<script src="<%=request.getContextPath()%>/js/gijgo.min.js"></script>
	<!--contact js-->
	<script src="<%=request.getContextPath()%>/js/contact.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.ajaxchimp.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/mail-script.js"></script>
	<script src="<%=request.getContextPath()%>/js/cargarImagen.js "></script>

	<script src="<%=request.getContextPath()%>/js/main.js"></script>
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
