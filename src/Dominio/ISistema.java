package Dominio;

public interface ISistema {

	public enum TipoRet {

		OK, NO_IMPLEMENTADA, ERROR1, ERROR2, ERROR3

	};

	public TipoRet crearSistemaSeguridad(int cantZonas);

	public TipoRet destruirSistemaSeguridad();

	public TipoRet registrarMovil(String movilID, int zonaID);

	public TipoRet deshabilitarMovil(String movilID);

	public TipoRet habilitarMovil(String movilID);

	public TipoRet eliminarMovil(String movilID);

	public TipoRet buscarMovil(String movilId);

	public TipoRet informeMovil();

	public TipoRet informeMovil(int zonaID); // informe por zona

	public Movil buscarMovilReturnIt(String movilID);
	
	public TipoRet recibirLlamado(String movilID, int zonaID);

	public TipoRet cambiarUbicacion(String movilID, int zonaID);

	public TipoRet agregarZona(String zonaNombre);

	public TipoRet listarZonas();
	
	public Zona buscarZona(int idZona);

	public TipoRet agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje);

	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje);

	public TipoRet movilMasCercana(int zonaID);

	public TipoRet rutaMasRapida(int zonaOrigen, int zonaDestino);

	public TipoRet informeZonas();

	public TipoRet zonasEnRadio(int zonaID, int duracionViaje);

	public TipoRet registrarChofer(String movilId, String nombre, String cedula);

	public TipoRet eliminarChofer(String movilId, String cedula);

	public TipoRet informeChoferes(String movilId);

	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID);

	public TipoRet eliminarAbonado(int abonadoId);

	public TipoRet informeAbonadosZona(int zonaID);

}