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
	
	//================================================================================
    // Properties
    //================================================================================
	
	public Zona getZona(){
		return this.deZona;
	}
	
	public void setZona(Zona zona){
		this.deZona = zona;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public void setDireccion(String direcc){
		this.direccion = direcc;
	}
	
	public String getTelefono(){
		return this.telefono;
	}
	
	public void setTelefono(String tel){
		this.telefono = tel;
	}
}
