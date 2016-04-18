<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" %>

<jsp:include page="header.jsp"/>
    <style>
#arrowd {
    position: relative;
}
</style>
<!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active" style="background-position:center; background-image: url(./resources/img/slide-1.jpg);">
          <div class="container">
            <div class="carousel-caption">
              <h1 style="color:black;background-color:rgba(255,255,255,0.5);">Tus servicios, cuando quieras,donde quieras!</h1>
              <p style="background-color:rgba(0,128,255,0.8);">Encontra todas las instituciones que necesites, estes donde estes!</p>
            <br><br>
            </div>
          </div>
        </div>
        <div class="item" style="background-position:center; background-image: url(./resources/img/slide-2.jpg);">
          <div class="container">
            <div class="carousel-caption">
              <h1 style="color:black;background-color:rgba(255,255,255,0.5);">Realiza tu busqueda personalizada!</h1>
              <p style="background-color:rgba(0,128,255,0.8);">Con un potente motor de busqueda accede a las direcciones más rapido.</p>
              <p><a class="btn btn-lg btn-primary" href="./buscar" role="button">Pruebalo!</a></p>
            </div>
          </div>
        </div>
        <div class="item" style="background-position:center; background-image: url(./resources/img/slide-3.jpg);">
          <div class="container">
            <div class="carousel-caption">
              <h1 style="color:black;background-color:rgba(255,255,255,0.5);">No te muevas!</h1>
              <p style="background-color:rgba(0,128,255,0.8);">Utilizando tu ubicación, puedes encontrar todas las instituciones que tenes cerca.</p>
              <p><a class="btn btn-lg btn-primary" href="./establecimientoscercanos" role="button">Geolocalización</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div><!-- /.carousel -->
<center>
<div id="arrowd" class="center container"><h1><span class="glyphicon glyphicon-chevron-down"></span></h1></div>
</center>

	<div class="container">
      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Responsivo <span class="text-muted">Adaptable a todos los dispositivos.</span></h2>
          
        </div>
        <div class="col-md-5">
          <img src="./resources/img/responsivo.png"  />
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-6">
          <img src="./resources/img/imgmedio.png"  />
        </div>
        <div class="col-md-6">
          <h2 class="featurette-heading">Instituciones <span class="text-muted">Bomberos, hospitales, comisarias y más servicios útiles para que encuentres lo que necesites.</span></h2>
        </div>
      </div>

      <hr class="featurette-divider">
      
            <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Regional y Federal <span class="text-muted">Conoce que servicios ofrece tu comunidad en cualquier parte de la Argentina.</span></h2>
          <p class="lead"></p>
        </div>
        <div class="col-md-5">
          <img src="./resources/img/imgtop.png"  />
        </div>
      </div>

      <hr class="featurette-divider">
</div>
      <!-- /END THE FEATURETTES -->
      
<div class="container">
<a class="btn btn-lg btn-primary" href="./login" role="button"><span class="glyphicon glyphicon-log-in"></span> Login</a>
</div>

<jsp:include page="calljs.jsp"/>

<script type="text/javascript">
var $arrowd = $("#arrowd");
bounce();
function bounce() {
    $arrowd.animate({
        top: "+=10"
    }, 300, function() {
        $arrowd.animate({
            top: "-=10"
        }, 300, function() {
            bounce();
        })
    });
}

$arrowd.hover(function() {        
    jQuery.fx.off = true;
}, function() {
    jQuery.fx.off = false;
});
</script>

<jsp:include page="footer.jsp"/>