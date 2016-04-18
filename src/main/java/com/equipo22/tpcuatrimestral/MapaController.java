package com.equipo22.tpcuatrimestral;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dao.InstitucionDao;
import datos.Institucion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class MapaController {
 
       
        @RequestMapping(value = "/mapa", method = RequestMethod.GET)
        public String mapa(Locale locale, Model model,@RequestParam String tipoInst, @RequestParam String provincia,@RequestParam String partido,@RequestParam String localidad) throws Exception {
               
        	InstitucionDao iDao = new InstitucionDao();
            List <Institucion> lstInstitucion = new ArrayList<Institucion>();
            long idPartido = Long.valueOf(partido);
            long idLocalidad = Long.valueOf(localidad);
            long idTipoInst = Long.valueOf(tipoInst);
            String redireccionar = "mapa";
            
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
 
}
 