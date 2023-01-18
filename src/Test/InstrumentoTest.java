package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Data.Instrumento;
import Data.TipoInstrumento;
import Data.Usuario;

public class InstrumentoTest {
	
	protected Instrumento i;
	protected String nombre;	
	protected String marca;		
	protected int precio;		
	protected String descripcion;	
	protected TipoInstrumento tipoInstrumento;	

	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	*/

	@Before
	public void setUp() throws Exception {
		i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);
	}

	@After
	public void tearDown() throws Exception {
		i = null;
	}

	@Test
	public void testInstrumento() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals("Guitarra", i.getNombre());
		assertEquals("Gibson", i.getMarca());
		assertEquals(900, i.getPrecio(), 0);
		assertEquals("Guitarra clasica de madera", i.getDescripcion());
		assertEquals(tipoInstrumento.CUERDA, i.getTipoInstrumento());
		
	}
	
	@Test
	public void testGetNombre() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals("Guitarra", i.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		Instrumento i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);
		i.setNombre("Guitarra");
		assertEquals("Guitarra", i.getNombre());
	}
	
	@Test
	public void testGetMarca() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals("juanito86", i.getMarca());
	}
	
	@Test 
	public void testSetMarca() {
		Instrumento i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);
		i.setMarca("Gibson");
		assertEquals("Gibson", i.getMarca());
	}
	
	@Test 
	public void testGetPrecio() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals(900, i.getPrecio(), 0);
	}
	
	@Test
	public void testSetPrecio() {
		Instrumento i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);		
		i.setPrecio(900);;
		assertEquals(900, i.getPrecio(), 0);
	}
	
	@Test
	public void testGetDescripcion() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals("Guitarra clasica de madera", i.getDescripcion());
	}
	
	@Test
	public void testSetDescripcion() {
		Instrumento i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);
		i.setDescripcion("Guitarra clasica de madera");
		assertEquals("Guitarra clasica de madera", i.getDescripcion());
	}
	
	public void testGettipoInstrumento() {
		Instrumento i = new Instrumento("Guitarra", "Gibson", 900, "Guitarra clasica de madera", tipoInstrumento.CUERDA);
		assertEquals(tipoInstrumento.CUERDA, i.getTipoInstrumento());
	}
	
	@Test
	public void testSettipoInstrumento() {
		Instrumento i = new Instrumento(nombre, marca, precio, descripcion, tipoInstrumento);
		i.setTipoInstrumento(tipoInstrumento.CUERDA);
		assertEquals(tipoInstrumento.CUERDA, i.getTipoInstrumento());
	}

}
