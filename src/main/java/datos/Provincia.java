package datos;

import java.util.Set;

public class Provincia {
	private long idProvincia;
	private String nombre;
	
	private Set<Partido> partidos;
	
	public Provincia() {
		
	}

	public Provincia(long idProvincia, String nombre, Set<Partido> partidos) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.partidos = partidos;
	}

	public long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public String toString(){
		return String.valueOf(this.getIdProvincia());
	}
	
}
