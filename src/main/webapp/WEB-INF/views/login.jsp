<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />
<style>
.borde{
	border:2px solid #a1a1a1;
	border-radius:25px;

    width: 300px;
    max-width: 90%;
}
</style>
<br><br><br><br><br><br>
<div class="container borde well">
	${logerror}
	<h2 class="form-signin-heading">Login</h2>

	<form action="./panel" method="post">
		<input name="username" class="form-control" placeholder="Usuario" required autofocus> 
		<input type="password" name="password" class="form-control" placeholder="Password" required>
		<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
		<br>
	</form>
</div>
<br><br>
	<jsp:include page="calljs.jsp" />

	<jsp:include page="footer.jsp" />