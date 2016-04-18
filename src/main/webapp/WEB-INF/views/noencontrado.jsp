<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
  
  
  <div class="container ">
  <br><br><br><br><br><br><br>
  
  <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span>&nbsp;&nbsp;&nbsp;No se encontro ningun resultado referente a su busqueda.</div>


<div id="browse_app">
  <a class="btn btn-primary" href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left"></span> Volver</a>
</div>

  <br>
  <br>
  
<jsp:include page="footer.jsp"/>