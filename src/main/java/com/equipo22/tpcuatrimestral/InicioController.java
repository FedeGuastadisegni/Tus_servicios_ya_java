package com.equipo22.tpcuatrimestral;

import java.util.List;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.InstitucionDao;
import datos.Institucion;

@Controller
public class InicioController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(Locale locale, Model model) {
		

		return "inicio";
	}

}
