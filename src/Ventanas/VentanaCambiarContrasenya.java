package Ventanas;

import java.awt.*;
import javax.swing.*;

public class VentanaCambiarContrasenya extends JFrame {
	
	public VentanaCambiarContrasenya() {
		
		// Configuración de la ventana.
		setTitle("Ventana cambiar contraseña");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(3,3));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());
		
		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		JButton btnRegistrarse = new JButton("Atrás");
		
		JLabel lContrasenyaActual = new JLabel("Contraseña actual:");
		JPasswordField txtContrasenyaActual = new JPasswordField();
		JLabel lErrorContrasenyaActual = new JLabel("La contraseña no es correcta.");
		lErrorContrasenyaActual.setForeground(Color.RED);
		lErrorContrasenyaActual.setVisible(false);
		JLabel lContrasenyaNueva = new JLabel("Contraseña nueva:");
		JPasswordField txtContrasenyaNueva = new JPasswordField();
		JPanel pPanelVacio5 = new JPanel();
		JLabel lContrasenyaRepetir = new JLabel("Repite la contraseña nueva:");
		JPasswordField txtContrasenyaRepetir = new JPasswordField();
		JLabel lErrorContrasenyaRepetir = new JLabel("La contraseña no coincide.");
		lErrorContrasenyaRepetir.setForeground(Color.RED);
		lErrorContrasenyaRepetir.setVisible(false);
		JButton btnAceptar = new JButton("Aceptar");
		
		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lContrasenyaActual);
		pCentro.add(txtContrasenyaActual);
		pCentro.add(lErrorContrasenyaActual);
		pCentro.add(lContrasenyaNueva);
		pCentro.add(txtContrasenyaNueva);
		pCentro.add(pPanelVacio5);
		pCentro.add(lContrasenyaRepetir);
		pCentro.add(txtContrasenyaRepetir);
		pCentro.add(lErrorContrasenyaRepetir);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}
