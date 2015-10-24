package Dominio;

public class Sistema implements ISistema {

	//Listas, cantZonas
	@Override
	public TipoRet crearSistemaSeguridad(int cantZonas) {
		//New de listas, inicialización de cantZonas
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet destruirSistemaSeguridad() {
		//Listas en null
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet registrarMovil(String movilID, int zonaID) {
		return TipoRet.NO_IMPLEMENTADA;
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
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet buscarMovil(String movilId) {
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet informeMovil() {
		return TipoRet.NO_IMPLEMENTADA;
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
