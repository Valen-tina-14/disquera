<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <title>Disquera</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="img/favicon.ico" />
      <!-- Font Awesome icons (free version)-->
      <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
      <!-- Google fonts-->
      <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
      <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
      <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/menuStiles.css">
  <link rel="stylesheet" type="text/css" href="css/stylesInOperario.css">
  <link rel="stylesheet" type="text/css" href="css/stylesConOperario.css">

   
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>

<body>
    <div class="header-nightsky">
        <nav class="navbar navbar-default">
            <div class="container">
                <a class="navbar-brand" href="#">GENERO</a>
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
       
    </div>
    <br><br><br>
     <!-- Contact-->
     <section  id="formulario">
        <center>
                <h1>RESULTADOS</h1>
                <br><br><br>

        <table id="racetimes">
        <tr class= "tabla" id="firstrow">
          <center>
                  <th>Id</th>
                  <th>Nombre</th>
                  <th>Estado</th>
                  <th>Acciones</th>
                </center>
        </tr>
        <c:forEach var="Generos" items="${Generos}">         
        
          <tr>
          <td>${Generos.getIdGenero()}</td>
          <td>${Generos.getNombreGenero()}</td>
          <c:if test="${Generos.isEstadoGenero() == true}">
             <td><span>Genero Activo</span></td> 
          </c:if>
          <c:if test="${Generos.isEstadoGenero() == false}">
              <td><span>Genero Inactivo</span></td> 
          </c:if>
          
          <td>
          <c:if test="${Generos.isEstadoGenero() == true}">
             <a href="genero?accion=esta&idGenero=${Generos.getIdGenero()}&estadoGenero=false"><button>Inactivar</button>
        
          </a>
          </c:if>
          <c:if test="${Generos.isEstadoGenero() == false}">
            <a href="genero?accion=esta&idGenero=${Generos.getIdGenero()}&estadoGenero=true"><button>Activar</button>

          </a>
          </c:if> 
              <td>
                <a href="genero?accion=edit&idGenero=${Generos.getIdGenero()}"><button>Editar</button>
                  </a>

                  <a href="genero?accion=eliminar&idGenero=${Generos.getIdGenero()}"><button>Eliminar</button>
                  </a>
                </c:forEach>  
</table>
  <center>
  </section>
     <!-- Site footer -->
     <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>NOSOTROS</h6>
            <p class="text-justify">Disquera.S.A.S Somos la plataforma de musica mas moderna, te brindamos lo mejor 
              de la musica. 
               </p>
          </div>    
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2021 Todos los Derechos Reservados. 
         
            </p>
          </div>

          <div class= "iconos">
            <ul class="social-icons">
            <li><a class="facebook" href="#"><i class="fab fa-facebook"></i></a></li>
              <li><a class="twitter" href="#"><i class="fab fa-twitter"></i></a></li>
              <li><a class="dribbble" href="#"><i class="fab fa-instagram"></i></a></li>
              <li><a class="linkedin" href="../../index.html"><i class="fas fa-sign-out-alt"></i></a></li>   
            </ul>
          </div>
        </div>
      </div>
</footer>
  
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>