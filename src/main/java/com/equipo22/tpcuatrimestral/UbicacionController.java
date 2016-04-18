package com.equipo22.tpcuatrimestral;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.InstitucionDao;
import datos.Institucion;

@Controller
public class UbicacionController {

	
	@RequestMapping(value = "/ubicacion", method = RequestMethod.GET)
	public  String ubicacion(Locale locale, Model model,@RequestParam float coordenadax,@RequestParam float coordenaday,@RequestParam long idTipo,@RequestParam float distancia ) throws Exception{

		
		float limiteSuperior = coordenadax+distancia;
		float limiteInferior = coordenadax-distancia;
		float limiteDerecho = coordenaday+distancia;
		float limiteIzquierdo = coordenaday-distancia;
		
		InstitucionDao instDao = new InstitucionDao();
		List<Institucion> lstInstitucion = new ArrayList<Institucion>();
		lstInstitucion=instDao.traerInstitucionesUbicacion(limiteInferior, limiteSuperior, limiteIzquierdo, limiteDerecho,idTipo);
		
		model.addAttribute("lstInstitucion", lstInstitucion);
		model.addAttribute("coordenadax", coordenadax);
		model.addAttribute("coordenaday", coordenaday);
		
		String redireccionar = "ubicacion";
		
        if(lstInstitucion.isEmpty()){
     	   redireccionar = "noencontrado";
        }
		
		return redireccionar;
	}

}