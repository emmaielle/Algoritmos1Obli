package Dominio;

public interface ISistema {

	public enum TipoRet {

		OK, NO_IMPLEMENTADA, ERROR1, ERROR2, ERROR3

	};

	public TipoRet crearSistemaSeguridad(int cantZonas);

	// PRE: No hay precondiciones.
	// POS: Se vacían las listas de la clase Sistema y se establece la cantidad de zonas cantZonas como 0
	public TipoRet destruirSistemaSeguridad();

	// PRE: No hay precondiciones.
	// POS: "Crea un nuevo móvil con identificador movilId, estado disponible y lo asigna a la zona zonaID"
	public TipoRet registrarMovil(String movilID, int zonaID);

	// PRE:
	// POS:
	public TipoRet deshabilitarMovil(String movilID);

	// PRE:
	// POS:	
	public TipoRet habilitarMovil(String movilID);

	// PRE: 
	// POS: "Destruye el móvil movilId y todos sus elementos y referencias liberando la memoria utilizada"
	public TipoRet eliminarMovil(String movilID);

	// PRE:
	// POS:
	public TipoRet buscarMovil(String movilId);

	// PRE:
	// POS:
	public TipoRet informeMovil();

	// PRE:
	// POS:
	public TipoRet informeMovil(int zonaID); 

	// PRE:
	// POS:
	public TipoRet recibirLlamado(String movilID, int zonaID);

	// PRE:
	// POS:
	public TipoRet cambiarUbicacion(String movilID, int zonaID);

	// PRE:
	// POS:
	public TipoRet agregarZona(String zonaNombre);

	// PRE:
	// POS:
	public TipoRet listarZonas();
	
	// PRE:
	// POS:
	public TipoRet agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje);

	// PRE: Se asume que ya existe una ruta con origen = zonaOrigen y destino = zonaDestino, la cual ya fue ingresada en la lista
	// de rutas de zonaOrigen
	// POS: Se modifica minutosViaje para la ruta solicitada
	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje);

	// PRE:
	// POS:
	public TipoRet movilMasCercana(int zonaID);

	// PRE:
	// POS:
	public TipoRet rutaMasRapida(int zonaOrigen, int zonaDestino);

	// PRE:
	// POS:
	public TipoRet informeZonas();

	// PRE:
	// POS:
	public TipoRet zonasEnRadio(int zonaID, int duracionViaje);

	// PRE:
	// POS:
	public TipoRet registrarChofer(String movilId, String nombre, String cedula);

	// PRE: El chofer de movilId con cédula = cedula existe en el sistema y está asignado al movil
	// POS: 
	public TipoRet eliminarChofer(String movilId, String cedula);

	// PRE:
	// POS:
	public TipoRet informeChoferes(String movilId);

	// PRE:
	// POS:
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID);

	// PRE:
	// POS:
	public TipoRet eliminarAbonado(int abonadoId);

	// PRE:
	// POS:
	public TipoRet informeAbonadosZona(int zonaID);

}