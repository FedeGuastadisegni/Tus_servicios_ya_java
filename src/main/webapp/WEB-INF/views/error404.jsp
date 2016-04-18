<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<style>
/**
 * Extra large button extensions. Extends `.btn`.
 */
.btn-xlarge {
    padding: 18px 28px;
    font-size: 22px;
    line-height: normal;
    -webkit-border-radius: 8px;
       -moz-border-radius: 8px;
            border-radius: 8px;
    }
</style>
  
  
  <div class="container">
  <br><br><br><br><br><br><br>
  <div class="jumbotron">
  <h1><strong>404</strong></h1>
  <p>Parece que la pagina que buscás no la encontramos</p>
  <p>Para compensarte te regalamos esta foto de ti</p>
  <p><button class="btn btn-primary btn-xlarge" data-toggle="modal" data-target=".bs-example-modal-sm"><span class="glyphicon glyphicon-camera"></span></button></p>
</div>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <img border="0" src="./resources/img/perritoloco.jpg">
    </div>
  </div>
</div>


<jsp:include page="calljs.jsp"/>


<jsp:include page="footer.jsp"/>