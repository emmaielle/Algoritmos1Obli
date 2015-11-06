package Dominio;


import Dominio.Movil.Estado;
import Listas.AbonadoComparator;
import Listas.ListaOrd;
import Listas.ListaSEIni;
import Listas.MovilComparator;

public class Sistema implements ISistema {

	ListaSEIni zonas;
	ListaOrd moviles;
	int cantZonas;
	ListaOrd abonados;

	@Override
	public TipoRet crearSistemaSeguridad(int cantZonas) {
		//New de listas, inicializacion de cantZonas
		
		if (cantZonas >= 1){
			zonas = new ListaSEIni();
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
		zonas.vaciar();
		moviles.vaciar();
		abonados.vaciar();
		cantZonas = 0;
		return TipoRet.OK;
	}

	@Override
	public TipoRet registrarMovil(String movilID, int zonaID) {
		if (this.buscarZona(zonaID) == null) {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
		if (buscarMovil(movilID).equals(TipoRet.OK)) {
			System.out.println("Ya existe una móvil con identificador " + movilID +".");
			return TipoRet.ERROR2;
		}
		
		Movil mov = new Movil(movilID, this.buscarZona(zonaID));
		moviles.insertar((Object) mov);
		this.buscarZona(zonaID).getMoviles().insertar(mov);
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
		Movil m = this.buscarMovilReturnIt(movilID);
		if (m == null){
			System.out.println("No existe un móvil con identificador " + movilID);
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
			mov.getLlamados().borrarElemento(mov);
			return TipoRet.OK;
		}
		else {
			System.out.println("No existe un móvil con identificador " + movilID + ".");
			return TipoRet.ERROR1;
		}
	}

	// incompleto
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
			System.out.println("Zona:" + m.getLlamados());
			System.out.println("#Llamados:" + m.getLlamados()); // falta count
			return TipoRet.OK;
		}
	}

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
		return TipoRet.NO_IMPLEMENTADA;
	}

	@Override
	public TipoRet agregarZona(String zonaNombre) {
		
		//aca hay que controlar que no se pase del numero maximo cantZonas, y sino que no la agregue
		// if cantzonas > listaZonas.count --> agregar
		
//		Zona z5 = new Zona();
//		z5.setNombre("Cordon");
//		z5.setId(05);
//		zonas.insertar(z5);
//		
		
		return TipoRet.NO_IMPLEMENTADA;
		
		// aca es donde se crean las zonas, por eso borre todo lo otro, que lo pase a la clase de testing
		
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
				//----------
				System.out.println("Ruta más rápida:");
				this.rutaMasRapidaREC(zOrigen, zonaDestino, 0, new ListaSEIni());
				
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
	public void rutaMasRapidaREC(Zona zOrigen, int zDestino, int tiempoAcumulado, ListaSEIni caminoRecorrido){ 
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
				if (ruta.getMinutosViaje() < t){
					boolean yaPaso = false;
					for (Object ob : caminoRecorrido){
						Zona zLoop = (Zona) ob;
						if (zLoop.equals(zAux)) yaPaso = true;
					}
					if (!yaPaso)
					{
						t = tiempoAcumulado + ruta.getMinutosViaje();
						z = zAux;
						caminoRecorrido.agregarFinal(z);
					}
				}
			}
			System.out.println(z.getNombre() + " - " + t);
			rutaMasRapidaREC(z, zDestino, t, caminoRecorrido);
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
			// saque el controlar que el chofer no sea null porque en una pregunta de foro dice que lo tomes como PRE
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

	// (moira) lo modifique porque iba a andar mal
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
		else {
			System.out.println("La zona " + zonaID + " no existe.");
			return TipoRet.ERROR1;
		}
	}
	
}
