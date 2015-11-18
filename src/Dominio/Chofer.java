package Dominio;

public class Chofer {

	private String nombre;
	private String cedula;
	
	//================================================================================
    // Properties
    //================================================================================
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getCedula(){
		return this.cedula;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
