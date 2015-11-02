package Dominio;

public class Abonado {

	private Zona deZona;
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Abonado(int abonadoId, String abonadoNombre, String abonadoDireccion, String abonadoTel, Zona zona){
		this.deZona = zona;
		this.direccion = abonadoDireccion;
		this.id = abonadoId;
		this.nombre = abonadoNombre;
		this.telefono = abonadoTel;
	}
	
	public Zona getZona(){
		return this.deZona;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public String getTelefono(){
		return this.telefono;
	}
	
}
