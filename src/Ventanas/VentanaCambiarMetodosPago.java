package Ventanas;

import java.awt.*;
import javax.swing.*;

public class VentanaCambiarMetodosPago extends JFrame {
	
	public VentanaCambiarMetodosPago() {
		
		// Configuración de la ventana.
		setTitle("Ventana cambiar métodos de pago");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(4,2));
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
		
		JLabel lCuentaPaypal = new JLabel("Número de cuenta de PayPal:");
		JTextField txtCuentaPaypal = new JTextField();
		JLabel lNTarjeta = new JLabel("Número de tarjeta:");
		JTextField txtNTarjeta = new JTextField();
		JLabel lCaducidadTarjeta = new JLabel("Fecha de caducidad de la tarjeta:");
		JTextField txtCaducidadTarjeta = new JTextField();
		JLabel lCodigoTarjeta = new JLabel("Código de la tarjeta:");
		JTextField txtCodigoTarjeta = new JTextField();

		JButton btnAceptar = new JButton("Aceptar");
		
		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lCuentaPaypal);
		pCentro.add(txtCuentaPaypal);
		pCentro.add(lNTarjeta);
		pCentro.add(txtNTarjeta);
		pCentro.add(lCaducidadTarjeta);
		pCentro.add(txtCaducidadTarjeta);
		pCentro.add(lCodigoTarjeta);
		pCentro.add(txtCodigoTarjeta);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}
