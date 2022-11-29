package Ventanas;

import java.awt.*;
import javax.swing.*;

public class VentanaAdmin extends JFrame{
	
	public VentanaAdmin() {
		
		// Configuración de la ventana.
		setTitle("Ventana administrador");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1,4));
		
		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		
		JButton btnComprar = new JButton("Comprar");
		JButton btnCodigoFuente = new JButton("Código fuente");
		JButton btnVerBaseDatos = new JButton("Ver base de datos");
		JButton btnVerFicheros = new JButton("Ver ficheros");
		
		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pCentro.add(btnComprar);
		pCentro.add(btnCodigoFuente);
		pCentro.add(btnVerBaseDatos);
		pCentro.add(btnVerFicheros);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}
