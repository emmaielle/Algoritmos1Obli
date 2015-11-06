package Main;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.Zona;
import Dominio.ISistema.TipoRet;

public class TestBasico {

	Sistema s = new Sistema(); 
	
	@Test
	public void testCrearSistemaSeguridad() {
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
	}

	@Test
	public void testDestruirSistemaSeguridad() {
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testAgregarZona() {
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
	}

	@Test
	public void testRegistrarMovil() {
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 02));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 03));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 02));
	}

	@Test
	public void testDeshabilitarMovil() {
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
	}

	@Test
	public void testHabilitarMovil() {
		assertEquals(TipoRet.OK, s.habilitarMovil("AAG204"));
	}

	@Test
	public void testEliminarMovil() {
		assertEquals(TipoRet.OK, s.eliminarMovil("AAG204"));
	}

	@Test
	public void testBuscarMovil() {
		assertEquals(TipoRet.OK, s.eliminarMovil("AAGUA14"));
	}

	@Test
	public void testBuscarMovilReturnIt() {
		assertEquals(TipoRet.OK, s.buscarMovilReturnIt("AAGUA14"));
	}

	@Test
	public void testInformeMovil() {
		assertEquals(TipoRet.OK, s.informeMovil());
	}

	@Test
	public void testInformeMovilInt() {
		assertEquals(TipoRet.OK, s.informeMovil(02));
	}

	@Test
	public void testRecibirLlamado() {
		assertEquals(TipoRet.OK, s.recibirLlamado("AAGUA14", 02));
	}

	@Test
	public void testCambiarUbicacion() {
		assertEquals(TipoRet.OK, s.cambiarUbicacion("AAGUA14", 02));
	}

	@Test
	public void testListarZonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarZona() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarRuta() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarDemora() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovilMasCercana() {
		fail("Not yet implemented");
	}

	@Test
	public void testRutaMasRapida() {
		fail("Not yet implemented");
	}

	@Test
	public void testRutaMasRapidaREC() {
		fail("Not yet implemented");
	}

	@Test
	public void testInformeZonas() {
		fail("Not yet implemented");
	}

	@Test
	public void testZonasEnRadio() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarChofer() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarChofer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInformeChoferes() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarAbonado() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarAbonado() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarAbonado() {
		fail("Not yet implemented");
	}

	@Test
	public void testInformeAbonadosZona() {
		fail("Not yet implemented");
	}

}
