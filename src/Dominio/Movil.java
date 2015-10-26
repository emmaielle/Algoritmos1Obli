package Dominio;

import Listas.ILista;
import Listas.ListaOrd;
import Listas.MovilComparator;

public class Movil {

	private String  id; 
	private static int ultID;
	
	public enum Estado {

		DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_LLAMADO

	};
	
	Estado estado;
	
	ILista choferes;
	ListaOrd llamados = new ListaOrd(new MovilComparator());
	
	public Movil(String id){
		this.id = id;
		this.estado = Estado.DISPONIBLE;
	}
	
	public int compareTo(Movil other){
		return id.compareTo(other.getId());
	}
	
	public void recibirLlamado(Zona zona){
		this.llamados.agregarFinal(zona);
	}
	
	// si disponible o no_disponible, --> cuando atienda un nuevo llamado, se le elimina el ultimo llamado que atendió, que es el 
	// que da la información de la zona en la que se encuentra
	// PRE: La ubicación del móvil es igual al primer item de la lista de llamados que posee, que es el que 
	@Override
	public String toString(){
		// el primero es el ultimo que atendió y por ende donde está ahora (todavia no se elimino hasta que atienda uno nuevo)
		Zona oUbicacion = (Zona) this.llamados.devolverPrimero();
		String sUbicacion = oUbicacion.getNombre();
		
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
}
