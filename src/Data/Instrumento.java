package Data;

public class Instrumento {
	
	protected String nombre;	// Nombre del Instrumento.
	protected String marca;		// Nombre de la marca del Instrumento.
	protected int precio;		// Precio del Instrumento.
	protected String descripcion;	// Descripcion del Instrumento.
	protected TipoInstrumento tipoInstrumento;	// Tipo de Instrumento.
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoInstrumento getTipoInstrumento() {
		return tipoInstrumento;
	}
	public void setTipoInstrumento(TipoInstrumento tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}

	public Instrumento(String nombre, String marca, int precio, String descripcion, TipoInstrumento tipoInstrumento) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tipoInstrumento = tipoInstrumento;
	}
	
	@Override
	public String toString() {
		return "Instrumento [nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", descripcion="
				+ descripcion + ", tipoInstrumento=" + tipoInstrumento + "]";
	}
	
}
