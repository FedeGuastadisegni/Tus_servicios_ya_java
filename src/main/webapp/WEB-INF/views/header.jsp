<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="./resources/favicon.ico">
    <title>Tu Servicio Ya!</title>
    
    <!--  ================ Llamadas a CSS ================== -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="all" > 
    <link href="./resources/css/bootstrap-switch.min.css" rel="stylesheet" media="all" > 
    <link href="./resources/css/carousel.css" rel="stylesheet" media="all">
    <link rel="stylesheet" type="text/css" media="print" href="./resources/css/print.css">
    
    <script type="text/javascript">
    
    function printContent(el){
    	var restorepage = document.body.innerHTML;
    	var printContent = document.getElementById(el).innerHTML;
    	document.body.innerHTML = printContent;
    	window.print();
    	document.body.innerHTML = restorepage;
    }
    
    
    </script>
    
    <style type="text/css">
    ul.nav a:hover { color: #158cba !important; }
    </style>

  </head>
  
  <body>
    
  <!--  ======================= NAVBAR =========================== -->
    <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand"><img src="./resources/img/logo.png" class="img-responsive" alt="Responsive image"></a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="./">Inicio</a></li>
                <li class="active"><a href="./buscar">Consulta de establecimientos</a></li>
                <li class="active"><a href="./establecimientoscercanos">Establecimientos cercanos</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>