package datos;

import java.util.Set;

public class Usuario {
	private long idUsuario;
	private String username;
	private String password;
	
	public Usuario() {	}

	public Usuario(long idUsuario, String username, String password) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		String obj = username + " " + password;
		return obj;
	}
	
}
