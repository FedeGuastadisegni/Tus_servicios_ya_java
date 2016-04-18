<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

	<style>
.borde{
	border:2px solid #a1a1a1;
	border-radius:25px;

    width: 600px;
    max-width: 90%;
}
</style>
  <div class="container">

<br><br><br>
  <div class="page-header">
   <h1>Establecimientos cercanos</h1>  
  </div>
  
    <div class="container borde well">
	<br>
	<strong>Tipo de establecimiento</strong>
    <select class="form-control" id="tipo">
  	<option value="0">--Todas--</option>
 	<option value="1">Centros de Salud</option>
	<option value="5">Comisarias</option>
	<option value="6">Bomberos</option>
</select>
<br>
<strong>Distancia</strong>
<select class="form-control" id="distancia">
	<option value="0.00955792">1 Km</option>
  	<option value="0.0238948" selected>2,5 Km</option>
  	<option value="0.02867376">3 Km</option>
  	<option value="0.0477896">5 Km</option>
</select>

<br>

<button onclick="getLocation();" class="btn btn-lg btn-primary btn-block" type="button" data-toggle="modal" data-target=".modal">Buscar</button>
<br>
 	<br>
</div>

  
  <br>
<blockquote>
<p>Esta característica te permite visualizar los establecimientos publicos mas cercanos a tu ubicación.  .</p>
 </blockquote>
  <br>
</div>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
              <div class="modal-header">
            <h1>Buscando...</h1>
            <p id="aviso"></p>
            <p>Espere por favor...</p>
  		<br>
        </div>
        <div class="modal-body" id="modal-body">
<div class="progress progress-striped active">
  <div class="progress-bar"  role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
  </div>
</div>
        </div>
    </div>
  </div>
</div>

<jsp:include page="calljs.jsp"/>
<script>
function getTipo(){
$( document ).ready(function() {
	$( '#tipo' ).change( function() {
		idTipo = $("select#tipo>option:selected").attr('value');
		return idTipo;
	});
});
}
function getDistancia(){
	$( document ).ready(function() {
		$( '#distancia' ).change( function() {
			distancia = $("select#distancia>option:selected").attr('value');
			return distancia;
		});
	});
	}
var x=document.getElementById("aviso");

var idTipo = 0;
if (getTipo()) {
	var idTipo = getTipo();
}

var distancia = 0.0238948;
if (getDistancia()) {
	var distancia = getDistancia();
}

function getLocation()
	{
	if (navigator.geolocation)
{
	navigator.geolocation.getCurrentPosition(showPosition);
}
		else{x.innerHTML="La geolocalización no es soportada por este navegador.";}
	}
function showPosition(position)
	 {
	var coordenadax = position.coords.latitude;
	 var coordenaday = position.coords.longitude;
	 window.location.href = "./ubicacion?coordenadax="+coordenadax+"&coordenaday="+coordenaday+"&idTipo="+idTipo+"&distancia="+distancia; //Envio por URL!!//
	 }
</script>


<jsp:include page="footer.jsp"/>


