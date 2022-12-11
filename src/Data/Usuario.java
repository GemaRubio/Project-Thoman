package Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Serializable{
	
	protected String nombre;	// Nombre del Usuario.
	protected String contrasenya;	// Contraseña del Usuario.
	protected String email;	// Email del Usuario.
	protected double saldo;	// Saldo del Usuario.
	protected String cuentaPaypal; //Número de cuenta de Paypal
	protected String nTarjeta; //Número de la tarjeta
	protected String caducidadTarjeta; //Fecha de caducidad de la tarjeta (Formato dd//mm/aaaa)
	protected String codigoTarjeta; //Código de la tarjeta
	protected ArrayList<Instrumento> comprasRealizadas;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getCuentaPaypal() {
		return cuentaPaypal;
	}
	public void setCuentaPaypal(String cuentaPaypal) {
		this.cuentaPaypal = cuentaPaypal;
	}
	public String getnTarjeta() {
		return nTarjeta;
	}
	public void setnTarjeta(String nTarjeta) {
		this.nTarjeta = nTarjeta;
	}
	public String getCaducidadTarjeta() {
		return caducidadTarjeta;
	}
	public void setCaducidadTarjeta(String caducidadTarjeta) {
		this.caducidadTarjeta = caducidadTarjeta;
	}
	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}
	public void setCodigoTarjeta(String codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}
	public ArrayList<Instrumento> getComprasRealizadas() {
		return comprasRealizadas;
	}
	public void setComprasRealizadas(ArrayList<Instrumento> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}
	
	public Usuario(String nombre, String contrasenya, String email, double saldo, String cuentaPaypal, String nTarjeta,
			String caducidadTarjeta, String codigoTarjeta, ArrayList<Instrumento> comprasRealizadas) {
		super();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.email = email;
		this.saldo = saldo;
		this.cuentaPaypal = cuentaPaypal;
		this.nTarjeta = nTarjeta;
		this.caducidadTarjeta = caducidadTarjeta;
		this.codigoTarjeta = codigoTarjeta;
		this.comprasRealizadas = comprasRealizadas;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenya=" + contrasenya + ", email=" + email + ", saldo=" + saldo
				+ ", cuentaPaypal=" + cuentaPaypal + ", nTarjeta=" + nTarjeta + ", caducidadTarjeta=" + caducidadTarjeta
				+ ", codigoTarjeta=" + codigoTarjeta + ", comprasRealizadas=" + comprasRealizadas + "]";
	}

}
