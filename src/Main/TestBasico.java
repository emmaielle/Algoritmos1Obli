package Main;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Sistema;
import Dominio.ISistema.TipoRet;

public class TestBasico {

	Sistema s = new Sistema(); 
	
	@Test
	public void testCrearSistemaSeguridad() {
		System.out.println("");
		System.out.println("------testCrearSistemaSeguridad------");
		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
	}

	@Test
	public void testDestruirSistemaSeguridad() {
		System.out.println("");
		System.out.println("------testDestruirSistemaSeguridad------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testAgregarZonaExceeded() {
		System.out.println("");
		System.out.println("------testAgregarZonaExceeded------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		System.out.println("");
		assertEquals(TipoRet.ERROR1, s.agregarZona("Cordon"));
		System.out.println("");
		assertEquals(TipoRet.ERROR1, s.agregarZona("Paso de la Arena"));	
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());

	}

	@Test
	public void testAgregarZonaCapacidadOK() {
		System.out.println("");
		System.out.println("------testAgregarZonaCapacidadOK------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(4));
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testRegistrarMovil() {
		System.out.println("");
		System.out.println("------testRegistrarMovil------");

		assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
		assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
		assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
		assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
		assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
		assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
		assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
		assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
		assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());

	}

	@Test
	public void testDeshabilitarMovil() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testHabilitarMovil() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.habilitarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testEliminarMovilEnViaje() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.ERROR2, s.eliminarMovil("AAG204"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testEliminarMovil() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.eliminarMovil("AAGUA14"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}
	
	@Test
	public void testBuscarMovil() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.buscarMovil("AAGUA14"));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testInformeMovil() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.informeMovil());
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testInformeMovilInt() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.informeMovil(2));
		
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testRecibirLlamado() {
		System.out.println("");
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
		
		System.out.println("");
		assertEquals(TipoRet.OK, s.recibirLlamado("AAGUA14", 2));
		assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
	}

	@Test
	public void testCambiarUbicacion() {
		try {
			System.out.println("");
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
			
			assertEquals(TipoRet.OK, s.recibirLlamado("AAGUA14", 2));
			System.out.println("");
			assertEquals(TipoRet.OK, s.cambiarUbicacion("AAGUA14", 2));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testCambiarUbicacionNoExisteMovil() {
		try {
			System.out.println("");
			System.out.println("------testCambiarUbicacionNoExisteMovil------");
	
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
			
			System.out.println("");
			assertEquals(TipoRet.ERROR2, s.cambiarUbicacion("AAGUT14", 2));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}
	
	@Test
	public void testListarZonas() {
		try {
			System.out.println("");
			System.out.println("------testListarZonas------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			System.out.println("");
			assertEquals(TipoRet.OK, s.listarZonas());
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testListarZonasVacio() {
		try {
			System.out.println("");
			System.out.println("------testListarZonasVacio------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			
			System.out.println("");
			assertEquals(TipoRet.OK, s.listarZonas());
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testAgregarRuta() {
		try {
			System.out.println("");
			System.out.println("-----testAgregarRuta------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.agregarRuta(9, 2, 5));
			System.out.println("");
			assertEquals(TipoRet.ERROR2, s.agregarRuta(1, 9, 5));
			System.out.println("");
			assertEquals(TipoRet.ERROR3, s.agregarRuta(1, 2, 0));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testModificarDemora() {
		try {
			System.out.println("");
			System.out.println("-----testModificarDemora------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));

			System.out.println("");
			assertEquals(TipoRet.OK, s.modificarDemora(4, 5, 7));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.modificarDemora(9, 2, 5));
			System.out.println("");
			assertEquals(TipoRet.ERROR2, s.modificarDemora(1, 9, 5));
			System.out.println("");
			assertEquals(TipoRet.ERROR3, s.modificarDemora(1, 2, 0));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testMovilMasCercana() {
		try {
			System.out.println("");
			System.out.println("-----testMovilMasCercana------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));

			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			
			System.out.println("");
			assertEquals(TipoRet.OK, s.movilMasCercana(2));
			System.out.println("");
			assertEquals(TipoRet.OK, s.movilMasCercana(1));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.movilMasCercana(9));
			System.out.println("");
			assertEquals(TipoRet.OK, s.movilMasCercana(5));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}
	
	@Test
	public void testMovilMasCercanaSinMoviles() {
		try {
			System.out.println("");
			System.out.println("-----testMovilMasCercanaSinMoviles------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));

			System.out.println("");
			assertEquals(TipoRet.OK, s.movilMasCercana(2));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testRutaMasRapida() {
		try {
			System.out.println("");
			System.out.println("-----testRutaMasRapida------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 4, 25));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));

			System.out.println("");
			assertEquals(TipoRet.OK, s.rutaMasRapida(1, 3));
			System.out.println("");
			assertEquals(TipoRet.OK, s.rutaMasRapida(1, 4));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.rutaMasRapida(9, 3));
			System.out.println("");
			assertEquals(TipoRet.ERROR2, s.rutaMasRapida(1, 9));
			System.out.println("");
			assertEquals(TipoRet.OK, s.rutaMasRapida(1, 1));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testInformeZonas() {
		try {
			System.out.println("");
			System.out.println("-----testInformeZonas------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			System.out.println("");
			assertEquals(TipoRet.OK, s.informeZonas());
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testZonasEnRadio() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarChofer() {
		try {
			System.out.println("");
			System.out.println("-----testRegistrarChofer------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.registrarChofer("AJSIDS02", "Mario Perez", "4.325.353-8"));
			System.out.println("");
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Mario Perez", "4.325.353-8"));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testEliminarChofer() {
		try {
			System.out.println("");
			System.out.println("-----testEliminarChofer------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Mario Perez", "4.325.353-8"));
			
			System.out.println("");
			assertEquals(TipoRet.OK, s.eliminarChofer("AAG204", "4.325.353-8"));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.eliminarChofer("AAG23204", "4.325.353-8"));

		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testInformeChoferes() {
		try {
			System.out.println("");
			System.out.println("-----testInformeChoferes------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Lorne Michaels", "4.325.353-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Hey Chopp", "4.375.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Joe Don", "3.575.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "The Matrix", "3.575.343-8"));
			
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.informeChoferes("SAG204"));
			System.out.println("");
			assertEquals(TipoRet.OK, s.informeChoferes("QOG324"));
			System.out.println("");
			assertEquals(TipoRet.OK, s.informeChoferes("AAG204"));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testRegistrarAbonado() {
		try {
			System.out.println("");
			System.out.println("-----testRegistrarAbonado------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Lorne Michaels", "4.325.353-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Hey Chopp", "4.375.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Joe Don", "3.575.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "The Matrix", "3.575.343-8"));
			
			System.out.println("");
			assertEquals(TipoRet.OK, s.registrarAbonado(32, "Un Nombre", "Una direccion", "Un teléfono", 2));
			System.out.println("");
			assertEquals(TipoRet.ERROR2, s.registrarAbonado(32, "Un Nombre", "Una direccion", "Un teléfono", 2));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.registrarAbonado(12, "Un Nombre", "Una direccion", "Un teléfono", 7));

		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testEliminarAbonado() {
		try {
			System.out.println("");
			System.out.println("-----testEliminarAbonado------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Lorne Michaels", "4.325.353-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Hey Chopp", "4.375.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Joe Don", "3.575.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "The Matrix", "3.575.343-8"));
			
			assertEquals(TipoRet.OK, s.registrarAbonado(32, "Un Nombre", "Una direccion", "Un teléfono", 2));
			
			System.out.println("");
			assertEquals(TipoRet.OK, s.eliminarAbonado(32));
			System.out.println("");
			assertEquals(TipoRet.ERROR1, s.eliminarAbonado(32));
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

	@Test
	public void testInformeAbonadosZona() {
		try {
			System.out.println("");
			System.out.println("-----testInformeAbonadosZona------");
	
			assertEquals(TipoRet.OK, s.crearSistemaSeguridad(6));
			assertEquals(TipoRet.OK, s.agregarZona("Piedras Blancas"));
			assertEquals(TipoRet.OK, s.agregarZona("La Comercial"));
			assertEquals(TipoRet.OK, s.agregarZona("Carrasco"));
			assertEquals(TipoRet.OK, s.agregarZona("Pocitos"));
			assertEquals(TipoRet.OK, s.agregarZona("Cordon"));
			assertEquals(TipoRet.OK, s.agregarZona("Paso de la Arena"));	

			assertEquals(TipoRet.OK, s.agregarRuta(1, 2, 5));
			assertEquals(TipoRet.OK, s.agregarRuta(1, 6, 11));
			assertEquals(TipoRet.OK, s.agregarRuta(2, 6, 8));
			assertEquals(TipoRet.OK, s.agregarRuta(6, 3, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(3, 4, 15));
			assertEquals(TipoRet.OK, s.agregarRuta(4, 5, 9));
			assertEquals(TipoRet.OK, s.registrarMovil("AAG204", 2));
			assertEquals(TipoRet.OK, s.registrarMovil("AAGUA14", 3));
			assertEquals(TipoRet.OK, s.registrarMovil("QOG324", 2));
			assertEquals(TipoRet.OK, s.deshabilitarMovil("AAG204"));

			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Lorne Michaels", "4.325.353-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Hey Chopp", "4.375.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "Joe Don", "3.575.343-8"));
			assertEquals(TipoRet.OK, s.registrarChofer("AAG204", "The Matrix", "3.575.343-8"));
			
			assertEquals(TipoRet.OK, s.registrarAbonado(32, "Un Nombre", "Una direccion", "0495834", 2));
			assertEquals(TipoRet.OK, s.registrarAbonado(31, "Clara Black", "Here", "598 5634534", 2));
			assertEquals(TipoRet.OK, s.registrarAbonado(30, "Sea White", "Not here", "1 305934", 2));
			assertEquals(TipoRet.OK, s.registrarAbonado(29, "Black Jack", "21 Street", "484234", 2));
			assertEquals(TipoRet.OK, s.registrarAbonado(28, "Tardis", "Time and relative dimension space", "53K", 2));

			assertEquals(TipoRet.ERROR1, s.informeAbonadosZona(7));
			System.out.println("");
			assertEquals(TipoRet.OK, s.informeAbonadosZona(1));
			System.out.println("");
			assertEquals(TipoRet.OK, s.informeAbonadosZona(2));
			
		}
		finally {
			assertEquals(TipoRet.OK, s.destruirSistemaSeguridad());
		}
	}

}
