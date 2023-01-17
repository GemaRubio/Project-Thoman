package Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Test;

import Data.Administrador;
import Data.Instrumento;

public class AdministradorTest {
	
	@Test
	public void testAdministrador() {
		Administrador a = new Administrador("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", new ArrayList<Instrumento>(), "ADMIN16");
		assertEquals("Juan", a.getNombre());
		assertEquals("juanito86", a.getContrasenya());
		assertEquals("juanalberto@gmail.com", a.getEmail());
		assertEquals(12, a.getSaldo(), 0);
		assertEquals("JuanPaga", a.getCuentaPaypal());
		assertEquals("0456 3452 1675 0100", a.getnTarjeta());
		assertEquals("09/24", a.getCaducidadTarjeta());
		assertEquals("312", a.getCodigoTarjeta());
		assertEquals("ADMIN16", a.getCodigoAdmin());
	}
	
	@Before
	public void setUp() throws Exception {
		a = new Usuario(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta, comprasRealizadas, codigoAdmin);
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}
	
	@Test
	public void testGetCodigoAdmin() {
		Administrador a = new Administrador("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", new ArrayList<Instrumento>(), "ADMIN16");
		assertEquals("ADMIN16", a.getCodigoAdmin());
	}
	
	@Test
	public void testSetCodigoAdmin() {
		Administrador a = new Administrador("Juan", "juanito86", "juanalberto@gmail.com", 12, "JuanPaga", "0456 3452 1675 0100", "09/24", "312", new ArrayList<Instrumento>(), "ADMIN16");
		a.setCodigoAdmin("ADMIN1245");
		assertEquals("ADMIN1245", a.getCodigoAdmin());
	}

}

