<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />


<div class="container">
	<br>
	<br>
	<br>
	<br>
	<br>


<style>
.borde{
	border:2px solid #a1a1a1;
	border-radius:25px;

    width: 600px;
    max-width: 90%;
}
</style>

<div class="container borde well">

	<center><h2 class="form-signin-heading">Agregar Institución</h2></center>
	<br>
	<form action="./agregar" method="post"">
	
	
	<table >
  <tr>
    <td width="300">
    	<select class="form-control" id="tipoInst" name="tipoInst"  >
			<c:forEach items="${lstTipoInst}" var="item">
				<option value="${item.idTipoInst}">${item.tipo}</option>
			</c:forEach>
		</select>
    </td>
    <td width="300">
    	<select class="form-control" id="localidad" name="localidad">
			<option value="0" class="<c:forEach items="${lstPartido}" var="item">${item.idPartido}</c:forEach>"></option>
			<c:forEach items="${lstLocalidad}" var="item">
				<option value="${item.idLocalidad}"	class="${item.partido.idPartido}">${item.nombre}</option>
			</c:forEach>
		</select>
    </td>
  </tr>
  <tr>
    <td>
    	<input name="nombre" class="form-control" placeholder="Nombre de la institución" required autofocus>
    </td>
    <td>
		<input name="entrecalle_a" class="form-control" placeholder="Entre calle A" required autofocus>
	</td>
  </tr>
  <tr>
    <td>
    	<input name="telefono" class="form-control" placeholder="Telefono" required autofocus>
    </td>
    <td>
    	<input name="entrecalle_b" class="form-control" placeholder="Entre calle B" required autofocus>
    </td>
  </tr>
  <tr>
    <td>
    	<input name="direccion" class="form-control" placeholder="Direccion" required autofocus>
    </td>
    <td>
    	<input name="coordenadasx" class="form-control" placeholder="Coordenadas X" required autofocus>
    </td>
  </tr>
  <tr>
    <td>
    	<select class="form-control" id="provincia" name="provincia">
			<c:forEach items="${lstProvincia}" var="item">
				<option value="${item.idProvincia}">${item.nombre}</option>
			</c:forEach>
		</select>
    </td>
    <td>
    	<input name="coordenadasy" class="form-control" placeholder="Coordenadas Y" required autofocus>
    </td>
  </tr>
    <tr>
    <td>
    	<select class="form-control" id="partido" name="partido">
			<c:forEach items="${lstPartido}" var="item">
				<option value="${item.idPartido}" class="${item.provincia.idProvincia}">${item.nombre}</option>
			</c:forEach>
		</select>
    </td>
    <td>
    	
    </td>
  </tr>

</table>
<br>
<button type="button" class="btn btn-lg btn-primary btn-block" data-toggle="modal" data-target="#agregar">Agregar</button>



		
<br>
<a class="btn btn-primary" href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left"></span> Volver</a>
</div>



<div class="modal fade bs-example-modal-sm" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			      <div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        			<p>
        			</div>
      			<div class="modal-body">
      			<center>
      			<h3>Agregar?</h3>
	 					
	 					<button type="button" data-dismiss="modal" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-remove"></span></button>
	 					<button class="btn btn-success btn-lg" type="submit"><span class="glyphicon glyphicon-ok"></span></button>
	 					
	 				</form>
	 				</center>
	 			<div class="modal-footer"></div>
	 			</div>
				</div>
			</div>
		</div>
		</div>

	

	<jsp:include page="calljs.jsp" />

	<!-- Script para el dropdown -->
	<script type="text/javascript">
		$("#partido").chained("#provincia");
		$("#localidad").chained("#partido");
		$('#partido,#provincia,#localidad,#tipoInst');
	</script>

	<br> <br>

	<jsp:include page="footer.jsp" />