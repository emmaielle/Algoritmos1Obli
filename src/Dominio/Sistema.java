package Dominio;


import Dominio.Movil.Estado;
import Listas.AbonadoComparator;
import Listas.ListaOrd;
import Listas.ListaSEIni;

public class Sistema implements ISistema {

	ListaSEIni zonas;
	ListaOrd moviles;
	int cantZonas;
	ListaSEIni abonados;

	@Override
	public TipoRet crearSistemaSeguridad(int cantZonas) {
		//New de listas, inicialización de cantZonas
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet destruirSistemaSeguridad() {
		zonas.vaciar();
		moviles.vaciar();
		abonados.vaciar();
		cantZonas = 0;
		return TipoRet.OK;
	}

	@Override
	public TipoRet registrarMovil(String movilID, int zonaID) {
		if (this.buscarZona(zonaID) == null) return TipoRet.ERROR1;
		if (buscarMovil(movilID).equals(TipoRet.OK)) return TipoRet.ERROR2;
		
		Movil mov = new Movil(movilID);
		moviles.insertar((Object) mov);
		return TipoRet.OK;
	}

	@Override
	public TipoRet deshabilitarMovil(String movilID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet habilitarMovil(String movilID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet eliminarMovil(String movilID) {
		Movil mov = this.buscarMovilReturnIt(movilID); 
		if (mov != null){
			if (mov.estado.equals(Estado.NO_DISPONIBLE)) return TipoRet.ERROR2;
		
			moviles.borrarElemento(mov);
			return TipoRet.OK;
		}
		else return TipoRet.ERROR1;
	}

	@Override
	public TipoRet buscarMovil(String movilId) {
		
		// metodo que realmente lo busca y devielve el objeto, y este metodo lo llama y hace el syso y el return del tipo
		// metodo buscarMovilReturnIt(String movilId)
		return TipoRet.NO_IMPLEMENTADA;
	}

	public Movil buscarMovilReturnIt(String movilID){
		return null;
	}
	
	@Override
	public TipoRet informeMovil() {
		for (Object o : moviles){
			Movil m = (Movil) o;
			System.out.println(m.toString());
		}
		return TipoRet.OK;
	}

	@Override
	public TipoRet informeMovil(int zonaID) {
		Zona z = this.buscarZona(zonaID);
		
		if (z  == null) return TipoRet.NO_IMPLEMENTADA;
		z.informeMovil();
		return TipoRet.OK;
		
	}

	//PRE: ZonaID tiene que se contigua a la zona actual en la que está el movil y diferente a la zona actual
	@Override
	public TipoRet recibirLlamado(String movilID, int zonaID) {
		Movil m = this.buscarMovilReturnIt(movilID);
		
		Zona z = this.buscarZona(zonaID); 
		if (z != null){
			if (m != null){
				if (m.estado.equals(Estado.DISPONIBLE)){
					m.recibirLlamado(z);
					return TipoRet.OK;
				}
				else return TipoRet.ERROR3; // este error no está en la letra del obligatorio, pero deberia estar....
			}
			else return TipoRet.ERROR2;
		}
		else return TipoRet.ERROR1;
		
	}

	@Override
	public TipoRet cambiarUbicacion(String movilID, int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet agregarZona(String zonaNombre) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet listarZonas() {
		return TipoRet.NO_IMPLEMENTADA;
	}
	
	public Zona buscarZona(int idZona){
		for (Object o : zonas) {
			Zona z = (Zona) o;
			if (z.getId() == idZona) return z;
		}
		return null;
	}

	@Override
	public TipoRet agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
		Zona zOrigen = this.buscarZona(zonaOrigen);
		if (zOrigen != null){
			Zona zDestino = this.buscarZona(zonaDestino);
			if(zDestino != null){
				if (minutosViaje > 0){
					// buscar ruta con ese origen y destino, devolverla y modificarla
					Ruta r = zOrigen.buscarRutaHastaX(zonaDestino);
					r.setMinutosViaje(minutosViaje);
					
					// hace la recíproca
					Ruta rut = zDestino.buscarRutaHastaX(zonaDestino);
					rut.setMinutosViaje(minutosViaje);
					return TipoRet.OK;
				}
				else return TipoRet.ERROR3;
			}
			else return TipoRet.ERROR2;
		}
		else return TipoRet.ERROR1;
	}

	// si hay más de un móvil en la zona, devuelve el primero que tome 
	@Override
	public TipoRet movilMasCercana(int zonaID) {
		Zona z = this.buscarZona(zonaID);
		if (z == null) return TipoRet.ERROR1;
		
		int tiempo;
		String sMovil;
		if (!moviles.esVacia()){
			ListaOrd movs = z.getMoviles();
			if (!movs.esVacia()) {
				tiempo = 0;
				Movil m = (Movil) movs.devolverPrimero(); //asegurar que se pueda sacar el primero alfabeticamente
				sMovil = m.getId();
			}
			else {
				Object[] movil = z.movilMasCercana();
				sMovil = movil[0].toString();
				tiempo = (int)movil[1];
			}
		}
		else {
			sMovil = null;
			tiempo = -1; // unnecessary
		}
		
		System.out.println("Móvil más cercana a" + zonaID + "-" + z.getNombre());
		
		if (sMovil != null){
			System.out.println("Móvil: "+ sMovil);
			System.out.println("Demora del viaje: " + String.valueOf(tiempo));
		}
		else {
			System.out.println("No hay móviles creadas.");
		}
		return TipoRet.OK;
	}

	@Override
	public TipoRet rutaMasRapida(int zonaOrigen, int zonaDestino) {
		Zona zOrigen = this.buscarZona(zonaOrigen);
		if (zOrigen != null){
			Zona zDestino = this.buscarZona(zonaDestino);
			if (zDestino != null){
				//----------
				System.out.println("Ruta más rápida:");
				this.rutaMasRapidaREC(zOrigen, zonaDestino, 0);
				
				//----------
				return TipoRet.OK;
			}
			else return TipoRet.ERROR2;
		}
		else return TipoRet.ERROR1;
	}
	
	// destino se mantiene
	public void rutaMasRapidaREC(Zona zOrigen, int zDestino, int tiempoAcumulado){ //rutaMasRapidaREC(prado, cordon, 5)
		// cuando empieza 
		if (tiempoAcumulado == 0) {
			System.out.println(zOrigen.getNombre() + " - 0");
		}
		// no else
		if (zOrigen.getId() != zDestino){
			int t = Integer.MAX_VALUE; Zona z = null;
			for (Object o : zOrigen.getEsOrigenDeRutas()){
				Ruta ruta = (Ruta) o;
				Zona zAux = ruta.getDestino();
				if (ruta.getMinutosViaje() < t && zAux.getId() != zOrigen.getId()){ // la 2da condicion está mal, no hace lo que necesito
					t = tiempoAcumulado + ruta.getMinutosViaje();
					z = zAux;
				}
			}
			System.out.println(z.getNombre() + " - " + t);
			rutaMasRapidaREC(z, zDestino, t);
		}
	}

	@Override
	public TipoRet informeZonas() {
		for (Object o : this.zonas){
			Zona zona = (Zona) o;
			zona.informeZona();
		}
		return TipoRet.OK;
	}

	@Override
	public TipoRet zonasEnRadio(int zonaID, int duracionViaje) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet registrarChofer(String movilId, String nombre, String cedula) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet eliminarChofer(String movilId, String cedula) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet informeChoferes(String movilId) {
		Movil mov = this.buscarMovilReturnIt(movilId);
		if (mov != null){
			System.out.println("Informe Choferes de " + movilId);
			
			mov.printInforme();
			
			return TipoRet.OK;
		}
		else return TipoRet.ERROR1;
	}

	@Override
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
		Zona zona = this.buscarZona(zonaID);
		if (zona != null){
			if (buscarAbonado(abonadoID) == null){
				Abonado ab = new Abonado(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel, zona);
				if (this.abonados == null) this.abonados = new ListaSEIni();
				this.abonados.insertar(ab);
				return TipoRet.OK;
			}
			else return TipoRet.ERROR2;
		}
		else return TipoRet.ERROR1;
		
	}
	
	public Abonado buscarAbonado(int idAbonado){
		for (Object o : this.abonados){
			if (((Abonado)o).getId() == idAbonado) return (Abonado) o;
		}
		return null;
	}

	@Override
	public TipoRet eliminarAbonado(int abonadoId) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet informeAbonadosZona(int zonaID) {
		
		Zona zona = this.buscarZona(zonaID);
		if (zona != null){
			System.out.println("Informe de abonados en: " + zonaID + " - " + zona.getNombre());
			
			// con hacer esto nomas queda ordenado???
			ListaOrd abonadosPorZona = new ListaOrd(new AbonadoComparator()); 
			for (Object o: this.abonados){
				if (((Abonado)o).getZona().getId() == zonaID) abonadosPorZona.insertar((Abonado)o);
			}
			
			if (!abonadosPorZona.esVacia()){
				for (Object o : abonadosPorZona){
					System.out.println(((Abonado)o).getNombre() + " - " + ((Abonado)o).getTelefono());
				}
			}
			else System.out.println("No hay abonados en la zona.");
			
			return TipoRet.OK;
		}
		else return TipoRet.ERROR1;
	}
	
}
