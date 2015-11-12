package Dominio;


import Dominio.Movil.Estado;
import Listas.AbonadoComparator;
import Listas.ILista;
import Listas.ListaOrd;
import Listas.ListaSEFin;
import Listas.ListaSEIni;
import Listas.MovilComparator;
import Listas.NodoLista;
import Listas.ZonaComparator;

public class Sistema implements ISistema {

	ListaOrd zonas;
	ListaOrd moviles;
	int cantZonas;
	ListaOrd abonados;

	@Override
	public TipoRet crearSistemaSeguridad(int cantZonas) {
		//New de listas, inicializacion de cantZonas
		if (cantZonas >= 1){
			zonas = new ListaOrd(new ZonaComparator());
			moviles = new ListaOrd(new MovilComparator());
			abonados = new ListaOrd(new AbonadoComparator());
			this.cantZonas = cantZonas;
			return TipoRet.OK;
		}
		else {
			System.out.println("La cantidad de zonas es inferior a 1.");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet destruirSistemaSeguridad() {
		// esto será asi, o con solo un "= null" ??? <--------- TODO
		zonas.vaciar();
		moviles.vaciar();
		abonados.vaciar();
		cantZonas = 0;
		return TipoRet.OK;
	}

	@Override
	public TipoRet registrarMovil(String movilID, int zonaID) {
		Zona zona = this.buscarZona(zonaID);
		
		if (zona == null) {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
		if (buscarMovil(movilID).equals(TipoRet.OK)) {
			System.out.println("Ya existe una móvil con identificador " + movilID +".");
			return TipoRet.ERROR2;
		}
		
		Movil mov = new Movil(movilID, zona);
		moviles.insertar(mov);
		zona.getMoviles().insertar(mov); // esto funciona? o es solo una referencia y no se puede hacer asi? <------ TODO
		return TipoRet.OK;
	}

	@Override
	public TipoRet deshabilitarMovil(String movilID) {
		Movil m = this.buscarMovilReturnIt(movilID);
		if (m == null) {
			System.out.println("No existe un movil con identificador " + movilID + ".");
			return TipoRet.ERROR1;
		}
		if (m.getEstado().equals(Estado.NO_DISPONIBLE)) {
			System.out.println("El móvil " + movilID + " ya está en estado NO_DISPONIBLE.");
			return TipoRet.ERROR2;
		}
		if (m.getEstado().equals(Estado.ATENDIENDO_LLAMADO)){
			System.out.println("No es posible deshabilitar el móvil " + movilID + ".");
			return TipoRet.ERROR3;
		}
		else {
			m.setEstado(Estado.NO_DISPONIBLE); 
			return TipoRet.OK;
		}		
	}

	@Override
	public TipoRet habilitarMovil(String movilID) {
		Movil m = this.buscarMovilReturnIt(movilID); // chequear que le cambie correctamente el estado cuando busco el movil desde una de las listas TODO
		if (m == null){
			System.out.println("No existe un móvil con identificador " + movilID + ".");
			return TipoRet.ERROR1;
		}
		if (m.getEstado().equals(Estado.DISPONIBLE)){
			System.out.println("El móvil " + movilID + " ya esta habilitado.");
			return TipoRet.ERROR2;
		}
		if (m.getEstado().equals(Estado.ATENDIENDO_LLAMADO)){
			System.out.println("Está en viaje, no es posible habilitar el móvil " + movilID + ", ya esta habilitado.");
			return TipoRet.ERROR3;
		}
		else {
			m.setEstado(Estado.DISPONIBLE);
			return TipoRet.OK;
		}
	}

	@Override
	public TipoRet eliminarMovil(String movilID) {
		Movil mov = this.buscarMovilReturnIt(movilID); 
		if (mov != null){
			if (mov.getEstado().equals(Estado.NO_DISPONIBLE) || mov.getEstado().equals(Estado.ATENDIENDO_LLAMADO)) {
				System.out.println("No es posible eliminar el móvil " + movilID + ", está en viaje");
				return TipoRet.ERROR2;
			}
			moviles.borrarElemento(mov);
			// toma la zona donde esta actualmente, y lo quita de su lista de moviles
			mov.getUbicacion().getMoviles().borrarElemento(mov);
			
			return TipoRet.OK;
		}
		else {
			System.out.println("No existe un móvil con identificador " + movilID + ".");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet buscarMovil(String movilId) {
		Movil m = this.buscarMovilReturnIt(movilId);
		if (m == null){
			System.out.println("No existe un móvil con identificador " + movilId + ".");
			return TipoRet.ERROR1;
		}
		else {
			System.out.println("Datos Movil:" + m.getId());
			System.out.println("Estado:" + m.getEstado());
			System.out.println("Zona:" + m.getUbicacion().getNombre());
			System.out.println("#Llamados:" + m.getLlamados().largo()); 
			return TipoRet.OK;
		}
	}

	// TODO refactor method name
	public Movil buscarMovilReturnIt(String movilID){
		for (Object o: moviles){
			Movil m = (Movil) o;
			if (m.getId().equals(movilID)) return m;
		}
		return null;
	}
	
	@Override
	public TipoRet informeMovil() {
		if (!this.moviles.esVacia()){
			System.out.println("Listado de móviles:");
			for (Object o : moviles){
				Movil m = (Movil) o;
				System.out.println(m.toString());
			}
		}
		else System.out.println("No se han registrado móviles"); 
		return TipoRet.OK;
	}

	@Override
	public TipoRet informeMovil(int zonaID) {
		Zona z = this.buscarZona(zonaID);
		if (z != null){
			z.informeMovil();
			return TipoRet.OK;
		}
		System.out.println("La zona " + zonaID + " no existe.");
		return TipoRet.ERROR1;
	}

	@Override
	public TipoRet recibirLlamado(String movilID, int zonaID) {
		Movil m = this.buscarMovilReturnIt(movilID);
		
		Zona z = this.buscarZona(zonaID); 
		if (z != null){
			if (m != null){
				m.recibirLlamado(z);
				return TipoRet.OK;
			}
			else {
				System.out.println("No existe un móvil con identificador " + movilID + ".");
				return TipoRet.ERROR2;
			}
		}
		else {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
		
	}

	@Override
	public TipoRet cambiarUbicacion(String movilID, int zonaID) {
		Movil m = this.buscarMovilReturnIt(movilID);
		Zona ubicacionPrevia = m.getUbicacion();
		Zona z = this.buscarZona(zonaID);
		
		Zona siguiente = (Zona)m.getLlamados().getInicio().getDato(); 
		if (z != null){
			// apparently, m can never be null... ???? TODO
			if (m != null){
				if (siguiente != z){
					System.out.println("La ubicacion no es la del proximo llamado.");
					return TipoRet.ERROR3;
				}
				else {	
					// cambia attr ubicacion del movil
					m.setUbicacion(z);
					// elimina al movil de la zona anterior
					ubicacionPrevia.getMoviles().borrarElemento(m);
					// elimina la zona de la pila de llamados (primer item)
					m.getLlamados().borrarInicio();
					return TipoRet.OK;
				}
			} 
			else {
				System.out.println("No existe un movil con identificador" + movilID + ".");
				return TipoRet.ERROR2;
			}
		} else {
			System.out.println("La zona" + zonaID + "no existe.");
			return TipoRet.ERROR1;
		}

	}
	
	@Override
	public TipoRet agregarZona(String zonaNombre) {
		if (this.cantZonas > zonas.largo()){
			Zona zona = new Zona(zonaNombre);
			this.zonas.insertar(zona);
			return TipoRet.OK;
		}
		else {
			System.out.println("No se pueden ingresar la zona "+ zonaNombre +" al sistema por no tener más capacidad.");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet listarZonas() {
		if (!this.zonas.esVacia()){
			System.out.println("Zonas en el mapa:");
			for (Object o : zonas){
				Zona z = (Zona) o;
				System.out.println(z.getId() +"-"+ z.getNombre());
			}	
		}				
		else System.out.println("No existen zonas en el mapa");
		return TipoRet.OK;
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
		Zona z = buscarZona(zonaOrigen);
		Zona z2 = buscarZona(zonaDestino);

		if (z != null){
			if (z2 != null){
				if (minutosViaje > 0){
					Ruta r = new Ruta(z, z2, minutosViaje);
					z.getEsOrigenDeRutas().insertar(r);
					Ruta inversa = new Ruta (z2, z, minutosViaje);
					z2.getEsOrigenDeRutas().insertar(inversa);
					
					return TipoRet.OK;
				}
				else {
					System.out.println("La duracion del viaje debe ser mayor que 0.");
					return TipoRet.ERROR3;
				}
			}
			else {
				System.out.println("La Zona " + zonaDestino + " no existe.");
				return TipoRet.ERROR2;
			}
		}
		else {
			System.out.println("La Zona " + zonaOrigen + " no existe.");
			return TipoRet.ERROR1;
		}
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
					Ruta rut = zDestino.buscarRutaHastaX(zonaOrigen);
					rut.setMinutosViaje(minutosViaje);
					return TipoRet.OK;
				}
				else {
					System.out.println("La duración del viaje debe ser mayor que 0.");
					return TipoRet.ERROR3;
				}
			}
			else {
				System.out.println("La zona "+ zonaDestino + " no existe.");
				return TipoRet.ERROR2;
			}
		}
		else {
			System.out.println("La zona "+ zonaOrigen + "no existe.");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet movilMasCercana(int zonaID) {
		Zona z = this.buscarZona(zonaID);
		if (z == null) {
			System.out.println("La zona "+ zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
		
		Object[] movil = null;
		int tiempo = 0;
		String sMovil;
		if (!moviles.esVacia()){
			ListaOrd movs = z.getMoviles();
			if (!movs.esVacia()) {
				Movil m = (Movil) movs.devolverPrimero(); 
				sMovil = m.getId();
			}
			else {
				movil = z.movilMasCercana();
				sMovil = movil[0].toString();
				tiempo = (int)movil[1];
			}
		}
		else sMovil = null;
		
		System.out.println("Móvil más cercana a" + zonaID + "-" + z.getNombre());
		
		if (movil != null){
			if (sMovil != null){
				System.out.println("Móvil: "+ sMovil);
				System.out.println("Demora del viaje: " + String.valueOf(tiempo));
			}
			else System.out.println("No hay móviles creadas.");
		}
		else {
			System.out.println("No hay móviles en zona " + zonaID + " ni en sus zonas contiguas");
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
				
				if (zonaOrigen == zonaDestino) System.out.println(zOrigen.getNombre() + " - 0");
				
				else {
					ILista ret = this.rutaMasRapidaREC(zonaOrigen, zonaDestino, new ListaSEIni());
					duracion(ret, true);		
					
				}
				
				//----------
				return TipoRet.OK;
			}
			else {
				System.out.println("La zona " + zonaDestino + " no existe.");
				return TipoRet.ERROR2;
			}
		}
		else {
			System.out.println("La zona "+ zonaOrigen + " no existe.");
			return TipoRet.ERROR1;
		}
		
	}
	
	// destino se mantiene
	public ILista rutaMasRapidaREC(int zOrigen, int zDestino, ILista caminoRecorrido){ 
		caminoRecorrido.insertar(zOrigen);
		if (zOrigen == zDestino) return caminoRecorrido;
		else {
			ILista mejorCamino = null;
			int mejorDuracion = Integer.MAX_VALUE;
	
			Zona zO = buscarZona(zOrigen);

			for (Object o : zO.getEsOrigenDeRutas()){
				
				ILista retorno = rutaMasRapidaREC(((Ruta)o).getDestino().getId(), zDestino, caminoRecorrido.clon());
				int duracion = duracion(retorno, false);
				
				if (mejorCamino == null || (retorno != null && duracion < mejorDuracion)){
					mejorCamino = retorno;
					mejorDuracion = duracion;
				}
			}
			return mejorCamino;
		}

	}
	
	//Metodo de la duracion
	// voy a recibir una duracion de ILista
	private int duracion(ILista lis, boolean printScreen){
		
		if (lis.largo() == 1){
			if (printScreen == true) System.out.println(((ListaSEFin)lis).mostrarX(0) + " - 0");
			return 0; 
		}
		else {
			int total = 0;
			Zona aux = null;
			for (Object o: lis){
				if (aux == null)
					aux = (Zona) o;
				else {
					Zona z = (Zona) o; 
					if (printScreen == true) System.out.println(aux.getNombre() + " - 0");
					
					for (Object o2: z.getEsOrigenDeRutas()){
						Ruta r = (Ruta) o2;
					
						if (r.getDestino().equals(aux)){
							total +=r.getMinutosViaje();
							if (printScreen == true) System.out.println(z+" - " + r.getMinutosViaje());
						}
					}
				}
			}
			if (printScreen == true) System.out.println("Total: " + total);
			return total; 
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
		Movil m = this.buscarMovilReturnIt(movilId);
		if (m!= null){
			Chofer c = new Chofer();
			c.setNombre(nombre);
			c.setCedula(cedula);
			m.choferes.insertar(c);
			return TipoRet.OK;
		}
		else {
			System.out.println("No existe un móvil con identificador " + movilId + ".");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet eliminarChofer(String movilId, String cedula) {
		Movil m = buscarMovilReturnIt(movilId);
		if (m != null){
			Chofer cho = m.buscarChofer(cedula);
			m.choferes.borrarElemento(cho);
			return TipoRet.OK;
		}
		else {
			System.out.println("No existe un móvil con identificador "+ movilId + ".");
			return TipoRet.ERROR1;
		}
		
	}

	@Override
	public TipoRet informeChoferes(String movilId) {
		Movil mov = this.buscarMovilReturnIt(movilId);
		if (mov != null){
			System.out.println("Informe Choferes de " + movilId);
			
			mov.printInforme();
			
			return TipoRet.OK;
		}
		else {
			System.out.println("No existe un móvil con identificador " +  movilId + ".");
			return TipoRet.ERROR1;
		}
	}

	@Override
	public TipoRet registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
		Zona zona = this.buscarZona(zonaID);
		if (zona != null){
			if (buscarAbonado(abonadoID) == null){
				Abonado ab = new Abonado(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel, zona);
				if (this.abonados == null) this.abonados = new ListaOrd(new AbonadoComparator());
				this.abonados.insertar(ab);
				return TipoRet.OK;
			}
			else {
				System.out.println("Ya existe un abonado con identificador " + abonadoID + ".");
				return TipoRet.ERROR2;
			}
		}
		else {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
		
	}
	
	public Abonado buscarAbonado(int idAbonado){
		for (Object o : this.abonados){
			if (((Abonado)o).getId() == idAbonado) return (Abonado) o;
		}
		return null;
	}

	@Override
	public TipoRet eliminarAbonado(int abonadoId) {
		boolean encontro = false;
		for (Object o : this.abonados){
			Abonado abo = (Abonado) o;
			if (abo.getId() == abonadoId){
				abonados.borrarElemento(abo);
				encontro = true;
			}
		}
		if (!encontro) {
			System.out.println("No existe un abonado con identificador " + abonadoId + ".");
			return TipoRet.ERROR1;
		}
		else return TipoRet.OK;
	}

	@Override
	public TipoRet informeAbonadosZona(int zonaID) {
		
		Zona zona = this.buscarZona(zonaID);
		if (zona != null){
			System.out.println("Informe de abonados en: " + zonaID + " - " + zona.getNombre());
			
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
		else {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
	}
	
}
