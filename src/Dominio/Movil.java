package Dominio;

import Listas.ListaOrd;
import Listas.ListaSEIni;
import Listas.MovilComparator;

public class Movil implements Comparable<Movil> {

	private String  id; 
	
	public enum Estado {

		DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_LLAMADO

	};
	
	Estado estado;
	
	ListaSEIni choferes;
	ListaOrd llamados;
	
	public Movil(String id){
		this.id = id;
		this.estado = Estado.DISPONIBLE;
		this.llamados = new ListaOrd(new MovilComparator());
	}
	
	@Override
	public int compareTo(Movil other){
		return id.compareTo(other.getId());
	}
	
	public void recibirLlamado(Zona zona){
		this.llamados.agregarFinal(zona);
	}
	
	public void printInforme(){
		if (!this.choferes.esVacia()){
			for (Object o : this.choferes){
				System.out.println("Nombre: " + ((Chofer) o).getNombre() + ", Cédula:" + ((Chofer)o).getCedula());
			}
		}
		else System.out.println("No posee choferes habilitados");
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
