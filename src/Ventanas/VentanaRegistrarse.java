package Ventanas;

import java.awt.*;
import javax.swing.*;

public class VentanaRegistrarse  extends JFrame{

	public VentanaRegistrarse() {
		
		// Configuración de la ventana.
		setTitle("Ventana registrarse");
		setSize(750, 300);
		setLocation(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(4,3));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());

		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		JButton btnLogin = new JButton("Login");
		
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField txtUsuario = new JTextField();
		JLabel lErrorUsuario = new JLabel("El nombre está escogido o está vacío");
		lErrorUsuario.setForeground(Color.RED);
		lErrorUsuario.setVisible(false);
		JLabel lEmail = new JLabel("Email:");
		JTextField txtEmail = new JTextField();
		JLabel lErrorEmail = new JLabel("El email está en uso o está vacío");
		lErrorEmail.setForeground(Color.RED);
		lErrorEmail.setVisible(false);
		JLabel lContrasenya = new JLabel("Contraseña:");
		JPasswordField txtContrasenya = new JPasswordField();
		JLabel lErrorContrasenya = new JLabel("La contraseña no coincide o está vacía");
		lErrorContrasenya.setForeground(Color.RED);
		lErrorContrasenya.setVisible(false);
		JLabel lRepetirContrasenya = new JLabel("Repetir contraseña:");
		JPasswordField txtRepetirContrasenya = new JPasswordField();
		JLabel lErrorContrasenya2 = new JLabel("La contraseña no coincide o está vacía");
		lErrorContrasenya2.setForeground(Color.RED);
		lErrorContrasenya2.setVisible(false);
		JButton btnAceptar = new JButton("Aceptar");

		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnLogin);

		pCentro.add(lUsuario);
		pCentro.add(txtUsuario);
		pCentro.add(lErrorUsuario);
		pCentro.add(lEmail);
		pCentro.add(txtEmail);
		pCentro.add(lErrorEmail);
		pCentro.add(lContrasenya);
		pCentro.add(txtContrasenya);
		pCentro.add(lErrorContrasenya);
		pCentro.add(lRepetirContrasenya);
		pCentro.add(txtRepetirContrasenya);
		pCentro.add(lErrorContrasenya2);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);

		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}

