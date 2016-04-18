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
import dao.LocalidadDao;
import dao.PartidoDao;
import dao.ProvinciaDao;
import dao.TipoInstDao;
import dao.UsuarioDao;
import datos.Institucion;
import datos.Localidad;
import datos.Partido;
import datos.Provincia;
import datos.TipoInst;

import java.math.BigInteger;
import java.security.*;

@Controller
public class AbmController {

	
	@RequestMapping(value = "/agregarinstitucion", method = RequestMethod.POST)
	public String agregarinstitucion(Locale locale, Model model, @RequestParam String login) {
		
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
		
		return "agregarinstitucion";
	}
	
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public String redireccion(Locale locale, Model model,
			@RequestParam String tipoInst,
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam String provincia,
			@RequestParam String partido,
			@RequestParam String localidad,
			@RequestParam String telefono,
			@RequestParam String entrecalle_a,
			@RequestParam String entrecalle_b,
			@RequestParam String coordenadasx,
			@RequestParam String coordenadasy)  {
		
		long idTipoInst = Long.valueOf(tipoInst);
		long idProvincia = Long.valueOf(provincia);
		long idPartido = Long.valueOf(partido);
        long idLocalidad = Long.valueOf(localidad);
        float coordenadasxfloat = Float.parseFloat(coordenadasx);
        float coordenadasyfloat = Float.parseFloat(coordenadasy);
        
        ProvinciaDao provDao = new ProvinciaDao();
        PartidoDao partDao = new PartidoDao();
        LocalidadDao locDao = new LocalidadDao();
        TipoInstDao tipoDao = new TipoInstDao();
        
        Provincia porv = provDao.traerProvincia(idProvincia);
        Partido part = partDao.traerPartido(idPartido);
        Localidad loc = locDao.traerLocalidad(idLocalidad);
        TipoInst tipo = tipoDao.traerTipo(idTipoInst);
        
        
        Institucion inst = new Institucion(nombre,telefono,direccion,entrecalle_a,entrecalle_b,coordenadasxfloat,coordenadasyfloat,loc,tipo);
        
        
        InstitucionDao iDao = new InstitucionDao();

		int resultado = iDao.agregarInstitucion(inst);
		
		String logagregado = "<div class='alert alert-success'>Institucion agregada correctamente</div>";
		model.addAttribute("logagregado", logagregado );

		
		//Rellenar los combos nuevamente
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
		
		return "panel";
	}
	
	
	 @RequestMapping(value = "/modificarfiltro", method = RequestMethod.POST)
     public String mapa(Locale locale, Model model,@RequestParam String tipoInst, @RequestParam String provincia,@RequestParam String partido,@RequestParam String localidad) throws Exception {
            
     	InstitucionDao iDao = new InstitucionDao();
         List <Institucion> lstInstitucion = new ArrayList<Institucion>();
         long idPartido = Long.valueOf(partido);
         long idLocalidad = Long.valueOf(localidad);
         long idTipoInst = Long.valueOf(tipoInst);
         String redireccionar = "modificarfiltro";
         
         if((idTipoInst == 0) && (idLocalidad == 0) ){
         	lstInstitucion =  iDao.traerInstitucionesFiltradasTodas(idPartido);
         }
         else if(idTipoInst == 0 ){
         	lstInstitucion =  iDao.traerInstitucionesFiltradasTodasTipo(idLocalidad);
         }
         else if(idLocalidad == 0){
         	lstInstitucion =  iDao.traerInstitucionesFiltradasTodasLocalidad(idPartido, idTipoInst);
         }
         else
         {
         	lstInstitucion =  iDao.traerInstitucionesFiltradas(idLocalidad,idTipoInst);
         };
         
         model.addAttribute("lstInstitucion", lstInstitucion);
         model.addAttribute("localidad", localidad);
         model.addAttribute("tipoInst", tipoInst);

        if(lstInstitucion.isEmpty()){
     	   redireccionar = "noencontrado";
        }
        return redireccionar;
     }
	 
	 @RequestMapping(value = "/modificarinstitucion", method = RequestMethod.POST)
		public String modificarinstitucion(Locale locale, Model model, @RequestParam String idInstitucion) {
			
		 	long idInstitucionLong = Long.valueOf(idInstitucion);
		 	InstitucionDao instDao = new InstitucionDao();
		 	Institucion inst = instDao.traerInstitucion(idInstitucionLong);
		 	
		 	model.addAttribute("idInstitucion", idInstitucion);
		 	model.addAttribute("idTipoInst", inst.getTipoInst().getIdTipoInst());
		 	model.addAttribute("nombre", inst.getNombre());
		 	model.addAttribute("direccion", inst.getDireccion());
		 	model.addAttribute("telefono", inst.getTelefono());
		 	model.addAttribute("entrecalle_a", inst.getEntrecalle_a());
		 	model.addAttribute("entrecalle_b", inst.getEntrecalle_b());
		 	model.addAttribute("coordenadasx", inst.getCoordenadasx());
		 	model.addAttribute("coordenadasy", inst.getCoordenadasy());
		 	model.addAttribute("idLocalidad", inst.getLocalidad().getIdLocalidad());
		 	//model.addAttribute("partido", inst.getLocalidad().getPartido().getNombre());
		 	//model.addAttribute("provincia", inst.getLocalidad().getPartido().getProvincia().getNombre());
		 
			return "modificarinstitucion";
		}
	 
	 
	 @RequestMapping(value = "/modificar", method = RequestMethod.POST)
		public String modificar(Locale locale, Model model,
				@RequestParam String idInstitucion,
				@RequestParam String nombre,
				@RequestParam String direccion,
				@RequestParam String telefono,
				@RequestParam String entrecalle_a,
				@RequestParam String entrecalle_b,
				@RequestParam String coordenadasx,
				@RequestParam String coordenadasy)  {
			
		 	long idInstitucionLong = Long.valueOf(idInstitucion);
	        float coordenadasxfloat = Float.parseFloat(coordenadasx);
	        float coordenadasyfloat = Float.parseFloat(coordenadasy);
	        
	        ProvinciaDao provDao = new ProvinciaDao();
	        PartidoDao partDao = new PartidoDao();
	        LocalidadDao locDao = new LocalidadDao();
	        TipoInstDao tipoDao = new TipoInstDao();


	        InstitucionDao iDao = new InstitucionDao();
	        Institucion inst = iDao.traerInstitucion(idInstitucionLong);
	        inst.setNombre(nombre);
	        inst.setDireccion(direccion);
	        inst.setTelefono(telefono);
	        inst.setEntrecalle_a(entrecalle_a);
	        inst.setEntrecalle_b(entrecalle_b);
	        inst.setCoordenadasx(coordenadasxfloat);
	        inst.setCoordenadasy(coordenadasyfloat);
	        
	        
			iDao.modificarInstitucion(inst);
			
			String logagregado = "<div class='alert alert-success'>Institucion modificada correctamente</div>";
			model.addAttribute("logagregado", logagregado );
			
			
			//Rellenar los combos nuevamente
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
			
			return "panel";
		}
	 
	 
	 
	 @RequestMapping(value = "/eliminarinstitucion", method = RequestMethod.POST)
		public String eliminar(Locale locale, Model model, @RequestParam String idInstitucion)  {
			
		 	long idInstitucionLong = Long.valueOf(idInstitucion);
	        InstitucionDao iDao = new InstitucionDao();
	        Institucion inst = iDao.traerInstitucion(idInstitucionLong);

	        
			iDao.eliminarInstitucion(inst);
			
			String logagregado = "<div class='alert alert-success'>Institucion eliminada correctamente</div>";
			model.addAttribute("logagregado", logagregado );
			
			//Rellenar los combos nuevamente
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
			
			return "panel";
		}
	
	}
