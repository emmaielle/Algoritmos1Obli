package Dominio;

import Listas.ILista;

public class Zona {

	int id;
	String nombre;
	ILista esOrigenDeRutas;
	ILista moviles;
	
	public boolean tieneIdX(int idZona){
		
		return this.id == idZona;
	}
	
	public boolean informeMovil(){
		System.out.println("Informe de móviles en: " + this.id + "-" + this.nombre);
		for (Object o : moviles){
			Movil m = (Movil) o;
			System.out.println(m.id);
		}
		return true;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
}
