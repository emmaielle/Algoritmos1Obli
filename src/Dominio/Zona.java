package Dominio;

public class Zona {

	int id;
	String nombre;
	
	public boolean tieneIdX(int idZona){
		
		return this.id == idZona;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
}
