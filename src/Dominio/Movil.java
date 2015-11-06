package Dominio;

import Listas.ListaOrd;
import Listas.MovilComparator;

public class Movil implements Comparable<Movil> {

	private String  id; 
	
	public enum Estado {

		DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_LLAMADO

	};
	
	private Estado estado;
	
	public ListaOrd choferes;
	private ListaOrd llamados;
	private Zona ubicacion;
	
	public Movil(String id, Zona ubicacion){
		this.id = id;
		this.estado = Estado.DISPONIBLE;
		this.llamados = new ListaOrd(new MovilComparator());
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
				System.out.println("Nombre: " + ((Chofer) o).getNombre() + ", C�dula:" + ((Chofer)o).getCedula());
			}
		}
		else System.out.println("No posee choferes habilitados");
	}
	
	// si disponible o no_disponible, --> cuando atienda un nuevo llamado, se le elimina el ultimo llamado que atendi�, que es el 
	// que da la informaci�n de la zona en la que se encuentra
	// PRE: La ubicaci�n del m�vil es igual al primer item de la lista de llamados que posee, que es el que 
	@Override
	public String toString(){
		// el primero es el ultimo que atendi� y por ende donde est� ahora (todavia no se elimino hasta que atienda uno nuevo)
		Zona oUbicacion = (Zona) this.ubicacion;
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
	
	public ListaOrd getLlamados(){
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
