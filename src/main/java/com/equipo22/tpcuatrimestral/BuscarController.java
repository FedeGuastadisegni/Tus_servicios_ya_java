package com.equipo22.tpcuatrimestral;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.InstitucionDao;
import dao.LocalidadDao;
import dao.PartidoDao;
import dao.ProvinciaDao;
import dao.TipoInstDao;
import datos.Institucion;
import datos.Localidad;
import datos.Partido;
import datos.Provincia;
import datos.TipoInst;

@Controller
public class BuscarController {

	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String buscar(Locale locale, Model model) {
		
		
		
		TipoInstDao Tdao = new TipoInstDao();
		List<TipoInst> lstTipoInst = new ArrayList<TipoInst>();
		lstTipoInst = Tdao.traerListaTipoInst();
		
		model.addAttribute("lstTipoInst", lstTipoInst);
		
		PartidoDao pDao = new PartidoDao();
		List<Partido>lstPartido = new ArrayList<Partido>();
		lstPartido=pDao.traerListaPartidos();
		
		model.addAttribute("lstPartido", lstPartido);
		
		LocalidadDao lDao = new LocalidadDao();
		List<Localidad>lstLocalidad = new ArrayList<Localidad>();
		lstLocalidad = lDao.traerListaLocalidades();
		
		model.addAttribute("lstLocalidad", lstLocalidad);
		
		ProvinciaDao prDao = new ProvinciaDao();
		List<Provincia>lstProvincia = new ArrayList<Provincia>();
		lstProvincia = prDao.traerListaProvincias();
		
		model.addAttribute("lstProvincia", lstProvincia);

		return "buscar";
	}
	

}
