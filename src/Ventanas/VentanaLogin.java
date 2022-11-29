package Ventanas;

import java.awt.*;
import javax.swing.*;

public class VentanaLogin extends JFrame{
	
	public VentanaLogin() {
		
		// Configuración de la ventana.
		setTitle("Ventana login");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2,3));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());
		
		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		JButton btnRegistrarse = new JButton("Registrarse");
		
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField txtUsuario = new JTextField();
		JLabel lErrorUsuario = new JLabel("No existe el usuario");
		lErrorUsuario.setForeground(Color.RED);
		lErrorUsuario.setVisible(false);
		JLabel lContrasenya = new JLabel("Contraseña:");
		JPasswordField txtContrasenya = new JPasswordField();
		JLabel lErrorContrasenya = new JLabel("Contraseña incorrecta");
		lErrorContrasenya.setForeground(Color.RED);
		lErrorContrasenya.setVisible(false);
		JButton btnAceptar = new JButton("Aceptar");
		
		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lUsuario);
		pCentro.add(txtUsuario);
		pCentro.add(lErrorUsuario);
		pCentro.add(lContrasenya);
		pCentro.add(txtContrasenya);
		pCentro.add(lErrorContrasenya);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}

