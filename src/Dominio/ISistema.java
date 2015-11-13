package Dominio;

public interface ISistema {

	public enum TipoRet {

		OK, NO_IMPLEMENTADA, ERROR1, ERROR2, ERROR3

	};

	// PRE: No hay precondiciones.
	// POS: Se inicializan las listas que contiene Sistema y se asigna la cantidad de zonas que contendr� el sistema
	public TipoRet crearSistemaSeguridad(int cantZonas);

	// PRE: No hay precondiciones.
	// POS: Se vac�an las listas de la clase Sistema y se establece la cantidad de zonas cantZonas como 0
	public TipoRet destruirSistemaSeguridad();

	// PRE: No hay precondiciones.
	// POS: Crea un nuevo m�vil con identificador movilId, estado disponible y lo asigna a la zona zonaID
	public TipoRet registrarMovil(String movilID, int zonaID);

	// PRE: No hay precondiciones.
	// POS: Cambia el estado del movil movilID a NO_DISPONIBLE de forma que no pueda ser asignado a un viaje.
	public TipoRet deshabilitarMovil(String movilID);

	// PRE: No hay precondiciones.
	// POS: Cambia el estado del movil movilID a DISPONIBLE para estar nuevamente operativo
	public TipoRet habilitarMovil(String movilID);

	// PRE: No hay precondiciones?
	// POS: Destruye el m�vil movilId y todos sus elementos y referencias liberando la memoria utilizada
	public TipoRet eliminarMovil(String movilID);

	// PRE: No hay precondiciones?
	// POS: Imprime por pantalla los datos de un m�vil movilId en pantalla.
	public TipoRet buscarMovil(String movilId);

	// PRE: No hay precondiciones?
	// POS: Imprime los m�viles ordenados seg�n movilId, su estado y la zona donde se encuentra. 
	public TipoRet informeMovil();

	// PRE: No hay precondiciones? // opcion B: que la lista moviles tiene al menos un movil, aunque ya est� considerado en el codigo
	// POS: Imprime todos los m�viles disponibles que se encuentran en la zona zonaID (ordenados por movilId de forma ascendente)
	public TipoRet informeMovil(int zonaID); 
	
	// PRE:	ZonaID tiene que ser contigua a la zona actual en la que est� el movil y diferente a la zona actual. El m�vil se asume que
	// esta en estado disponible siempre que se llama el m�todo
	// POS: Se agendar�n llamados al m�vil dejando �ltimos los m�s recientes.
	public TipoRet recibirLlamado(String movilID, int zonaID);

	// PRE: La lista llamados tiene al menos un elemento
	// POS: cambia la ubicaci�n del m�vil asign�ndolo a la zona zonaID, lo quita de la zona donde se encontraba y quita la zona de la lista de llamados del movil
	public TipoRet cambiarUbicacion(String movilID, int zonaID);

	// PRE: zonaNombre no ha sido utilizada previamente.
	// POS: Crea la zona y le asigna un identificador �nico (el menor valor libre no asignado a otra zona) entre 1 y cantZonas.
	public TipoRet agregarZona(String zonaNombre);

	// PRE: No hay precondiciones
	// POS: Imprime en pantalla las zonas ordenadas de forma ascendente por zonaID.
	public TipoRet listarZonas();
	
	// PRE: No hay precondiciones
	// POS: Ingresa la ruta desde zonaOrigen a zonaDestino con demora minutosViaje, y su rec�proca. 
	public TipoRet agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje);

	// PRE: Se asume que ya existe una ruta con origen = zonaOrigen y destino = zonaDestino, la cual ya fue ingresada en la lista
	// de rutas de zonaOrigen
	// POS: Se modifica minutosViaje para la ruta solicitada y su ruta complementaria
	public TipoRet modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje);

	// PRE: No tiene precondiciones? 
	// POS: Muestra los datos del m�vil m�s cercano a la zona zonaID y el tiempo que demora en llegar. Si hay alg�n m�vil en la zona zonaID 
	// el tiempo de demora ser� 0. S�lo busca en las zonas inmediatamente contiguas a zonaID, como se habl� en clase
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
	// POS: Imprime por pantalla todas las zonas que se encuentran a duracionViaje minutos o menos de la zona zonaID.
	public TipoRet zonasEnRadio(int zonaID, int duracionViaje);

	// PRE: No existe un chofer de c�dula cedula como chofer habilitado para conducir el m�vil movilId
	// POS: Registra al chofer de nombre nombre y c�dula c�dula como chofer habilitado para conducir el m�vil movilId.
	public TipoRet registrarChofer(String movilId, String nombre, String cedula);

	// PRE: El chofer de movilId con c�dula = cedula existe en el sistema y est� asignado al movil
	// POS: Elimina al chofer de c�dula cedula como chofer habilitado para conducir el m�vil movilId.
	public TipoRet eliminarChofer(String movilId, String cedula);

	// PRE: No tiene precondiciones?
	// POS: Imprime un informe con todos los choferes habilitados para conducir el m�vil movilId.
	public TipoRet informeChoferes(String movilId);

	// PRE: No tiene precondiciones?
	// POS: Crea un nuevo abonado con identificador abonadoID, abonadoNombre, abonadoDireccion, abonadoTel y lo asigna a la zona zonaID
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID);

	// PRE: No tiene precondiciones?
	// POS: Elimina un abonado con identificador abonadoID.
	public TipoRet eliminarAbonado(int abonadoId);

	// PRE: No tiene precondiciones?
	// POS: Imprime por pantalla todos los abonados que se encuentran en la zona zonaID (ordenados por abonadoNombre de forma ascendente)
	public TipoRet informeAbonadosZona(int zonaID);

}