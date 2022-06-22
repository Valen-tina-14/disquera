<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Disquera</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="../../assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../assets/css/menuStiles.css">
    <link rel="stylesheet" type="text/css" href="../../assets/css/stylesInOperario.css">

    
   
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>

<body>
    <div class="header-nightsky">
        <nav class="navbar navbar-default">
            <div class="container">
                <a class="navbar-brand" href="#">ÁLBUM</a>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../menu/menu.php">INICIO</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">ÁLBUM<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="addAlbum.jsp">Add Álbum</a></li>
                                <li><a href="editAlbum.jsp">Edith Álbum</a></li>
                                <li><a href="listAlbum.jsp">List Álbum</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">CANCIÓN <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                            <li><a href="addCancion.jsp">Add Canción</a></li>
                                <li><a href="editCancion.jsp">Edith Canción</a></li>
                                <li><a href="listCancion.jsp">List Canción</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">GENERO<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="addGenero.jsp">Add Genero</a></li>
                                <li><a href="editGenero.jsp">Edith Genero</a></li>
                                <li><a href="listGenero.jsp">List Genero</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
       
    </div>
     <!-- Contact-->
    <section  id="formulario">
        <center>
             <h2>ACTUALIZAR ÁLBUM</h2> <br> <br> <br>
                <form action="#" method="POST">
                        
                        
                            <div class="form">
                                <div class="grupo">
                                    <input type="number" name="idAlbum" required="required"><span class="barra"></span>
                                    <label>Identificacion Álbum: </label>
                                </div>
                                <div class="grupo">
                                    <input type="text" name="nombreAlbum" required="required"><span class="barra"></span>
                                    <label>Nombre Álbum: </label>
                                </div>
                                <div class="grupo">
                                    <input type="number" name="anioPublicacion" required="required"><span class="barra"></span>
                                    <label>Año Publicación:  </label>
                                </div>
                                <div> <br>
                                    <select class="grupo" name="estadoAlbum">
                                           <option value="Activo">Activo</option>
                                           <option value="Inactivo">Inactivo</option>
                                        <label>Estado Álbum: </label>
                                       </select>
                                    </div>
                            </div>

                    <div class="text-center">
                    
                        <button class="button" id="sendMessageButton" type="submit">ACTUALIZAR</button>
                    </div>
                </form>
            </div>
            </center>
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
