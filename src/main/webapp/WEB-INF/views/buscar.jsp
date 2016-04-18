<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
	
  <div class="container">

	<jsp:include page="header.jsp" />
<style>
.borde{
	border:2px solid #a1a1a1;
	border-radius:25px;

    width: 600px;
    max-width: 90%;
}
</style>
<br><br><br>
  <div class="page-header">
   <h1>Consulta de establecimientos</h1>
  </div>
  <div class="container borde well">
	<br>
  
  
  <form action="./mapa">
  <strong>Tipo de institución</strong>
  <select class="form-control" id="tipoInst" name="tipoInst">
  	<option value="0">--Todas--</option>
   	<c:forEach items="${lstTipoInst}" var="item">
 	<option value="${item.idTipoInst}">${item.tipo}</option>
 	</c:forEach>
</select>
  <br>
  <strong>Provincia</strong>
  <select class="form-control" id="provincia" name="provincia">
   	<c:forEach items="${lstProvincia}" var="item">
 	<option value="${item.idProvincia}">${item.nombre}</option>
 	</c:forEach>
</select>
	<br>
	<strong>Partido</strong>
<select class="form-control" id="partido" name="partido">
   	<c:forEach items="${lstPartido}" var="item">
 	<option value="${item.idPartido}" class="${item.provincia.idProvincia}">${item.nombre}</option>
 	</c:forEach>
 	<br>
</select>
	<br>
	<strong>Localidad</strong>
<select class="form-control" id="localidad" name="localidad">
<option value="0" class="<c:forEach items="${lstPartido}" var="item">${item.idPartido} </c:forEach>">--Todas--</option>
    <c:forEach items="${lstLocalidad}" var="item">
 	<option value="${item.idLocalidad}" class="${item.partido.idPartido}">${item.nombre}</option>
 	</c:forEach>
</select>
<br>

<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
<br>
</form>
</div>
<br>
<blockquote>
<p>Este buscador le permite conocer los establecimientos publicos de Ciudad de Buenos Aires y de Gran Buenos Aires. Como resultado final de la búsqueda obtendrá un mapa indicativo con los establecimentos encontrados en la zona buscada y una ficha de los mismos.</p>
</blockquote>
</div>
<jsp:include page="calljs.jsp"/>
   
   <!-- Script para el dropdown -->
	<script type="text/javascript">
		$("#partido").chained("#provincia");
		$("#localidad").chained("#partido");
		$('#partido,#provincia,#localidad,#tipoInst');
	</script>

 <!-- FOOTER -->

<jsp:include page="footer.jsp"/>
     

