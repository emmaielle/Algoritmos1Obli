package Dominio;


import Dominio.Movil.Estado;
import Listas.ListaOrd;
import Listas.ListaSEIni;
import Listas.MovilComparator;

public class Sistema implements ISistema {

	ListaSEIni zonas;
	ListaOrd moviles = new ListaOrd(new MovilComparator());
	int cantZonas;

	@Override
	public TipoRet crearSistemaSeguridad(int cantZonas) {
		//New de listas, inicialización de cantZonas
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet destruirSistemaSeguridad() {
		zonas.vaciar();
		moviles.vaciar();
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

	@Override 
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
		System.out.println(z.informeMovil());
		return TipoRet.OK;
		
	}

	//PRE: ZonaID tiene que se contigua a la zona actual en la que está el movil y diferente a la zona actual
	@Override
	public TipoRet recibirLlamado(String movilID, int zonaID) {
		Movil m = this.buscarMovilReturnIt(movilID);
		if (m != null){
			Zona z = this.buscarZona(zonaID); 
			if (z != null){
				if (m.estado.equals(Estado.DISPONIBLE)){
					m.recibirLlamado(z);
					return TipoRet.OK;
				}
				else return TipoRet.ERROR3; // este error no está en la letra del obligatorio, pero deberia estar....
			}
			else return TipoRet.ERROR1;
		}
		else return TipoRet.ERROR2;
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
	
	@Override
	public Zona buscarZona(int idZona){
		for (Object o : zonas) {
			Zona z = (Zona) o;
			if (z.tieneIdX(idZona)) return z;
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
				Movil m = (Movil) movs.devolverPrimero();
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
				/// hacer busqueda aca
				return TipoRet.OK;
			}
			else return TipoRet.ERROR2;
		}
		else return TipoRet.ERROR1;
	}

	@Override
	public TipoRet informeZonas() {
		return TipoRet.NO_IMPLEMENTADA;
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
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet eliminarAbonado(int abonadoId) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet informeAbonadosZona(int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

}
