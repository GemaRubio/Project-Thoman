package Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Data.Instrumento;
import Data.TipoInstrumento;
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
	//Para el saldo he usado el assertEquals(double expected, double actual, double epsilon), ya que el assertEquals(double expected, double actual) estaba marcado como "Deprecated"
	@Test
	public void testUsuario() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("Juan", u.getNombre());
		assertEquals("juanito86", u.getContrasenya());
		assertEquals("juanalberto@gmail.com", u.getEmail());
		assertEquals(12, u.getSaldo(), 0);
		assertEquals("JuanPaga", u.getCuentaPaypal());
		assertEquals("0456 3452 1675 0100", u.getnTarjeta());
		assertEquals("09/24", u.getCaducidadTarjeta());
		assertEquals("312", u.getCodigoTarjeta());
	}
	
	@Test
	public void testGetNombre() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("Juan", u.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setNombre("Juan");
		assertEquals("Juan", u.getNombre());
	}
	
	@Test
	public void testGetContrasenya() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("juanito86", u.getContrasenya());
	}
	
	@Test 
	public void testSetContrasenya() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setContrasenya("juanito86");
		assertEquals("juanito86", u.getContrasenya());
	}
	
	@Test 
	public void testGetEmail() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("juanalberto@gmail.com", u.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setEmail("juanalberto@gmail.com");
		assertEquals("juanalberto@gmail.com", u.getEmail());
	}
	
	@Test
	public void testGetSaldo() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals(12, u.getSaldo(), 0);
	}
	
	@Test
	public void testSetSaldo() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setSaldo(12);
		assertEquals(12, u.getSaldo(), 0);
	}
	
	@Test
	public void testGetCuentaPypal() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("JuanPaga", u.getCuentaPaypal());
	}
	
	@Test
	public void testSetCuentaPaypal() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setCuentaPaypal("JuanPaga");
		assertEquals("JuanPaga", u.getCuentaPaypal());
	}
	
	@Test
	public void testGetnTarjeta() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("0456 3452 1675 0100", u.getnTarjeta());
	}
	
	@Test
	public void testSetnTarjeta() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setnTarjeta("0456 3452 1675 0100");
		assertEquals("0456 3452 1675 0100", u.getnTarjeta());
	}
	
	@Test
	public void testGetCaducidadTarjeta() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("09/24", u.getCaducidadTarjeta());
	}
	
	@Test
	public void testSetCaducidadTarjeta() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setCaducidadTarjeta("09/24");
		assertEquals("09/24", u.getCaducidadTarjeta());
	}
	
	@Test
	public void testGetCodigoTarjeta() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		assertEquals("312", u.getCodigoTarjeta());
	}

	@Test
	public void testSetCodigoTarjeta() {
		Usuario u = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas);
		u.setCodigoTarjeta("312");
		assertEquals("312", u.getCodigoTarjeta());
	}
	
	@Test
	public void testGetComprasRealizadas() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		ArrayList<Instrumento> compras = new ArrayList<>();
		compras.add(new Instrumento("Piano", "Thomann", 1320, "Piano negro de cola", TipoInstrumento.CUERDA));
		assertEquals(5, compras.size());
		assertEquals("Piano", compras.get(0));
		assertEquals("Thoman", compras.get(1));
		assertEquals(1320, compras.get(2));
		assertEquals("Piano negro de cola", compras.get(3));
		assertEquals(TipoInstrumento.CUERDA, compras.get(4));
		assertEquals(compras, u.getComprasRealizadas());
		}
	
	@Test
	public void testSetComprasRealizadas() {
		Usuario u = new Usuario("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", comprasRealizadas);
		ArrayList<Instrumento> compras = new ArrayList<>();
		compras.add(new Instrumento("Piano", "Thomann", 1320, "Piano negro de cola", TipoInstrumento.CUERDA));
		u.setComprasRealizadas(compras);
		assertEquals(compras, u.getComprasRealizadas());
	}
}
