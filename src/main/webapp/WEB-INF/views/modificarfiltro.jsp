<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="header.jsp" />

<div class="container">

<br><br><br><br><br><br>
<h3>Establecimientos encontrados:</h3>

	<table class="table table-striped ">
		<thead>
			<th>Nombre</th>
			<th>Institucion</th>
			<th>Telefono</th>
			<th>Direccion</th>
			<th>Localidad</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${lstInstitucion}" var="item">
			<tr>
				<td><c:out value="${item.nombre}" /></td>
				<td><c:out value="${item.tipoInst}" /></td>
				<td><c:out value="${item.telefono}" /></td>
				<td><c:out value="${item.direccion}" /></td>
				<td><c:out value="${item.localidad}" /></td>
				<td>
					<form id="editar${item.idInstitucion}" action="./modificarinstitucion" method="post">
	 					<input type="hidden" name="idInstitucion" value="${item.idInstitucion}">
	 					<button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-edit"></span></button>
	 				</form>
				<td>
				<td>
	 					<button class="btn btn-primary" data-toggle="modal" data-target="#eliminar${item.idInstitucion}"><span class="glyphicon glyphicon-trash"></span></button>
	 				</form>
				<td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="volver">
		<a class="btn btn-primary" href="javascript:history.go(-1)">Nueva búsqueda</a>
	</div>
	
</div>

<c:forEach items="${lstInstitucion}" var="item">
	<div class="modal fade bs-example-modal-sm" id="eliminar${item.idInstitucion}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			      <div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        			<p>
        			</div>
      			<div class="modal-body">
      			<center>
      			<h3>Eliminar?</h3>
						<form action="./eliminarinstitucion" method="post">
	 					<input type="hidden" name="idInstitucion" value="${item.idInstitucion}">
	 					
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
</c:forEach>

<jsp:include page="calljs.jsp" />

<jsp:include page="footer.jsp" />

