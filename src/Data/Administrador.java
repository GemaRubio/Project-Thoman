package Data;
import java.sql.Date;
import java.util.ArrayList;

public class Administrador extends Usuario{
	
	protected String codigoAdmin; //Código del administrador

	public String getCodigoAdmin() {
		return codigoAdmin;
	}

	public void setCodigoAdmin(String codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}

	public Administrador(String nombre, String contrasenya, String email, double saldo, String cuentaPaypal,
			int nTarjeta, Date caducidadTarjeta, int codigoTarjeta, ArrayList<Instrumento> comprasRealizadas,
			String codigoAdmin) {
		super(nombre, contrasenya, email, saldo, cuentaPaypal, nTarjeta, caducidadTarjeta, codigoTarjeta,
				comprasRealizadas);
		this.codigoAdmin = codigoAdmin;
	}
	
	public Administrador() {
		super();
		this.codigoAdmin = "";
	}

	@Override
	public String toString() {
		return "Administrador [codigoAdmin=" + codigoAdmin + ", nombre=" + nombre + ", contrasenya=" + contrasenya
				+ ", email=" + email + ", saldo=" + saldo + ", cuentaPaypal=" + cuentaPaypal + ", nTarjeta=" + nTarjeta
				+ ", caducidadTarjeta=" + caducidadTarjeta + ", codigoTarjeta=" + codigoTarjeta + ", comprasRealizadas="
				+ comprasRealizadas + "]";
	}

}
