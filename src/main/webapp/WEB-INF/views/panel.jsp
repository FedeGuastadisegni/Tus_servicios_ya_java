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

	<div class="page-header">

		<style>
.borde {
	border: 2px solid #a1a1a1;
	border-radius: 25px;
	width: 300px;
	max-width: 90%;
}
</style>

		${logagregado}

		<h1>Panel de Administrador !</h1>
	</div>
	<p>Seleccione la opcion que desea realizar</p>


	<div class="container borde well">
		<center>
		<form action="./agregarinstitucion" method="post">
			<input type="hidden" name="login" value="login">
			<button class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-plus-sign"></span> Agregar Institucion</button>
		</button>
		</form>
		<br>
		<br>
		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#EditarInstitucion">
			<span class="glyphicon glyphicon-edit"></span> Editar/Eliminar Institución</button>
		</center>
		<br>
	</div>




	<!-- EMPIEZA MODAL EDITAR INSTITUCION  -->
	<div class="modal fade" id="EditarInstitucion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h2 class="modal-title" id="myModalLabel">Editar/Eliminar institución</h2>
				</div>
				<div class="modal-body">


					<form action="./modificarfiltro" method="post">
  <select class="form-control" id="tipoInst" name="tipoInst">
  	<option value="0">--Todas--</option>
   	<c:forEach items="${lstTipoInst}" var="item">
 	<option value="${item.idTipoInst}">${item.tipo}</option>
 	</c:forEach>
</select>
  <br>
  <select class="form-control" id="provincia" name="provincia">
   	<c:forEach items="${lstProvincia}" var="item">
 	<option value="${item.idProvincia}">${item.nombre}</option>
 	</c:forEach>
</select>
	<br>
<select class="form-control" id="partido" name="partido">
   	<c:forEach items="${lstPartido}" var="item">
 	<option value="${item.idPartido}" class="${item.provincia.idProvincia}">${item.nombre}</option>
 	</c:forEach>
 	<br>
</select>
	<br>
<select class="form-control" id="localidad" name="localidad">
<option value="0" class="<c:forEach items="${lstPartido}" var="item">${item.idPartido} </c:forEach>">--Todas--</option>
    <c:forEach items="${lstLocalidad}" var="item">
 	<option value="${item.idLocalidad}" class="${item.partido.idPartido}">${item.nombre}</option>
 	</c:forEach>
</select>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cerrar</button>
							<button class="btn btn-primary type">Buscar</button>
						</div>

						<br>
					</form>



				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
		</div>
		<!-- TERMINA MODAL EDITAR INSTITUCION  -->
					<br> <br>




			<jsp:include page="calljs.jsp" />
			
			
			<!-- Script para el dropdown -->
			<script type="text/javascript">
				$("#partido").chained("#provincia");
				$("#localidad").chained("#partido");
				$('#partido,#provincia,#localidad,#tipoInst');
			</script>
			<jsp:include page="footer.jsp" />