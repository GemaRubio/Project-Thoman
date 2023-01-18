package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Data.TipoInstrumento;

public class TipoInstrumentoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("CUERDA", TipoInstrumento.CUERDA.name());
		assertEquals("VIENTO", TipoInstrumento.VIENTO.name());
		assertEquals("PERCUSION", TipoInstrumento.PERCUSION.name());
	}

}
