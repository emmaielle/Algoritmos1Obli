package Dominio;

public class Ruta {

	private Zona origen;
	private Zona destino;
	private int minutosViaje;
	
	public Ruta(Zona origen, Zona destino, int duracion){
		this.origen = origen;
		this.destino = destino;
		this.minutosViaje = duracion;
	}
	
	//================================================================================
    // Properties
    //================================================================================
	
	public int getMinutosViaje(){
		return this.minutosViaje;
	}
	
	public void setMinutosViaje(int minutos){
		this.minutosViaje = minutos;
	}
	
	public Zona getOrigen(){
		return this.origen;
	}
	
	public void setOrigen(Zona origen){
		this.origen = origen;
	}
	
	public Zona getDestino(){
		return this.destino;
	}
	
	public void setDestino(Zona destino){
		this.destino = destino;
	}
}
