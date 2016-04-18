package datos;

import java.util.Set;

public class TipoInst {
	private long idTipoInst;
	private String tipo;
	
	private Set<Institucion> instituciones;
	
	public TipoInst() {
		
	}

	public long getIdTipoInst() {
		return idTipoInst;
	}

	private void setIdTipoInst(long idTipoInst) {
		this.idTipoInst = idTipoInst;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Institucion> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(Set<Institucion> instituciones) {
		this.instituciones = instituciones;
	}
	
	public String toString() {
		return this.tipo;
	}

}
