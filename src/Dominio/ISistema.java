package Dominio;

public interface ISistema {

	public enum TipoRet {

		OK, NO_IMPLEMENTADA, ERROR1, ERROR2, ERROR3

	};

	public TipoRet crearSistemaSeguridad(int cantZonas);

	// PRE: No hay precondiciones.
	// POS: Se vac�an las listas de la clase Sistema y se establece la cantidad de zonas cantZonas como 0
	public TipoRet destruirSistemaSeguridad();

	// PRE: No hay precondiciones.
	// POS: "Crea un nuevo m�vil con identificador movilId, estado disponible y lo asigna a la zona zonaID"
	public TipoRet registrarMovil(String movilID, int zonaID);

	// PRE:
	// POS:
	public TipoRet deshabilitarMovil(String movilID);

	// PRE:
	// POS:	
	public TipoRet habilitarMovil(String movilID);

	// PRE: No hay precondiciones?
	// POS: "Destruye el m�vil movilId y todos sus elementos y referencias liberando la memoria utilizada"
	public TipoRet eliminarMovil(String movilID);

	// PRE:
	// POS:
	public TipoRet buscarMovil(String movilId);

	// PRE: No hay precondiciones?
	// POS: Imprime los m�viles ordenados seg�n movilId, su estado y la zona donde se encuentra. 
	public TipoRet informeMovil();

	// PRE: Se asume que zonaID es un id v�lido de una zona existente
	// POS: Imprime todos los m�viles disponibles que se encuentran en la zona zonaID (ordenados por movilId de forma ascendente)
	public TipoRet informeMovil(int zonaID); 

	// PRE:	ZonaID tiene que ser contigua a la zona actual en la que est� el movil y diferente a la zona actual. El m�vil se asume que
	// esta en estado disponible siempre que se llama el m�todo
	// POS: Se agendar�n llamados al m�vil dejando �ltimos los m�s recientes.
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
	// POS: Se modifica minutosViaje para la ruta solicitada y su ruta complementaria
	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje);

	// PRE: No tiene precondiciones? 
	// POS: Muestra los datos del m�vil m�s cercano a la zona zonaID y el tiempo que demora en llegar. Si hay alg�n m�vil en la zona zonaID 
	// el tiempo de demora ser� 0. S�lo busca en las zonas inmediatamente contiguas a zonaID, como hablado en clase
	public TipoRet movilMasCercana(int zonaID);

	// PRE: No tiene precondiciones? 
	// POS: Muestra la ruta m�s r�pida para ir desde zona zonaOrigen a zona zonaDestino. Despliega las zonas intermedias 
	// y el tiempo estimado de cada tramo y el viaje completo (limitar a 2 tramos)???.
	public TipoRet rutaMasRapida(int zonaOrigen, int zonaDestino);

	// PRE: Se asume que la lista de zonas tiene al menos un elemento
	// POS: Imprime todas las zonas detallando las zonas con las que tiene ruta directa y la demora del viaje. Tambi�n 
	//detalla la cantidad de m�viles seg�n su estado que se encuentran cada	zona.
	public TipoRet informeZonas();

	// PRE:
	// POS:
	public TipoRet zonasEnRadio(int zonaID, int duracionViaje);

	// PRE:
	// POS:
	public TipoRet registrarChofer(String movilId, String nombre, String cedula);

	// PRE: El chofer de movilId con c�dula = cedula existe en el sistema y est� asignado al movil
	// POS: 
	public TipoRet eliminarChofer(String movilId, String cedula);

	// PRE: No tiene precondiciones?
	// POS: Imprime un informe con todos los choferes habilitados para conducir el m�vil movilId.
	public TipoRet informeChoferes(String movilId);

	// PRE: No tiene precondiciones?
	// POS: Crea un nuevo abonado con identificador abonadoID, abonadoNombre, abonadoDireccion, abonadoTel y lo asigna a la zona zonaID
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID);

	// PRE:
	// POS: 
	public TipoRet eliminarAbonado(int abonadoId);

	// PRE: No tiene precondiciones?
	// POS: Imprime por pantalla todos los abonados que se encuentran en la zona zonaID (ordenados por abonadoNombre de forma ascendente)
	public TipoRet informeAbonadosZona(int zonaID);

}