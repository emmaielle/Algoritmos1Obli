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
		System.out.println("------testCrearSistemaSeguridad------");
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
	}

	@Test
	public void testDestruirSistemaSeguridad() {
		System.out.println("------testDestruirSistemaSeguridad------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testAgregarZonaExceeded() {
		System.out.println("------testAgregarZonaExceeded------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.ERROR1, s.agregarZona("Cordon"));
		assertEquals(TipoRet.ERROR1, s.agregarZona("Paso de la Arena"));	
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());

	}

	@Test
	public void testAgregarZonaCapacidadOK() {
		System.out.println("------testAgregarZonaCapacidadOK------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testRegistrarMovil() {
		System.out.println("------testRegistrarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());

	}

	@Test
	public void testDeshabilitarMovil() {
		System.out.println("------testDeshabilitarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testHabilitarMovil() {
		System.out.println("------testHabilitarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.habilitarMovil("AAG204"));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testEliminarMovil() {
		System.out.println("------testEliminarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.eliminarMovil("AAG204"));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testBuscarMovil() {
		System.out.println("------testBuscarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.buscarMovil("AAGUA14"));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testReturnMovil() {
		System.out.println("------testReturnMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.returnMovil("AAGUA14"));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testInformeMovil() {
		System.out.println("------testInformeMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.informeMovil());
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testInformeMovilInt() {
		System.out.println("------testInformeMovilInt------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.informeMovil(2));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testRecibirLlamado() {
		System.out.println("------testRecibirLlamado------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.recibirLlamado("AAGUA14", 2));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testCambiarUbicacion() {
		try {
			System.out.println("------testCambiarUbicacion------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
			
			assertEquals(TipoRet.OK, s.cambiarUbicacion("AAGUA14", 2));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
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
