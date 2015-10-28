package Dominio;

import Listas.ILista;
import Listas.ListaOrd;

public class Zona {

	private int id;
	private String nombre;
	private ILista esOrigenDeRutas;
	private ListaOrd moviles;
	
	public boolean tieneIdX(int idZona){
		
		return this.id == idZona;
	}
	
	public boolean informeMovil(){
		System.out.println("Informe de móviles en: " + this.id + "-" + this.nombre);
		for (Object o : moviles){
			Movil m = (Movil) o;
			System.out.println(m.getId());
		}
		return true;
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
					oMovil = (Movil)r.getOrigen().moviles.devolverPrimero();
				}
			}
		}
		Object[] result = {oMovil, menorTiempo};
		return result;
	}
	
//	//REcursivo REVISAR	PUEDE QUE SEA UNA MIERDA
//	// PRE: Ya sé que ne esta zona no hay ningún móvil actualmente
//	// POS: Devuelve los moviles mas cercanos a esta zona en base a las rutas a las que pertenece
//	public Object[] movilMasCercana(){
//		// SIN UN MOVIL INICIAL, Y CON UNA DURACION MAXIMA
//		Object[] inicio = {null, Integer.MAX_VALUE};
//		return movilMasCercana(inicio);
//	}
//	
//	public Object[] movilMasCercana(Object[] obj){
//		int duracion = (int)obj[1]; // INICIALMENTE, ES EL VALOR MAXIMO; RECURSIVO ES LO QUE VA DEMORANDO CADA RUTA
//		Movil oMovil = (Movil)obj[0]; // SIEMPRE QUE LLAMO AL METODO ES PORQUE TODAVIA ES NULL
//		Object[] result = new Object[2]; // RETURN VALUE
//		//CASO base
//		int menorTiempo = Integer.MAX_VALUE;
//		for (Object oRuta : this.esOrigenDeRutas){
//			Ruta r = (Ruta) oRuta;
//			// SI LA ZONA DE DESTINO TIENE MOVILES
//			if (!r.getDestino().moviles.esVacia()){
//				// ME QUEDO CON LA RUTA DE MENOR TIEMPO Y EL PRIMER MOVIL QUE SAQUE DE LA ZONA DE DESTINO DE ESA RUTA
//				if (menorTiempo > r.getMinutosViaje()) {
//					menorTiempo = r.getMinutosViaje();
//					oMovil = (Movil)r.getOrigen().moviles.devolverPrimero();
//				}
//			}
//		}
//		if (menorTiempo != Integer.MAX_VALUE)
//		duracion += menorTiempo; // lo cual significa que encontro destino de ruta con movil, o sino no le suma
//		
//		//recursiva
//		// si todavia no encontro un movil:
//		if (oMovil == null){
//			int duracionAux = Integer.MAX_VALUE;
//			Object[] auxArray = new Object[2];
//			for (Object oRuta : this.esOrigenDeRutas){
//				Ruta r = (Ruta)oRuta;
//				auxArray[0] = null;
//				auxArray[1] = duracion; // la duracion que lleva hasta ahora, que en este caso es la duracion que trajo la ultima llamada del metodo
//				// PAA CADA RUTA CALCULA EL TIEMPO Y SI ENCUENTRA MOVIL
//				Object[] recursiva = r.getDestino().movilMasCercana(auxArray);
//				// ME QUEDO CON LA RUTA DE MENOR TIEMPO, SIN IMPORTAR SI ENCONTRO MOVIL
//				if (duracionAux > (int)recursiva[1]){
//					duracionAux = (int)recursiva[1];
//					oMovil = (Movil)recursiva[0];
//				}
//	
//			}
//			duracion += duracionAux;
//
//		}
//		
//		result[0] = oMovil;
//		result[1] = duracion;
//		return result;
//	}
	
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
}
