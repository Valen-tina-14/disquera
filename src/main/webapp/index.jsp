<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Disquera</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/menuStiles.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="shourtcut ion" href="assets/img/favicon.ico" type="image/x-icon">
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapiss.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
    
</head>

<body>
    <div class="header-nightsky">
        <nav class="navbar navbar-default">
            <div class="container">
                <a class="navbar-brand" href="#">DISQUERA</a>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp">INICIO</a></li>
                        <li class="dropdown">
                          <a class="dropdown-toggle" data-toggle="dropdown" href="#">ÁLBUM<span class="caret"></span></a>
                          <ul class="dropdown-menu">
                              <li><a href="album?accion=abrirAlbum">Add Àlbum</a></li>
                              <li><a href="album?accion=edit">Edith Àlbum</a></li>
                              <li><a href="album?accion=listar">List Àlbum</a></li>
                          </ul>
                      </li>
                      <li class="dropdown">
                          <a class="dropdown-toggle" data-toggle="dropdown" href="#">CANCIÓN <span class="caret"></span></a>
                          <ul class="dropdown-menu">
                          <li><a href="cancion?accion=abrirCancion">Add Canción</a></li>
                              <li><a href="cancion?accion=edit">Edith Canción</a></li>
                              <li><a href="cancion?accion=listar">List Canción</a></li>
                          </ul>
                      </li>
                      <li class="dropdown">
                          <a class="dropdown-toggle" data-toggle="dropdown" href="#">GENERO<span class="caret"></span></a>
                          <ul class="dropdown-menu">
                              <li><a href="genero?accion=abrirGenero">Add Genero</a></li>
                              <li><a href="genero?accion=edit">Edith Genero</a></li>
                              <li><a href="genero?accion=listar">List Genero</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="hero">
            <section>
                <img src="img/imagen1.jpg" style="border-radius: 3rem;">
            </section>
        </div>
    </div>
      <!-- Site footer -->
      <footer class="site-footer">
        <div class="container">
          <div class="row">
            </div>    
      <footer class="footer py-4">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-4 text-lg-left">Copyright © Todos los derechos reservados 2022</div>
                <div class="col-lg-4 my-3 my-lg-0">
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <div class="col-lg-4 text-lg-right">
                    <a class="mr-3" href="#!">Politica de Privacidad</a>
                    <a href="#!">Terminos y condiciones</a>
                    
                </div>
            </div>
        </div>
    </footer>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
