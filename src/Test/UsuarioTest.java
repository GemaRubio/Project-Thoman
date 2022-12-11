package Test;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Data.Instrumento;
import Data.Usuario;

public class UsuarioTest {
	
	protected Usuario u;
	protected String nombre;	// Nombre del Usuario.
	protected String contrasenya;	// Contraseña del Usuario.
	protected String email;	// Email del Usuario.
	protected double saldo;	// Saldo del Usuario.
	protected String cuentaPaypal; //Número de cuenta de Paypal
	protected String nTarjeta; //Número de la tarjeta
	protected String caducidadTarjeta; //Fecha de caducidad de la tarjeta (Formato dd//mm/aaaa)
	protected String codigoTarjeta; //Código de la tarjeta
	protected ArrayList<Instrumento> comprasRealizadas;
	
	@Before
	public void setUp() throws Exception {
		u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}
	
	/*
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
    */
	
	@Test
	void testUsuario() {
	}
	
	@Test
	void testGetNombre() {
	}
	
	@Test
	void testSetNombre() {
	}
	
//TODO el resto de test de la clase de usuario


}
