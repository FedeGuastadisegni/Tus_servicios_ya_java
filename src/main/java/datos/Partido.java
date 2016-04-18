package datos;

import java.util.Set;

public class Partido {
	private long idPartido;
	private Provincia provincia;
	private String nombre;
	
	private Set<Localidad> localidades;
	
	public Partido() {
		
	}

	public Partido(long idPartido, Provincia provincia, String nombre,
			Set<Localidad> localidades) {
		this.idPartido = idPartido;
		this.provincia = provincia;
		this.nombre = nombre;
		this.localidades = localidades;
	}

	public long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(long idPartido) {
		this.idPartido = idPartido;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Set<Localidad> localidades) {
		this.localidades = localidades;
	}
	
	public String toString(){
		return this.nombre;
	}
	

}

