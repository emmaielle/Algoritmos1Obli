package Dominio;

import Listas.ListaOrd;
import Listas.ListaSEIni;

public class Movil implements Comparable<Movil> {

	private String  id; 
	
	public enum Estado {

		DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_LLAMADO

	};
	
	private Estado estado;
	
	public ListaOrd choferes;
	private ListaSEIni llamados;
	private Zona ubicacion;
	
	public Movil(String id, Zona ubicacion){
		this.id = id;
		this.estado = Estado.DISPONIBLE;
		this.llamados = new ListaSEIni();
		this.ubicacion = ubicacion;
	}
	
	@Override
	public int compareTo(Movil other){
		return id.compareTo(other.getId());
	}
	
	public void recibirLlamado(Zona zona){
		this.llamados.agregarFinal(zona);
	}
	
	
	public Chofer buscarChofer(String cedula){
		for (Object o: choferes){
			Chofer c = (Chofer) o;
			if (c.getCedula().equals(cedula)){
				return c;
			}
		}
		return null;
	}		
	
	public void printInforme(){
		if (!this.choferes.esVacia()){
			for (Object o : this.choferes){
				System.out.println("Nombre: " + ((Chofer) o).getNombre() + ", Cédula:" + ((Chofer)o).getCedula());
			}
		}
		else System.out.println("No posee choferes habilitados");
	}
	
	@Override
	public String toString(){
		String sUbicacion = this.ubicacion.getNombre();
		String ret = this.id + "-" + this.estado.toString();
		if (!this.estado.equals(Estado.ATENDIENDO_LLAMADO)) return ret + "-" + sUbicacion;
		return ret;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public ListaSEIni getLlamados(){
		return this.llamados;
	}
	
	public void setEstado(Estado estado){
		this.estado = estado;
	}
	
	public Estado getEstado(){
		return this.estado;
	}
	
	public void setUbicacion(Zona ubicacion){
		this.ubicacion = ubicacion;
	}
	
	public Zona getUbicacion(){
		return this.ubicacion;
	}
	
//	public void setChoferes(ListaOrd choferes){
//		this.choferes = choferes;
//	}
//	
//	public ListaOrd getChoferes(){
//		return this.choferes;
//	}
}
