package com.equipo22.tpcuatrimestral;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.LocalidadDao;
import dao.PartidoDao;
import dao.ProvinciaDao;
import dao.TipoInstDao;
import dao.UsuarioDao;
import datos.Localidad;
import datos.Partido;
import datos.Provincia;
import datos.TipoInst;

import java.math.BigInteger;
import java.security.*;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping(value = "/panel", method = RequestMethod.POST)
	public String redireccion(Locale locale, Model model,
			@RequestParam String username, @RequestParam String password)
			throws NoSuchAlgorithmException {

		String redireccion = "login";
		String passwordMd5 = stringToMd5(password);
		boolean logueado = false;

		UsuarioDao uDao = new UsuarioDao();
		logueado = uDao.verificarUsuario(username, passwordMd5);

		if (logueado) {
			redireccion = "panel";
			model.addAttribute("username", username);
		}
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
		String logerror = "<div class='alert alert-danger'>Usuario o Password Incorrecto</div>";
		model.addAttribute("logerror", logerror );
		return redireccion;
		
	}

	public static String stringToMd5(String password)
			throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(password.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		System.out.println(password);
		System.out.println(hashtext);
		return hashtext;
	}
}