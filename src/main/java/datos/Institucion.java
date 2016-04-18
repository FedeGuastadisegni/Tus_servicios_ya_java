package datos;


public class Institucion {
	private long idInstitucion;
	private String nombre;
	private String telefono;
	private String direccion;
	private String entrecalle_a;
	private String entrecalle_b;
	private float coordenadasx;
	private float coordenadasy;
	private Localidad localidad;
	private TipoInst tipoInst;
	
	public Institucion() {
		
	}


	
	public Institucion(String nombre, String telefono,
			String direccion, String entrecalle_a, String entrecalle_b,
			float coordenadasx, float coordenadasy, Localidad localidad,
			TipoInst tipoInst) {

		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.entrecalle_a = entrecalle_a;
		this.entrecalle_b = entrecalle_b;
		this.coordenadasx = coordenadasx;
		this.coordenadasy = coordenadasy;
		this.localidad = localidad;
		this.tipoInst = tipoInst;
	}



	public long getIdInstitucion() {
		return idInstitucion;
	}



	public void setIdInstitucion(long idInstitucion) {
		this.idInstitucion = idInstitucion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getEntrecalle_a() {
		return entrecalle_a;
	}



	public void setEntrecalle_a(String entrecalle_a) {
		this.entrecalle_a = entrecalle_a;
	}



	public String getEntrecalle_b() {
		return entrecalle_b;
	}



	public void setEntrecalle_b(String entrecalle_b) {
		this.entrecalle_b = entrecalle_b;
	}



	public float getCoordenadasx() {
		return coordenadasx;
	}



	public void setCoordenadasx(float coordenadasx) {
		this.coordenadasx = coordenadasx;
	}



	public float getCoordenadasy() {
		return coordenadasy;
	}



	public void setCoordenadasy(float coordenadasy) {
		this.coordenadasy = coordenadasy;
	}



	public Localidad getLocalidad() {
		return localidad;
	}



	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}



	public TipoInst getTipoInst() {
		return tipoInst;
	}



	public void setTipoInst(TipoInst tipoInst) {
		this.tipoInst = tipoInst;
	}


	public String toString() {
		String obj = 
				idInstitucion + 
				" " + nombre + 
				" " + telefono + 
				" " + direccion +
				" " + entrecalle_a +
				" " + entrecalle_b +
				" " + coordenadasx +
				" " + coordenadasy + 
				" " + "Localidad: " + localidad.getIdLocalidad() + 
				" [Nombre:"+ localidad.getNombre() +
				" ] [Tipo Institucion: " +tipoInst.getIdTipoInst()+ 
				" Nombre: "+ tipoInst.getTipo()+" ]";
				return obj;
			}

}
