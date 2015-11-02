package Dominio;

import Listas.ListaOrd;
import Listas.ListaSEIni;

public class Zona {

	private int id;
	private String nombre;
	private ListaOrd esOrigenDeRutas;
	private ListaOrd moviles;
	
	public void informeMovil(){
		System.out.println("Informe de móviles en: " + this.id + "-" + this.nombre);
		for (Object o : moviles){
			Movil m = (Movil) o;
			System.out.println(m.getId());
		}
	}
	
	public Ruta buscarRutaHastaX(int zDestino){
		
		for (Object o: esOrigenDeRutas){
			Ruta r = (Ruta) o;
			if (r.getDestino().getId() == zDestino) return r;
		}
		return null;
	}
	
	public Object[] movilMasCercana(){
		Movil oMovil = null;
		int menorTiempo = Integer.MAX_VALUE;
		for (Object oRuta : this.esOrigenDeRutas){
			Ruta r = (Ruta) oRuta;
			// SI LA ZONA DE DESTINO TIENE MOVILES
			if (!r.getDestino().moviles.esVacia()){
				// ME QUEDO CON LA RUTA DE MENOR TIEMPO Y EL PRIMER MOVIL QUE SAQUE DE LA ZONA DE DESTINO DE ESA RUTA
				if (menorTiempo > r.getMinutosViaje()) {
					menorTiempo = r.getMinutosViaje();
					oMovil = (Movil)r.getDestino().moviles.devolverPrimero(); // aca lo cambié	 
				}
			}
		}
		Object[] result = {oMovil, menorTiempo};
		return result;
	}
	
	public void informeZona(){
		System.out.println("Informe zona: " + this.id);
		
		for (Object o : this.esOrigenDeRutas){
			System.out.println("Ruta directa a " + ((Ruta) o).getDestino().getId() + ", minutos" + ((Ruta)o).getMinutosViaje());
		}
		
		int movDisp = 0;
		int movNOdisp = 0;
		for (Object o: this.moviles){
			if (((Movil) o).estado.equals(Movil.Estado.NO_DISPONIBLE)) movNOdisp ++;
			else movDisp ++;
		}
		System.out.println("Móvils disponibles: " + movDisp);
		System.out.println("Móvils no disponibles: " + movNOdisp);
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
	
	public int getId(){
		return this.id;
	}
	
	public ListaOrd getMoviles(){
		return this.moviles;
	}
	
	public ListaOrd getEsOrigenDeRutas(){
		return this.esOrigenDeRutas;
	}
}
