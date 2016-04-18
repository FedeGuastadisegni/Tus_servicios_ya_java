<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<style>
div.pos_fixed
{
position:fixed;
padding-top: 110px;
right: 10%;
z-index : 1;
}
</style>
<div class="container">
<div class="pos_fixed">
<input type="checkbox" id="cambio" data-size="large" data-off-color="primary" data-on-text="Lista" data-off-text="Mapa" checked>
</div>

</div>
<div id="mapa">
	<div id="map" class="carousel"></div>
	<center>
	<div id="volver">
		<a class="btn btn-primary" href="javascript:history.go(-1)">Nueva búsqueda</a>
	</div>
	</center>
</div>
<div id="lista" style="display:none">
<br><br><br><br><br>
<div id="tabla" class="container">
   <h3>Establecimientos cercanos encontrados:</h3>

  <table class="table table-striped ">
        <thead>
        <td>Institucion</td>
        <td>Nombre</td>
        <td>Telefono</td>
        <td>Direccion</td>
        <td>Localidad</td>
        </thead>
        <tbody>
        </tr>
  		<c:forEach items="${lstInstitucion}" var="item">
        <td><c:out value="${item.tipoInst}"/></td>
        <td><c:out value="${item.nombre}"/></td>
        <td><span class="glyphicon glyphicon-earphone">  </span> <c:out value="${item.telefono}"/></td>
        <td><span class="glyphicon glyphicon-home"> </span> <c:out value="${item.direccion}"/></td>
        <td><c:out value="${item.localidad}"/></td>
        </tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div id="volver">
	<center>
		<a class="btn btn-primary noPrint" href="javascript:history.go(-1)">Nueva búsqueda</a>
		<a class="btn btn-primary" onClick="printContent('tabla');">Imprimir</a>
	</center>
	</div>
	<br>
	
	

  
  <jsp:include page="calljs.jsp"/>
  
<script>
$('#cambio').bootstrapSwitch();
$('#cambio').on('switchChange.bootstrapSwitch', function(event, state) {
	  if(state){
		  $('#mapa').show();
		  $('#lista').hide();
	  }
	  else
		  {
		  $('#mapa').hide();
		  $('#lista').show();
		  }
	});
</script>

<script type="text/javascript">
 
  var locations =[];
  locations.push(['Mi ubicacion',${coordenadax},${coordenaday}]);
  var coordenadaxUser = ${coordenadax};
  var coordenadayUser = ${coordenaday};
  <c:forEach items="${lstInstitucion}" var="item">
  	locations.push(['${item.nombre}', '${item.coordenadasx}', '${item.coordenadasy}','${item.telefono}','${item.direccion}','${item.tipoInst.idTipoInst}','${item.tipoInst.tipo}']);
  </c:forEach>
  
  
  function Dist(lat1, lon1, lat2, lon2)  {
	  rad = function(x) {return x*Math.PI/180;}
	  var R     = 6378.137;                          //Radio de la tierra en km
	  var dLat  = rad( lat2 - lat1 );
	  var dLong = rad( lon2 - lon1 );
	  var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(rad(lat1)) * Math.cos(rad(lat2)) * Math.sin(dLong/2) * Math.sin(dLong/2);
	  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	  var d = R * c;
	  return d.toFixed(1);                      //Retorna tres decimales
	}
  
  
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-39.92, 151.25),
      scrollwheel: true,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      disableDefaultUI : true
      
    });
    
	var icon = [ "", "<span class='glyphicon glyphicon-plus'></span> ",
	 			"<span class='glyphicon glyphicon-plus'></span> ",
	 			"<span class='glyphicon glyphicon-plus'></span> ",
	 			"<span class='glyphicon glyphicon-plus'></span> ",
	 			"<span class='glyphicon glyphicon-screenshot'></span> ",
	 			"<span class='glyphicon glyphicon-fire'></span> "];

	 	var png = [ './resources/img/ubicacion.png',
	 			'./resources/img/hospital.png',
	 			'./resources/img/hospital.png',
	 			'./resources/img/hospital.png',
	 			'./resources/img/hospital.png',
	 			'./resources/img/policia.png',
	 			'./resources/img/bombero.png'];
 
    var infowindow = new google.maps.InfoWindow({ maxWidth: 900 });
 
    var marker, i;
    var markers = new Array();
    
    //Icono de mi posicion//
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[0][1], locations[0][2]),
        map: map,
        icon: './resources/img/ubicacion.png'
      
    });
    infowindow.setContent(locations[0][0]);
    infowindow.open(map, marker);
    
    
    //Iconos de las demas instituciones//
    for (i = 1; i < locations.length; i++) {

    			marker = new google.maps.Marker({
                position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                map: map,
                icon: png[locations[i][5]]
                
              });
         
              markers.push(marker);
         
              google.maps.event.addListener(marker, 'click', (function(marker, i) {
                return function() {
                  infowindow.setContent(icon[locations[i][5]]+ '<b>'+locations[i][6] +' '+ locations[i][0]+'</b><br>  <span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;'+locations[i][3]+'<br><span class="glyphicon glyphicon-home"></span> '+locations[i][4]+'<br><span class="glyphicon glyphicon-road"></span> '+ Dist(coordenadaxUser,coordenadayUser,locations[i][1],locations[i][2])+' Km.');
                  infowindow.open(map, marker);
                  map.panTo(marker.getPosition());
                }
         })(marker, i));}

 
    function AutoCenter() {
      //  Create a new viewpoint bound
      var bounds = new google.maps.LatLngBounds();
      //  Go through each...
      $.each(markers, function (index, marker) {
      bounds.extend(marker.position);
      });
      //  Fit these bounds to the map
      map.fitBounds(bounds);
    }
    AutoCenter();
    
    
    
  </script>
  

  
  

<jsp:include page="footer.jsp"/>