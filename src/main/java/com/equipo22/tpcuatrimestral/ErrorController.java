package com.equipo22.tpcuatrimestral;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping(value="/error/404")
    public String handle404() {
    	return "error404";
    }
    
    @RequestMapping(value="/error/500")
    public String handle500() {
    	return "error500";
    }

}