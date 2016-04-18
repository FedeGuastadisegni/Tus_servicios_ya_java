package com.noya.tpcuatrimestral;


import dao.UsuarioDao;

public class testLoggin {

	public static void main(String[] args) {
		
        UsuarioDao usuarioDao=new UsuarioDao();

        String username = "admin";
        String password = "21232f297a57a5a743894a0e4a801fc3";

        System.out.println(usuarioDao.verificarUsuario(username, password));
        
	}

}
