<%@page import="co.edu.ufps.huelleritos.entities.*"%>
<%@page import="co.edu.ufps.huelleritos.dao.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
    <head>
        <link rel="shortcut icon" href="#" />
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>login huelleritos</title>

        <link rel="stylesheet" href="../administrador/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../administrador/estilos.css">
        <link rel="stylesheet" href="../administrador/plugins/sweetalert2/sweetalert2.min.css">        
       
    </head>
    
    <body>
     
      <div class="login container-login ">
        <div class="wrap-login">
            <form class="login-form validate-form" id="formLogin" action="Login/Log" method="post">
                <span class="login-form-title">Inicio de Sesión</span>
                
                <div class="wrap-input100" data-validate = "Usuario incorrecto">
                    <input class="input100" type="text" id="usuario" name="usuario" placeholder="Usuario">
                    <span class="focus-efecto"></span>
                </div>
                
                <div class="wrap-input100" data-validate="Password incorrecto">
                    <input class="input100" type="password" id="Contrasena" name="password" placeholder="Contraseña">
                    <span class="focus-efecto"></span>
                </div>
                <div class="group wrap-input100">
                            
                            <select class="form-control" id="ingresarTipo" name="tipo">
                                <option value="Seleccione">Seleccione el rol</option>
                                <option value="admin">Administrador</option>
                                <option value="hogar">Hogar de paso</option>
                                <option value="adoptante">Adoptante</option>
                            </select>
                        </div>
                
                <div class="container-login-form-btn">
                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>
                        <button type="submit" name="submit" class="login-form-btn">Ingresar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>     
        
        
     <script src="../administrador/jquery/jquery-3.3.1.min.js"></script>    
     <script src="../administrador/bootstrap/js/bootstrap.min.js"></script>    
            
    </body>
</html>