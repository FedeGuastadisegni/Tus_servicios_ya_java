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
	<center><h2 class="form-signin-heading">Modificar Institucion</h2></center>
	<br>
	
	<h3>Institucion a modificar:</h3>


	<form action="./modificar" method="post"">
	<input type="hidden" name="idInstitucion" value="${idInstitucion}">	
	<br>
	Nombre: <input name="nombre" class="form-control" placeholder="Nombre de la institución" value="${nombre}" required autofocus>
	<br>
	Direccion: <input name="direccion" class="form-control" placeholder="Direccion" value="${direccion}" required autofocus>
	<br>
	Telefono: <input name="telefono" class="form-control" placeholder="Telefono" value="${telefono}" required autofocus>
	<br>
	Entre calle A: <input name="entrecalle_a" class="form-control" placeholder="Entre calle A " value="${entrecalle_a}" required autofocus>
	<br>
	Entre calle B:<input name="entrecalle_b" class="form-control" placeholder="Entre calle B" value="${entrecalle_b}" required autofocus>
	<br>
	Coordenadas X: <input name="coordenadasx" class="form-control" placeholder="Coordenadas X" value="${coordenadasx}" required autofocus>
	<br>
	Coordenadas Y: <input name="coordenadasy" class="form-control" placeholder="Coordenadas Y" value="${coordenadasy}" required autofocus>
	<br>
	<button class="btn btn-lg btn-primary btn-block" type="button" data-toggle="modal" data-target="#modificar">Modificar</button>
		
	
</div>




<div class="modal fade bs-example-modal-sm" id="modificar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			      <div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        			<p>
        			</div>
      			<div class="modal-body">
      			<center>
      			<h3>Modificar?</h3>
	 					
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