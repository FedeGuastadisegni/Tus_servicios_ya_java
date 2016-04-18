package datos;

import java.util.Set;

public class Localidad {
	private long idLocalidad;
	private Partido partido;
	private String nombre;
	
	private Set<Institucion> instituciones;
	
	public Localidad() {
		
	}


	
	public Localidad(Partido partido, String nombre) {
		this.partido = partido;
		this.nombre = nombre;
		this.instituciones = instituciones;
	}
	
	



	public long getIdLocalidad() {
		return idLocalidad;
	}



	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}



	public Partido getPartido() {
		return partido;
	}



	public void setPartido(Partido partido) {
		this.partido = partido;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Set<Institucion> getInstituciones() {
		return instituciones;
	}



	public void setInstituciones(Set<Institucion> instituciones) {
		this.instituciones = instituciones;
	}



	public String toString(){
		return this.nombre;
	}

}
