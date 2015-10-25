package Dominio;

import Listas.ILista;
import Listas.ListaOrd;
import Listas.MovilComparator;

public class Movil {

	int id; // los id los hacemos int?
	static int ultID;
	
	public enum Estado {

		DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_LLAMADO

	};
	
	Estado estado;
	
	ILista choferes;
	ListaOrd llamados = new ListaOrd(new MovilComparator());
	
	public Movil(){
		this.id = Movil.ultID + 1;
		this.estado = Estado.DISPONIBLE;
	}
	
	public int compareTo(Movil other){
		return Integer.compare(id, other.getId());
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
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
