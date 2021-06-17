<%@page import="co.edu.ufps.huelleritos.entities.EnfermedadHistorial"%>
<%@page import="co.edu.ufps.huelleritos.entities.VacunaHistorial"%>
<%@page import="co.edu.ufps.huelleritos.entities.Vacuna"%>
<%@page import="co.edu.ufps.huelleritos.entities.HistorialAnimal"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.ufps.huelleritos.entities.Animal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Perfil Animal Adulto</title>
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
                                <a href="https://www.facebook.com/huelleritoscucuta">
                                    <i class="fa fa-facebook"></i>
                                </a>
                                <a href="https://www.instagram.com/huelleritoscucuta/">
                                    <i class="fa fa-instagram"></i>
                                </a>
                                <a href="https://www.instagram.com/huelleritoscucuta/">
                                    <i class="fa fa-twitter"></i>
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
                                <a href="<%=request.getContextPath()%>/index">
                                    <img src="<%=request.getContextPath()%>/img/Huelleritos.png" alt="">
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
                                        <li><a href="<%=request.getContextPath()%>/index/Apadrina">Apadrina</a></li>
                                        <li><a href="<%=request.getContextPath()%>/index/HogarDePaso">Hogar de paso</a></li>                            
                                        <li><a href="<%=request.getContextPath()%>/index/Fundacion">La fundación</a></li>
                                        <li><a href="<%=request.getContextPath()%>/Noticias">Noticias</a></li>
                                        <a href="<%=request.getContextPath()%>/html/Dona_aqui.jsp" class="genric-btn primary circle">Dona Aqui</a>
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

   

    <!-- Cuerpo formulario Adoptar aqui -->
    <br><br><br>
<%
Animal a = (Animal)request.getAttribute("perfilAnimal");

%>
    <div class="row">
        <div class="col-sm-1"></div>

        <div class="col-sm-4">
            <div class="container-fluid px-sm-1 py-5 mx-auto">
                <div class="row justify-content-center">
                    <div class="d-flex">
                        <div class="card">
                            <div class="d-flex flex-column thumbnails">
                                <!-- imagen pequeÃ±a1 -->
                                <div id="f1" class="tb tb-active">
                                    <img class="thumbnail-img fit-image" src="<%=a.getImagenAnimal()%>"> 
                                </div>
                               
                            </div>
                            <!-- imagen Grande1 -->
                            <fieldset id="f11" class="active">
                                <div class="product-pic"> 
                                    <img class="pic0" src="<%=a.getImagenAnimal()%>">
                                </div>
                            </fieldset>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-sm-4"><br>
            <h2><%=a.getNombreAnimal() %></h2>
            <p>Sexo: <%=a.getSexo() %></p>
            <p><%=a.getDescripcion() %></p>
            <a href="<%=request.getContextPath()%>/Adoptar" target="blank"><button type="button" class="btn btn-dark btn-lg">Adopta</button></a><br><br>
            <a href="<%=request.getContextPath()%>/HogarDePaso" target="blank"><button type="button" class="btn btn-dark btn-lg ">Hogar de Paso</button></a><br><br>
        </div>
        <div class="col-sm-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-6">
            <div class="container">
                <a href="#demo" data-toggle="collapse"><button type="button" class="btn btn-outline-secondary btn-lg btn-block">Informacion Adicional â</button></a>
                <div id="demo" class="collapse">
                    <p style="margin-top: 10px;font-size: 28px"><b>Vacunas:</b> </p>
                    <ol>
                    <%
                    List<HistorialAnimal> historiaAnimal= a.getHistorialAnimals();
                    List<VacunaHistorial>vacunas =historiaAnimal.get(0).getVacunaHistorials();
                 	
                    if(vacunas!=null ){
                    	 for(int i =0 ; i<vacunas.size();i++){%>
                    	 <li><p style="font-size: 24px"><b><%=i+1 %>.</b> <%=vacunas.get(i).getVacuna().getNombreVacuna() %> - <b>Fecha</b> : <%=vacunas.get(i).getFechaVacunacion() %></p></li>
                    	 <%
                    }
                    }
                   
                   
                    %>
                    </ol>


  <p style="margin-top: 10px;font-size: 28px"><b>Enfermedades:</b> </p>
                    <ol>
                    <%                  
                 List<EnfermedadHistorial>enfermedades = historiaAnimal.get(0).getEnfermedadHistorials();
                    
                    if(enfermedades!=null){
                    	for(int i =0 ; i<enfermedades.size();i++){%>
                   	 <li><p style="font-size: 24px"><b><%=i+1 %>.</b> <%=enfermedades.get(i).getEnfermedad().getNombreEnfermedad()%> <br><b >Fecha inicio: </b> : <%=enfermedades.get(i).getFechaInicio() %><br>
                   	 <%=enfermedades.get(i).getFechaFin()==null ? "":"<b>Fecha fin: </b>"+enfermedades.get(i).getFechaFin() %></p></li>
                   	 <%
                   }
                    }
                   
                    %>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <hr class="potaxio">
    <!-- Cuerpo formulario Adoptar / Final -->

    <!-- otros animales / inicio -->

    <div class="container">
        <h2>Otros animales</h2>
        <br>
        <div class="row">
            <div class="col-sm-4">
                <div class="card centro">
                    <a href="index.html"><img class="card-img-top" src="https://www.sommelierdecafe.com/2019/wp-content/uploads/2019/03/Perro-de-frente-800x800.jpg" alt="Card image cap"></a>
                    <div class="card-body">
                        <h5 class="card-title">Nombre del animal</h5>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="card centro">
                    <a href="index.html"><img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/04/03/04-australian-shepherd_af05aa09_800x800.jpg" alt="Card image cap"></a>
                    <div class="card-body">
                        <h5 class="card-title">Nombre del animal</h5>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="card centro">
                    <a href="index.html"><img class="card-img-top" src="https://www.nationalgeographic.com.es/medio/2019/06/18/_3a525832_800x800.jpg" alt="Card image cap"></a>
                    <div class="card-body">
                        <h5 class="card-title">Nombre del animal</h5>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <br><br>
<!-- otros animales / final -->

<div class="contact_anipat anipat_bg_1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="contact_text text-center">
                    
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
                            <h3 class="footer_title">
                                Contacto
                            </h3>
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
                            <h3 class="footer_title">
                                Servicios
                            </h3>
                            <ul class="links">
                                <li><a href="#">Adopta</a></li>
                                <li><a href="#">Apadrina</a></li>
                                <li><a href="#">Hogar de Paso</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-3  col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Enlaces
                            </h3>
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
                                <a href="#">
                                    <img src="img/Huelleritos.png" alt="">
                                </a>
                            </div>
                            <p class="address_text">
                            </p>
                            <div class="socail_links">
                                <ul>
                                    <li>
                                        <a href="https://www.facebook.com/huelleritoscucuta">
                                            <i class="ti-facebook"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://www.instagram.com/huelleritoscucuta/">
                                            <i class="ti-instagram"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://www.instagram.com/huelleritoscucuta/">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
                                    
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
                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Huelleritos Cucuta <i class="ti-heart" aria-hidden="true"></i> 2021
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
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
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            disableDaysOfWeek: [0, 0],
        //     icons: {
        //      rightIcon: '<span class="fa fa-caret-down"></span>'
        //  }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             rightIcon: '<span class="fa fa-caret-down"></span>'
         }

        });
        var timepicker = $('#timepicker').timepicker({
         format: 'HH.MM'
     });
    </script>
</body>

</html>