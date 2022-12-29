import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Data.Administrador;
import Data.Instrumento;
import Data.Usuario;
import Ventanas.*;

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal vp = new VentanaPrincipal();
	//	VentanaRegistrarse vr = new VentanaRegistrarse();
	//	VentanaLogin vl = new VentanaLogin();
	//	VentanaVerCarrito vvc = new VentanaVerCarrito();
	//	VentanaVerPerfil vvp = new VentanaVerPerfil();	//TODO Falta por completar
	//	VentanaCambiarContrasenya vcc = new VentanaCambiarContrasenya();
	//	VentanaCambiarEmail vce = new VentanaCambiarEmail();
	//	VentanaCambiarMetodosPago vcmp = new VentanaCambiarMetodosPago();
	//	VentanaAjustes va = new VentanaAjustes();
	//	VentanaAdmin va = new VentanaAdmin();
	//	VentanaServicioAyuda vsa = new VentanaServicioAyuda();
	//	VentanaSeleccionMetodoPago vsmp = new VentanaSeleccionMetodoPago();
		
	// TODO Date clase usuarios
		
	File f = new File("src\\Files\\ficheroUsuarios.dat");
		
	Usuario u1 = new Usuario("Fede", "fede", "fede@gmail.com", 0, "", "", "", "", new ArrayList<Instrumento>());
	Administrador a1 = new Administrador("Admin", "admin", "admin@gmail.com", 0, "", "", "", "", new ArrayList<Instrumento>(), "ASDF576");
	
	try {
		if(!f.exists()) {
			FileOutputStream ficheroUsuarios = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(ficheroUsuarios);
			oos.writeObject(u1);
		        oos.writeObject(a1);
			oos.close();
		} 
	}catch (IOException e) {
		e.printStackTrace();
	}
	}

}
