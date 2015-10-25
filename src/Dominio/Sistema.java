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
		if (!this.buscarZona(zonaID)) return TipoRet.ERROR1;
		if (buscarMovil(movilID).equals(TipoRet.OK)) return TipoRet.ERROR2;
		
		Movil mov = new Movil();
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
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet recibirLlamado(String movilID, int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
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
	public boolean buscarZona(int idZona){
		for (Object o : zonas) {
			Zona z = (Zona) o;
			if (z.tieneIdX(idZona)) return true;
		}
		return false;
	}

	@Override
	public TipoRet agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet movilMasCercana(int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet rutaMasRapida(int zonaOrigen, int zonaDestino) {
		return TipoRet.NO_IMPLEMENTADA;
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
